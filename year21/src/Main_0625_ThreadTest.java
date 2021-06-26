
// 由于String是final  每次进行拼接都会重新声明新变量  杀掉原来的变量  速度非常慢
// 作为StringBuffer和StringBuilder 都是可变字符串
// 线程安全StringBuffer  可以使用synchronized悲观锁每次只允许一个线程访问

public class Main_0625_ThreadTest {
    public static void main(String[] args) {
        Thread one = new Thread(new MyThread1());
        Thread two = new Thread(new MyThread2());
        Thread thread = new Thread(new MyThread3());

        one.start();
        two.start();
        thread.start();
    }
}

class MyThread1 implements Runnable{

    @Override
    public void run() {
        long time1 = System.currentTimeMillis();
        String str1= "aaa";
        String str2= "bbb";
        String str = "";
        int count=100000;
        while (count>0){
            str = str1+str2;
            str1 = str;
            System.out.println("我是线程1"+count);
            count--;
        }
        System.out.println("我是线程1**********"+(System.currentTimeMillis()-time1)/1000.0+"s");
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        StringBuffer a = new StringBuffer();
        int count=100000;
        long time1 = System.currentTimeMillis();
        while (count>0){
            a.append("aaa");
            a.append("bbb");
            System.out.println("我是线程2"+count);
            count--;
        }
        a.toString();
        System.out.println("我是线程2************"+(System.currentTimeMillis()-time1)/1000.0+"s");

    }
}

class MyThread3 implements Runnable{

    @Override
    public void run() {
        StringBuilder b = new StringBuilder();
        long time1 = System.currentTimeMillis();
        int count=100000;
        while (count>0){
            b.append("aaa");
            b.append("bbb");
            System.out.println("我是线程3"+count);
            count--;
        }
        b.toString();
        System.out.println("我是线程3***********"+(System.currentTimeMillis()-time1)/1000.0+"s");

    }
}

