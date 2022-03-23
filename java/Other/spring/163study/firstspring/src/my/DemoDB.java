package my;

import java.util.List;
import java.util.ArrayList;

public class DemoDB {
    public static List<Student> list = new ArrayList<>();

    static {
        list.add(new Student(101, "1号"));
        list.add(new Student(102, "2号"));
        list.add(new Student(103, "3号"));
        list.add(new Student(104, "4号"));
        list.add(new Student(105, "5号"));
    }
}
