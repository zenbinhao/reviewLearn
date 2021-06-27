import java.lang.management.RuntimeMXBean;

// 重点：
// static、abstract不能共存（无论在类、方法、属性、局部变量上都不能共存）
// final、abstract不能共存（无论在类、方法、属性、局部变量上都不能共存）
public class Main_0627_abstractAndInterface {
    public static void main(String[] args) {
        //当抽象类的子类没有实现其非抽象方法，默认调用的就是父类的非抽象方法
        SS.c();
        System.out.println("-------------");

        //抽象类可以作为对象变量的声明，作为编译时的类型   实例化子类
        S s = new SS();
        System.out.println("-------------");

        S s1 =new SS("我是子类的实例");
        System.out.println("-------------");

        //调用类中的静态内部类方法  直接引用
        SS.StaticInnerClass.getMessage();
        System.out.println("-------------");

        //调用类中的非静态内部类需要new 关键字
        new SS().new NormalInnerClass().getMessage();
        System.out.println("-------------");
    }


}


//  abstract为抽象修饰符  一般用来修饰类和方法
//  类被抽象后不能进行实例化
//  抽象类可以构造函数 目的为了给子类调用 但是不能通过new来调用
abstract class S{
    //抽象abstract只能修饰方法和类。
//    public abstract String abTest;  error语句

    //静态代码块  随着类的加载而 加载  可以通过声明的方式直接调用 类名 变量名; S s;
    static {
        System.out.println("父类静态代码块");
    }
    S(){
        System.out.println("我是父类构造方法");
    }
    S(String a){
        System.out.println(a+"\n但是我是父类的有参构造方法");
    }
    public static void c(){
        System.out.println("我是父类的静态方法");
    }
//    abstract 和 static 不能同时存在
//    public abstract static void cc();
    public  void b(){
        System.out.println("我是父类的方法");
    }


    //作为父类的抽象方法 子类一定要实现抽象方法 否则编译出错
    //且抽象方法不能含有方法体 只有再抽象类中才能用 abstract修饰方法 成为抽象方法
    public abstract void e();
}

//一个类可以有多个类同时继承  但一个类不能继承多个类
//error:  (编译错误)
//class c extends a,b{
//
//}

class SS extends S{
    SS(){
        super();
        super.c();
        super.b();
    }
    SS(String a){
        super(a);
    }

    @Override
    public void e() {
        System.out.println("实现父类的抽象方法");
    }

    //静态内部类
    static class StaticInnerClass{
        public static void getMessage(){
            System.out.println("我是子类中的静态内部类的方法");
        }
    }
    //非静态内部类
    class NormalInnerClass{
        public  void getMessage(){
            System.out.println("我是子类中的非静态内部类的方法");
        }
    }
}
