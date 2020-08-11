package arithmetic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
         //获取年的差值
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2) {
         yearInterval--;
        }
        // 获取月数差值
         int monthInterval = (month1 + 12) - month2;
         monthInterval %= 12;
         int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
            return monthsDiff+1;
         }

         //一段时间在另一段时间的月数
    public static int getMonths(Integer t1,Integer t2,Integer riqiStart,Integer riqiEnd) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        if(riqiStart < t1 && riqiEnd > t2){
            return 12;
        }
        if(riqiEnd < t1 || riqiStart > t2){
            return 0;
        }
        if(riqiStart > t1 && riqiStart < t2 && riqiEnd > t2){
            return getMonthDiff(simpleDateFormat.parse(String.valueOf(t2)),simpleDateFormat.parse(String.valueOf(riqiStart)));
        }
        if(riqiStart > t1 && riqiStart< t2 && riqiEnd < t2){
            return getMonthDiff(simpleDateFormat.parse(String.valueOf(riqiEnd)),simpleDateFormat.parse(String.valueOf(riqiStart)));
        }
        if(riqiStart < t1 && riqiEnd > t1 && riqiEnd < t2){
            return getMonthDiff(simpleDateFormat.parse(String.valueOf(riqiEnd)),simpleDateFormat.parse(String.valueOf(t1)));
        }
        return 0;
    }


    public static void main(String[] args) throws ParseException {
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date riqiStart = simpleDateFormat.parse("201812");
        Date riqiEnd = simpleDateFormat.parse("201908");
        Date rukuriqi = simpleDateFormat.parse("201904");
        Date t2 = simpleDateFormat.parse("202003");*/

        System.out.println(getMonths(201904,202003,201810,201912));

    }

}
