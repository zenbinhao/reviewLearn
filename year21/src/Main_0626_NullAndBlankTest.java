public class Main_0626_NullAndBlankTest {
    //做成员变量的时候没有初始化值 默认赋值为null 可以进行调用String的操作编译可通过，但是会空指针异常
    static String str;
    public static void main(String[] args) {
        //  null是没有地址的
        //  “”是有地址的，但内容为空，也为字符串
        String str1;
        String str2="";
        String str3=null;

        System.out.println(str);

        //做局部变量不初始化值 仅算在栈中声明了一个变量 此时不能调用String的操作 会java语法错误编译不通过。
//        System.out.println(str1); 原理为调用to.String() 空对象调用空指针异常
        System.out.println(str2);
//        System.out.println(str.length());  空对象调用空指针异常
        System.out.println(str2.length());
        System.out.println(str3);
        //做局部变量赋值null 进行String操作会 空指针异常
//        System.out.println(str3.length());
    }
}
