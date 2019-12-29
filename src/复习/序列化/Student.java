package 复习.序列化;

import java.io.Serializable;

public class Student implements Serializable {
    private int age;
    private String name;
    public Student(String name, int age){
        System.out.println("我是构造函数，通过我开始构造对象了");
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Student:" + this.name + " " + this.age;
    }
}
