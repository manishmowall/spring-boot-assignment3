package org.webonise.springboot.collectiondemo;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

@Component
public class DateOfBirthComparator implements Comparator {

    public int compare(Object o1, Object o2) {

        User user1 = (User) o1;
        User user2 = (User) o2;

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dataFormat.parse(user1.getDOB());
            date2 = dataFormat.parse(user2.getDOB());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return date1.compareTo(date2);
    }
}
