package my.container;

import java.util.ArrayList;

public class HelloWord {
    public static void main(String[] args) {
        Student[] ss = new Student[4];
        ss[0] = new Student("1号", 18, true);
        ss[1] = new Student("2号", 19, true);
        ss[2] = new Student("3号", 20, true);
        ss[3] = new Student("4号", 21, true);

        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i].toString());
        }

        // 链表
        // 四只猴子
        Monkey m1 = new Monkey(101, "1号猴子");
        Monkey m2 = new Monkey(102, "2号猴子");
        Monkey m3 = new Monkey(103, "3号猴子");
        Monkey m4 = new Monkey(104, "4号猴子");

        // 串起来，每个猴子握住前者的尾巴
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = null;

        // 插入节点
        // ①给节点末尾添加一个节点①
        m4.next = new Monkey(105, "5号猴子");

        // ②给节点末尾添加一个节点②
        // 将m1赋值给第一个节点
        Monkey m = m1;
        // 遍历每一个节点（从头节点开始遍历）
        while (m != null) {
            // 如果节点为null，终止循环，证明此节点为最后一个节点
            if (m.next == null) {
                break;
            }
            // 每一个节点等于下一个节点的绑定
            m = m.next;
        }
        // 给最后一个节点赋值
        m.next = new Monkey(106, "6号猴子");

        // ③给第二个节点（第一个节点后边）添加一个节点①
        Monkey m7 = new Monkey(107, "7号猴子");
        Monkey heade = m1;
        // 让2号猴子抓住插入节点的尾巴
        m7.next = m1.next;
        // 插入节点抓住一号猴子的尾巴
        m1.next = m7;

        // ③给第二个节点（第一个节点后边）添加一个节点②（插入到指定节点）
        Monkey node1 = m1;
        Monkey m8 = new Monkey(108, "8号猴子");
        while (node1 != null) {
            if (node1.id == 102) {
                m8.next = node1.next;
                node1.next = m8;
            }
            node1 = node1.next;
        }
        // 创建一个假节点，作为链表的头节点
        Monkey heade1 = new Monkey(0, "假节点的石猴");
        heade1.next = m1;

        // 插入一个假猴子
        Monkey m9 = new Monkey(109, "9号猴子");
        m9.next = heade1.next;
        heade1.next = m9;

        // 将初始节点置为第二个节点，就忽略了假的节点
        Monkey node2 = heade1.next;
        // 删除指定节点
        Monkey prev = heade1;
        while (node2 != null) {
            if (node2.id == 102) {
                prev.next = node2.next;
                break;
            }
            prev = node2;
            node2 = prev.next;
        }

        // 调用MonkeyList里边的方法
        MonkeyList monkeyList = new MonkeyList();
        monkeyList.add(m1);
        monkeyList.add(m2);
        monkeyList.add(m3);

        // 查找指定ID的对象
        Monkey who = monkeyList.get(103);
        if (who != null) {
            System.out.println("找到了：" + who);
        }

        // 将m1赋值给第一个节点
//		Monkey node = m1;
        Monkey node = heade1.next;
        // 如果节点不是最后一个节点，就往下走
        while (node != null) {
            // 打印节点
            System.err.println("链表中的节点：" + node);
            // 将下一个节点赋值给新的节点
            node = node.next;
        }

        System.out.println("-----使用内置的数组链表ArrayList----");

        ArrayList arrayList = new ArrayList();
        arrayList.add(m1);
        arrayList.add(m2);
        arrayList.add(m3);
        for (int i = 0; i < arrayList.size(); i++) {
            Monkey monkey = (Monkey) arrayList.get(i);
            System.out.println("遍历输出：" + monkey);
        }
    }

}
