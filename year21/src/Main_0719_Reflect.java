import com.zeng.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;

public class Main_0719_Reflect {

    public static void main(String[] args) throws Exception{

        //获取class
        Class<?> class1;
        //第一种方式 通过Class类的静态方法-forName（）来实现
        class1 = Class.forName("com.zeng.User");
        System.out.println(class1);
        //第二种方式 通过类的class属性
        class1 = User.class;
        System.out.println(class1);
        //第三种方式
        User user = new User();
        class1 = user.getClass();
        System.out.println(class1);


        //一些反射的操作

        //获取全类名(根目录下包.具体类名)
        String name = class1.getName();
        System.out.println(name);
        //获取简单的类名(只包含类名)
        String simpleName = class1.getSimpleName();
        System.out.println(simpleName);
        //根据字段名获取该类的public字段
        Field name1 = class1.getField("name");
        Field age = class1.getField("age");
        System.out.println(name1+""+age);
        //根据方法名获取类的方法
        Method declaredMethod = class1.getDeclaredMethod("getName", String.class);
        System.out.println(declaredMethod);

        //类直接实例化
        Class class2 = Class.forName("com.zeng.User");
        User user2 = (User) class2.newInstance();

        //反射调用类的方法
        //先获取当前类的方法对象
        Method method = class1.getDeclaredMethod("setAge", Integer.class);
        Method method2 = class1.getDeclaredMethod("getAge");
        //调用指定的函数 并传递实参
        method.invoke(user2,28);
        System.out.println(method2.invoke(user2));
    }
}
//反射是什么
//反射是指我们可以在运行期间（runtime）加载、探知、使用编译期间完全未知的类
//