package lock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    private volatile static Main m;
    private Main(){}
    public static Main getM(){
        if(m == null){
            synchronized (Main.class){
                if(m == null){
                    m = new Main();
                }
            }
        }
        return m;
    }
}
