package javase.conn.set;

import java.util.HashMap;

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
    }
}
