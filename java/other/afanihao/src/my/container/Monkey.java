package my.container;

public class Monkey {

    public int id;

    public String name;

    public Monkey next;

    public Monkey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        String s = "ID：" + id + " 名字：" + name;
        return s;
    }
}
