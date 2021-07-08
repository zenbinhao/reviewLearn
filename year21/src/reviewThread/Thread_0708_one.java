package reviewThread;

public class Thread_0708_one extends Thread{

    int i=0;
    @Override
    public void run() {

        while (i<100){
            System.out.println("我我我我我我我我***********");
           i++;
        }
    }

    public static void main(String[] args) {
        int a= 0;

        //多线程测试
        //线程的5种状态
        //线程的周期  线程的创建-》线程的准备(可运行)-》线程的运行-》线程的阻塞-》线程的死亡

        Thread_0708_one thread1=new Thread_0708_one();
        //thread1.run();  单纯的调用方法
        //开启线程  俩个线程先后开启   由于主线程的优先级高  将会先开启主线程
        thread1.start();

        //主线程
        while (a<1000){
            System.out.println("tatatatatatata///////////");
            a++;
        }
    }

}
