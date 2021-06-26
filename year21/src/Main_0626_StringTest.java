import java.util.Arrays;

public class Main_0626_StringTest {
    public static void main(String[] args) {
        String a = new String("abc");
        String b ="abc";
        String c="abc";
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
        System.out.println("-----------------------");
        //首先通过声明创建了3个变量 a，b，c在栈中
        //通过 ==比较符  对引用类型进行的是内存地址的比较  而基本类型才是值的比较
        //所以b 和 c在常量池中读取是同一个内存地址
        //而a通过new产生的对象 是在堆中
        //由此可得：a引用的是堆中的new对象 new对象再引用的常量池字符串  而b和c是直接引用的常量池字符串
        //所以 a和b a和c内存地址不相同   但指向的是b和c的同一个常量

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
        System.out.println("-----------------------");
        //以上3列均为true
        //是由于String重写了Object类中的equals方法在 ==上进行了扩展
        //所以通过equals方法判断的是值的相同



        //若其他引用类型进行判断使用equals
        //举列子：当我有一个Student类 ,由于所有类型都是Object的子类，所以可以调用equals方法进行判断
        //由于没有进行equals方法的重写 俩个对象进行比较的就是内存地址
        Student stu1 = new Student();
        Student stu2 = new Student();
        System.out.println(stu1.equals(stu2));
        System.out.println("-----------------------");

        //String对象中进行split
        //通过特殊字符去分裂字符串需要用 \\进行转义
        String arr1[] = "3.14".split("\\.");
        String arr2[] = "2020/03/11".split("\\/");
        String arr3[] = "2|3|4".split("\\|");
        //直接打印数组是对象的地址
        System.out.println(arr1);
        //通过调用方法  原理就是for循环
        //import java.util.Arrays;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

        System.out.println("-----------------------");


        //  在java程序执行期间，同一对象多次调用hashCode方法，必须一致的返回相同的整数值，前提是通过equals比较时所用的信息没有被修改
        //  在不同程序上执行 无需保持一致
        //  若对象通过equals方法，两个方法是相等的  那么对这俩个对象调用hashCode方法都必须生成相同的整数结果
        //
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(stu1.hashCode());
        stu1.name= "1";
        stu1.name= "2";
        System.out.println(stu1.hashCode());
        stu1.name= "3";
        stu1.name= "4";
        stu1.name= "5";
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
        System.out.println(stu1.hashCode()==stu2.hashCode());
        System.out.println("-----------------------");

        //当对象使用equals方法进行比较的时候返回为true时 通过调用hashcode产生的整数结果必然相同
        String testOne= new String("abh");
        String testTwo= new String("abh");
        System.out.println(testOne.equals(testTwo));
        System.out.println(testOne.hashCode()==testTwo.hashCode());
        System.out.println("-----------------------");


        //俩个对象调用equals方法进行比较 返回为false时，  通过调用hashcode也会产生相同的整数结果
        //编码时为提高哈希表性能，让不相等的变量
        String zbh = new String("Aa");
        String hbz = new String("BB");
        System.out.println(zbh.equals(hbz));
        System.out.println(zbh.hashCode());
        System.out.println(hbz.hashCode());
        System.out.println(zbh.hashCode()==hbz.hashCode());

        System.out.println("-----------------------");


    }


    //  String 是final类   String类声明的时候就是  public final class String 无法继承 没有子类
    //  所以方法都是常量方法 无法继承重写
    //  通过char[] 来保存字符串
    //  String对象一旦创建就不会改变，任何操作都不会改变原字符串，而是生成新的对象
    //  由于String字符串不可改变 所以常量池中有且只有一个非重复字符串


}
class Student{
    public String name;
}

