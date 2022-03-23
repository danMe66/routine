package my.bean;

public class Dog {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
