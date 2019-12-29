package 复习.序列化;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {

    public static void main(String[] args) {
        try{
            ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            Student s1 = new Student("张三", 12);
            oos.writeObject(s1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
