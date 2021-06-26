import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_0624_two {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        List<Integer> aList = new ArrayList<Integer>();
        for (Integer toList: arr) {
            aList.add(toList);
        }
        A<String,Integer> a = new A<String,Integer>("String",aList);
        System.out.println(a.toString());

        //集合转数组
        Integer the_arr[] = new Integer[aList.size()];
        aList.toArray(the_arr);
        System.out.println(Arrays.toString(the_arr));

        String abc = "aaa";
        abc = abc+abc;
        System.out.println(abc);
    }
}
//  泛型中的通配符:
//  T代表一种特定的类型  class A<T>  Type:java类
//  E代表一种类型的意思,只不过通常代表集合中的元素 List<E>  Element：集合中的元素
//  ?是一种无限的符号,代表任何类型 Class<?> a=new Class()
//  K,V  key value
//  静态方法和静态变量不能使用泛型所声明的变量
class A<T, E> {

    private T t;
    private List<E> eList;
    A(T t,List<E> aList){
        this.t = t;
        this.eList = aList;
    }
    //泛型
    public static <T> void aaa(){

    }
//    public void setT(T t){
//        this.t=t;
//    }
//
//    public T getT() {
//        return t;
//    }


    @Override
    public String toString() {
        return "A{" +
                "t=" + t +
                ", eList=" + eList +
                '}';
    }
}