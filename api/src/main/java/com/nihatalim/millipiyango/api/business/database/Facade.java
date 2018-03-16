package com.nihatalim.millipiyango.api.business.database;

import com.nihatalim.millipiyango.api.models.Loto;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component(value = "dbFacade")
public class Facade {

    public Loto checkForRegistry(Session session, Loto.LotoType type, String date){
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyyMMdd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        List lotos = session.createCriteria(Loto.class).add(Restrictions.and(
                Restrictions.eq("cekilisTuru", type),
                Restrictions.eq("cekilisTarihi", date1)
        )).list();

        if(lotos != null && lotos.size()>0){
            return (Loto) lotos.get(0);
        }
        return null;
    }

    public void saveLoto(Session session, Loto loto) {
        this.save(session,loto);
        loto.getBilenKisiler().forEach(w-> w.setLoto(loto));
        loto.getBuyukIkrKazananIlIlceler().forEach(w->w.setLoto(loto));
        this.save(session, loto.getBilenKisiler());
        this.save(session, loto.getBuyukIkrKazananIlIlceler());
    }

    private void save(Session session, Object o){
        if(o == null) return;
        session.save(o);
    }

    private void save(Session session, List os){
        if(os == null) return;

        for (Object o:os) {
            this.save(session,o);
        }
    }

}
