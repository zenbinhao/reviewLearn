public class Main_0627_KeyWordbyFinal {
    public static void main(String[] args) {

        //final修饰的引用变量 不能指向另外的对象
        final a a=new a();
        //        a=new a(); error语法错误

        //final修饰的变量为常量  无法修改
        final int aa=1;
        //        aa=2; error语法错误
    }
    //final是关键字 常量修饰符
    //可以修饰类 但是不能与abstract共存
    //final、abstract不能共存（无论在类、方法、属性、局部变量上都不能共存）

}

//通过final修饰的类不能被继承
final class a{

}
//error语法错误
//class b extends a{
//
//}

class aa{
    final void a(){
        //常量方法
    }
}

class bb extends aa{
    //继承普通类后 其中的常量修饰的方法 无法被重写  只能被调用
    //    void a(){}   error语法错误
    void b(){
        super.a();
    }
}