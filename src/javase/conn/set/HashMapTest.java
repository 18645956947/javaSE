package javase.conn.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(16);
        map.put(7, "");
        map.put(11, "");
        map.put(43, "");
        map.put(59, "");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");
        System.out.println("结果是：");
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> ");
        }
        System.out.println();
        Integer aa = 127;
        Integer b = 127;

        System.out.println(aa == b);
        System.out.println(aa.equals(b));

        aa = 128;
        b = 128;
        System.out.println(aa == b);
        System.out.println(aa.equals(b));
        Integer i1 = new Integer(2);
        Integer i2 = new Integer(2);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        System.out.println("--------");

        List<String> l1 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        l1.add("3");
        l1.add("4");
        l1.add("5");
        l1.add("6");
        Iterator<String> iterator = l1.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if(item.equals("5")){
                iterator.remove();
            }
        }
        System.out.print(l1);
    }


}
