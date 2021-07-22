package reviewThread;

public class Runnable_0709_two implements Runnable{
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("我是阿里魔")){
            try {
                System.out.println("别吵让哥睡会");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("哎呀妈呀起床了,我特么是谁？？？");
            }
        }
        System.out.println("我啊有点呆呆的，请叫我"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        Runnable_0709_two runnable_0709_two = new Runnable_0709_two();
        new Thread(runnable_0709_two,"我是阿里魔").start();
        new Thread(runnable_0709_two,"我是阿里呆").start();
        new Thread(runnable_0709_two,"我是阿里神").start();
    }
}
