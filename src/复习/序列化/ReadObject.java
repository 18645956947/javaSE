package 复习.序列化;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {

    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
            try {
                Student s1 = (Student) ois.readObject();
                System.out.println(s1.getAge() + s1.getName());
                System.out.println(s1);

                int a = 0;
                int b = 1;
                int c = 2;
                ByteArrayOutputStream bao = new ByteArrayOutputStream();
                bao.write(a);
                bao.write(b);
                bao.write(c);
                System.out.println(bao.toByteArray());
                char ss1 = '你';
                int i = ss1;
                System.out.println(ss1);
                System.out.println(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
