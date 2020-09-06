package lock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
       MyThread myThread = new MyThread();
        for (int i = 0; i < 10; i++) {
            new Thread(myThread, i + "-thread").start();
        }
    }
}
