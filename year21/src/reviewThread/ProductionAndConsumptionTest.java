package reviewThread;

//线程的生产消费模式（非23设计模式）

import java.util.concurrent.locks.ReentrantLock;

public class ProductionAndConsumptionTest {

    public static void main(String[] args) {
        //找到联系生产商 和 消费者之间的 容器
        CacheContainer cacheContainer = new CacheContainer();
        //开启生产线程
        new Thread(new Produce(cacheContainer),"我是卑微小商家：*****").start();
        //开启消费线程
        new Thread(new Consumer(cacheContainer),"爷爷我是消费者：-----").start();
//        new Thread(new Consumer(cacheContainer),"哥哥我是消费者：-----").start();
    }
}

//产品实体类
class Product{
    int id;

    public Product(int id) {
        this.id = id;
    }
}


//生产者生产线程
class Produce implements Runnable{
    private CacheContainer cacheContainer;

    Produce(CacheContainer cacheContainer){
        this.cacheContainer = cacheContainer;
    }
    @Override
    public void run() {
        for (int i=0;i<200;i++){
            this.cacheContainer.push(new Product(i));
        }
    }
}

//消费者消费线程
class Consumer implements Runnable{
    private CacheContainer cacheContainer;

    Consumer(CacheContainer cacheContainer){
        this.cacheContainer = cacheContainer;
    }

    @Override
    public void run() {
        for (int i=0;i<200;i++){
            this.cacheContainer.pops();
        }
    }
}

//缓存线程  容器
class  CacheContainer{
    //容器大小
    private static Product[] p =new Product[10];
    //容器计数器
    private int count;

    private static final ReentrantLock reentrantLock =new ReentrantLock();

    //生产的产品 放入容器产品
    public synchronized void push(Product product){
        //当计数器满时
        if(count==this.p.length){
        //通知线程进行等待  等待消费者进行消费
            try {

                System.out.println("前台提醒：正在生产中请稍后");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //当计数器未满时需要添加产品
        this.p[count] = new Product(product.id);
        //当上面刚好添加满了后  count数值刚好通过++到 数组长度值
        count++;
        //当添加了产品时  唤醒线程
        this.notifyAll();
        return;
    }

    //消费者过来购买产品
    public synchronized void pops(){

        //当容器中没有产品的时候
        if (count==0){
            try {
                System.out.println(Thread.currentThread().getName()+"搞鬼走过来没了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //当容器中有产品的时候
        count--;
        //拿到当前那个产品
        Product product = p[count];
        System.out.println(Thread.currentThread().getName()+"购买到了编号为"+product.id+"的产品");

        this.notifyAll();

    }
}
