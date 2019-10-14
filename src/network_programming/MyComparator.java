package network_programming;

import java.awt.dnd.DragGestureRecognizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyComparator {

    public static class Student{
        private int age;
        private  String name;
        private int id;
        public Student(int id, int age, String name){
            this.id = id;
            this.name = name;
            this.age = age;
        }


        public static void printStudent(Student[] students){
            for (Student s : students) {
                System.out.println("id:" + s.id + " name:" + s.name + " age:" + s.age);
            }
            System.out.println("====================");
        }
    }
    public static class IdComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            if(o1.id < o2.id){
                return -1;
            }else if(o1.id > o2.id){
                return 1;
            }else
                return 0;
//            return o1.id - o2.id;
        }

    }
    public static void main(String[] args) {
        Student s2 = new Student(2, 22, "bbb");
        Student s1 = new Student(1, 11, "aaa");
        Student s3 = new Student(3, 33, "ccc");
        //自定义排序类型
        Student[]  students = new Student[]{s3, s2, s1};
        Student.printStudent(students);
        Arrays.sort(students, new IdComparator());
        Student.printStudent(students);

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        heap.add(s3);
        heap.add(s2);
        heap.add(s1);
        /*while (!heap.isEmpty()){
            Student s = heap.poll();
            System.out.println("id:" + s.id + " name:" + s.name + " age:" + s.age);
        }*/

    }
}
