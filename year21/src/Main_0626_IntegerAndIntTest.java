
public class Main_0626_IntegerAndIntTest {
    public static void main(String[] args) {

        //  1.Integer 是int的包装类,int是基本数据类型
        //  包装类->基本数据类型  称为拆箱
        //  基本数据类型-> 称为装箱
        //  2.Integer 变量必须是实例化后才能使用，而int变量不需要
        //  4.Integer 默认值是null，int默认值是 0  java语法，只定义不初始化数据不能使用 作为形参的时候不传值接收的时候默认值场景
        //  Integer 实例化的四种方式
        Integer a=1;
        Integer b = new Integer(1);
        //装箱式实例化
        Integer c = Integer.valueOf(1);
        Integer d = new Integer("1");

        //  3.Integer 实际是引用对象，当new一个Integer时实际是 在栈中产生一个变量  指向堆中的常量池引用  常量池保存常量
        Integer bb = new Integer(1);
        //  因为==比较符 比较对象地址，俩个不同的对象指向的内存地址不一样   Integer中有重写equals方法所以比较的是值
        System.out.println(b==bb);
        System.out.println(b.equals(bb));
        System.out.println("--------------------");

        //Integer、Integer.valueOf() 和 new Integer()变量比较永远为false
        //Integer 变量是从栈指向的常量池  而new Integer()是从栈指向堆  俩者内存地址不一样
        System.out.println(a==b);
        System.out.println(a==b);
        System.out.println("--------------------");

        //俩个Integer进行比较的时候 值在-128到127之间 通过==比较为 true  反之则 false
        // 一个字节 8位 取值 -128到127之间 字节或在\u0000至\u007f范围内的字符 javaAPI中的规范
        //当超过127或者低于-128时 会自动创建一个new，即产生新的对象
        Integer aa=1;
        System.out.println(a==aa);
        a=128;
        aa=128;
        System.out.println(a==aa);
        System.out.println("--------------------");

        //且Integer和 Integer.valueOf()
        a=1;
        System.out.println(a==c);
        a=128;
        c=Integer.valueOf(128);
        System.out.println(a==c);
        System.out.println("--------------------");

        //当跟基本类型进行==比较的时候  Integer包装类型会自动拆箱成int进行比较
        int one = 128;
        Integer two = new Integer(128);
        Integer three = 128;
        Integer four = Integer.valueOf(128);
        System.out.println(one==two);
        System.out.println(one==three);
        System.out.println(one==four);
    }

}


