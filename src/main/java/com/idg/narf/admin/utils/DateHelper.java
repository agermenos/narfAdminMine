package com.idg.narf.admin.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by agermenos on 11/22/16.
 */
public class DateHelper {
    public static Timestamp stringToTimestamp(String date){
        try {
            SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat(
                    "MM-dd-yyyy HH:mm:ss");
            Date lFromDate1 = datetimeFormatter1.parse(date);
            return new Timestamp(lFromDate1.getTime());
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
