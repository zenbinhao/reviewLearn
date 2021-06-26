import java.util.ArrayList;
import java.util.List;

public class Main_0624_one {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<Integer>();

        //使用泛型更安全不会导致集合中的对象变成Object类型
        list1.add("1");

        //泛型在编译阶段，虚拟机就会把泛型擦除，还原成没有泛型的代码，不会影响执行速度，顶多编译的时候慢一点。
        System.out.println(list1.getClass() == list2.getClass());

        //泛型不能是基本数据类型，只能是包装它们的类.
        List<Integer> list3 = new ArrayList<Integer>();
        //基本类型报错  List<Int> list4 = new ArrayList<Int>();


    }
}
