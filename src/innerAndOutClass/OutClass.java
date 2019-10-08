package innerAndOutClass;

public class OutClass {
    static int a;
    int b;
    public static void outTest(){
        System.out.println("out class static function");
    }

    public OutClass(){
        InnerClass ic = new InnerClass();
        System.out.println("外部类创建一个内部类的实例");
    }

    //非静态内部类
    private class InnerClass{
        //只有在静态内部类中才能定义或者声明静态成员或者方法
        //private static String tt = "0";
        private int flag = 0;

        public InnerClass(){
            //非静态内部类可以访问外部类所有的静态非静态资源
            System.out.println("InnerClass creat a:" + a);
            System.out.println("InnerClass creat b:" + b);
            System.out.println("InnerClass creat flag:" + flag);

            //调用外部类的静态方法
            outTest();
        }
        private String getKey(){
            return "no-static-inner";
        }
    }
    //静态内部类
    private static class InnerStaticClass{
        private static String static_value = "static_value";
        private int flag = 0;

        public InnerStaticClass(){
            System.out.println("OutClass create a:" + a);
            //System.out.println("OutClass create b:" + b);
            System.out.println("InnerStaticClass flag:"+flag);
            System.out.println("InnerStaticClass static_value:"+static_value);
        }
        public static String getMessage(){
            return "inner static class function";
        }
    }

    public static void main(String[] args) {
        OutClass oc = new OutClass();
        //创建内部类实例的方法
        OutClass.InnerClass no_static_inner = oc.new InnerClass();
        System.out.println(no_static_inner.getKey());

        System.out.println(OutClass.InnerStaticClass.static_value);
        //不依赖于外部类的实例，直接实例化内部静态类
        OutClass.InnerStaticClass inner = new OutClass.InnerStaticClass();
        System.out.println(inner.flag);
        System.out.println(OutClass.InnerStaticClass.getMessage());
    }

}

