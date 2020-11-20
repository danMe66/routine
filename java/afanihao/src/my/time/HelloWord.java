package my.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWord {

    public static void main(String[] args) throws ParseException {
        long now = System.currentTimeMillis();
        System.out.println("现在时间：" + now);

        Date date = new Date();
        System.out.println("现在时间：" + date.getTime());
        System.out.println("现在时间：" + date.toString());

        // 格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm::ss");
        String foramtTiem = simpleDateFormat.format(date);
        System.out.println("格式化之后的现在时间：" + foramtTiem);

        try {
            String time = "2020-06-22";
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date date2 = simpleDateFormat1.parse(time);
            System.out.println("时间格式化时间戳：" + date2.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
