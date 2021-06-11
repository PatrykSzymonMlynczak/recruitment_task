package com.example.recruitment_task.dateFormat;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@Service
public class DateToISOFormatterImpl implements DateToISOFormatter {

    @Override
    public String dateFormatter(Date creationDate){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        String creationDateISOFormat = simpleDateFormat.format(creationDate);
        return creationDateISOFormat;
    }


}
