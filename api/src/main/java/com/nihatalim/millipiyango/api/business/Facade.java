package com.nihatalim.millipiyango.api.business;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nihatalim.millipiyango.api.helpers.DateSerializeHelper;
import com.nihatalim.millipiyango.api.models.Loto;
import com.nihatalim.millipiyango.api.utils.HibernateUtil;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Facade {

    @Autowired
    private com.nihatalim.millipiyango.api.business.database.Facade dbFacade;

    private Map<Loto.LotoType, int[]> weekDayOfLoto = null;
    private SimpleDateFormat dateFormat = null;
    private final String URL_SAYISAL = "http://www.millipiyango.gov.tr/sonuclar/cekilisler/sayisal/";
    private final String URL_SUPERLOTO = "http://www.millipiyango.gov.tr/sonuclar/cekilisler/superloto/";
    private final String URL_ONNUMARA = "http://www.millipiyango.gov.tr/sonuclar/cekilisler/onnumara/";
    private final String URL_SANSTOPU = "http://www.millipiyango.gov.tr/sonuclar/cekilisler/sanstopu/";


    public Facade() {
        this.dateFormat = new SimpleDateFormat("yyyyMMdd");

        weekDayOfLoto = new HashMap<>();
        weekDayOfLoto.put(Loto.LotoType.ON_NUMARA, new int[]{Calendar.MONDAY-1});
        weekDayOfLoto.put(Loto.LotoType.SANS_TOPU, new int[]{Calendar.WEDNESDAY-1});
        weekDayOfLoto.put(Loto.LotoType.SAYISAL_LOTO, new int[]{Calendar.SATURDAY-1});
        weekDayOfLoto.put(Loto.LotoType.SUPER_LOTO, new int[]{Calendar.THURSDAY-1});
    }

    public Loto lookup(Loto.LotoType type, String date) {
        String url = "";
        Document document = null;
        GsonBuilder builder = null;
        JsonElement lotoJson = null;
        Loto loto = null;
        Session session = null;

        switch (type) {
            case SAYISAL_LOTO:
                url = URL_SAYISAL + date + ".json";
                break;

            case ON_NUMARA:
                url = URL_ONNUMARA + date + ".json";
                break;

            case SANS_TOPU:
                url = URL_SANSTOPU + date + ".json";
                break;

            case SUPER_LOTO:
                url = URL_SUPERLOTO + date + ".json";
                break;

        }

        if(!this.checkScheduleForLoto(type,date)) return null;

        session = HibernateUtil.getSessionFactory().openSession();

        loto = this.dbFacade.checkForRegistry(session, type, date);
        if ( loto != null){
            return loto;
        }

        try {
            document = Jsoup.connect(url).ignoreContentType(true).get();

            JsonObject jsonObject = new JsonParser().parse(document.body().text()).getAsJsonObject();

            lotoJson = jsonObject.get("data");
        } catch (Exception e) {
            return null;
        }

        builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializeHelper());

        loto = builder.create().fromJson(lotoJson, Loto.class);

        this.dbFacade.saveLoto(session, loto);
        session.close();
        return loto;
    }

    private boolean checkScheduleForLoto(Loto.LotoType type, String date){
        Date date1 = null;
        try {
            date1 = this.dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(date1!=null){
            DateTime dateTime = new DateTime().withDate(LocalDate.fromDateFields(date1));

            for (int d:weekDayOfLoto.get(type)) {
                if(d == dateTime.dayOfWeek().get()){
                    return true;
                }
            }

        }
        return false;
    }

}
