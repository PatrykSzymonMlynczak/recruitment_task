package com.example.recruitment_task.dateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class DateToISOFormatterImplTest {


    private DateToISOFormatterImpl dateToISOFormatter;
    private Date date;
    private SimpleDateFormat formatter;

    @BeforeEach
    public void setUp()  {
         dateToISOFormatter = new DateToISOFormatterImpl();
         formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         date = new Date();
    }

    @Test
    void checkIfDateIsISOFormat() {
        //given
        Pattern pattern = Pattern.compile("([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?");
        //when
        String formattedDate = dateToISOFormatter.dateFormatter(date);
        //then
        Matcher matcher = pattern.matcher(formattedDate);
        assertTrue(matcher.matches());
    }
}