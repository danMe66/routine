package my.genericclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 泛型相关
 *
 * @author mini
 */
public class HelloWord {

    public static void main(String[] args) {
        // 泛型：ArrayList

        ArrayList<Student> list = new ArrayList<Student>();

//		Student s1 = new Student(1001, "1号", 18);
//		arrayList.add(s1);

        list.add(new Student(1003, "3号", 18));
        list.add(new Student(1001, "1号", 18));
        list.add(new Student(1002, "2号", 18));

        // 第一种遍历方法
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println("第一种遍历方法遍历查出students的信息->" + s);
        }

        System.err.println("排序前后分割线");

        // 排序
        list.sort(new MyComparator());

        // 第二种遍历方法
        for (Student s : list) {
            System.out.println("第二种遍历方法遍历查出students的信息->" + s);
        }

        // 第三种遍历方法:迭代器Iterator
        // 迭代器的效率较高
        System.err.println("迭代器Iterator");
        Iterator<Student> iter = list.iterator();
        while (iter.hasNext()) {
            Student s = iter.next();
            System.out.println("第三种迭代器遍历查出students的信息->" + s);
        }

        System.err.println("-------- HashMap --------");
        // 哈希HashMap：哈希映射，也是一种泛型
        // HashMap：更强更快
        // ArrayList 查找的时候需要遍历去查
        // HashMap 只需要喊一嗓子就ok
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        map.put(1004, new Student(1004, "4号", 18));
        map.put(1005, new Student(1005, "5号", 18));
        map.put(1006, new Student(1006, "6号", 18));
        map.put(1007, new Student(1007, "7号", 18));

        Student s = map.get(1004);
        System.out.println("第三种HashMap查出students的信息->" + s);

    }

    public static class MyComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.number < o2.number) {
                return -1;
            }
            if (o1.number > o2.number) {
                return 1;
            }
            return 0;
        }

    }
}
