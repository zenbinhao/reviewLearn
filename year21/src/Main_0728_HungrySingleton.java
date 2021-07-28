
import java.io.*;

public class Main_0728_HungrySingleton {
    public static void main(String[] args) {
        HungrySingleton h1 = HungrySingleton.getH();
        HungrySingleton h2 = null;

        //创建io流输出对象
        FileOutputStream fos =null;
        ObjectOutputStream oos =null;

        // 将h1序列化到磁盘
        try {
            fos = new FileOutputStream("a.obj");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(h1);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭io流
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        //反序列化
        FileInputStream fis = null;
        ObjectInputStream ois =null;
        try {
            fis = new FileInputStream("a.obj");
            ois = new ObjectInputStream(fis);
            // 从磁盘反序列化
            h2 = (HungrySingleton) ois.readObject();

            System.out.println(h1.equals(h2));
            System.out.println(h2 == h1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
// 饿汉式单例
class HungrySingleton implements Serializable {

    private static final Long serialVersionUID = 1L;

    HungrySingleton(){

    }
    private static final HungrySingleton h = new HungrySingleton();

    public static HungrySingleton getH() {
        return h;
    }
    private Object readResolve(){
        return this.h;
    }
}


// 懒汉式单例
class LazySingLeton implements Serializable{

    private static LazySingLeton l = null;

    private static final Long serialVersionUID = 1L;

    LazySingLeton(){}

    //加上同步锁 synchronized  线程安全
    public static synchronized LazySingLeton getInstance(){
        if (l==null) l=new LazySingLeton();
        return l;
    }
}
