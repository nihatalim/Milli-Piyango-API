package com.nihatalim.millipiyango.api.helpers;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializeHelper implements JsonSerializer<Date>, JsonDeserializer<Date>{
    private static final String[] DATE_FORMATS = new String[]{
            "dd/MM/yyyy"
    };

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        for (String format: DATE_FORMATS){
            try{
                String str = new SimpleDateFormat(format).format(date);
                return new JsonPrimitive(str);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        for (String format: DATE_FORMATS){
            try {
                return new SimpleDateFormat(format).parse(jsonElement.getAsString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
