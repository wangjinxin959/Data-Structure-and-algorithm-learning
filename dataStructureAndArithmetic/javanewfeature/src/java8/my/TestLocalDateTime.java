package java8.my;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestLocalDateTime {

    /**
      LoLcalDate、LocalTime、LocalDateTime
      Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
      Duration : 用于计算两个“时间”间隔
      Period : 用于计算两个“日期”间隔
      TemporalAdjuster : 时间校正器
      DateTimeFormatter : 解析和格式化日期或时间
      ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
     */


    @Test
    public void test1 () {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.now();
        System.out.println(ldt);

        Instant now = Instant.now();
        System.out.println(now);

        Instant is = Instant.now();
        Duration.between(now, is);

        Period between = Period.between(LocalDate.now(), LocalDate.now());

        LocalDateTime localDateTime = ldt2.withDayOfMonth(10);

        ldt2.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_TIME;
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = df2.format(ldt);
        System.out.println(format);
        LocalDateTime ldt3 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));

    }

    @Test
    public void testImprotant () {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);

        Instant start = Instant.now();
        Instant end = Instant.now();


        System.out.println(Duration.between(start,end));

        LocalDate l1 = LocalDate.now();
        LocalDate l2 = LocalDate.now();
        Period.between(l1,l2);



    }

}
