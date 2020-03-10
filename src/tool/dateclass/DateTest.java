package tool.dateclass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.CRC32C;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(date.getTime());
        System.out.println(date.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());
        System.out.println(c.toString());
        System.out.println(c.getDisplayName(Calendar.MONTH, Calendar.SHORT_FORMAT, Locale.CHINA));

    }
}