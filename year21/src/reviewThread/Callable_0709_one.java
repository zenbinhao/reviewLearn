package reviewThread;


import java.util.concurrent.*;

public class Callable_0709_one implements Callable<Boolean> {
    static LoadingPicture loadingPicture = new LoadingPicture();
    private int i;
    private String url;
    private String localUrl;

    public Callable_0709_one(int i, String url, String localUrl) {
        this.i = i;
        this.url = url;
        this.localUrl = localUrl;
    }

    @Override
    public Boolean call() {
        loadingPicture.loadThis(this.url,this.localUrl);
        System.out.println("我是线程："+i+"---已下载到当前项目下"+localUrl);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String[] arrStr = new String[]{"https://img2.baidu.com/it/u=2102736929,2417598652&fm=26&fmt=auto&gp=0.jpg",
                "https://img1.baidu.com/it/u=2192265457,2884791613&fm=26&fmt=auto&gp=0.jpg",
                "https://img2.baidu.com/it/u=3960470193,627689163&fm=26&fmt=auto&gp=0.jpg"};

        //相对于runnable线程 callable线程有返回值


        // 首先创建线程实例
        Callable_0709_one th1 = new Callable_0709_one(1,arrStr[0],"1.jpg");
        Callable_0709_one th2 = new Callable_0709_one(2,arrStr[1],"2.jpg");
        Callable_0709_one th3 = new Callable_0709_one(3,arrStr[2],"3.jpg");

        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //提交线程实例并进行执行
        Future<Boolean> t1 = executorService.submit(th1);
        Future<Boolean> t2 = executorService.submit(th2);
        Future<Boolean> t3 = executorService.submit(th3);

        //打印线程体结果
        System.out.println("callable线程1"+ (t1.get() ? "--正常下载完毕":"失败下载"));
        System.out.println("callable线程2"+ (t2.get() ? "--正常下载完毕":"失败下载"));
        System.out.println("callable线程3"+ (t3.get() ? "--正常下载完毕":"失败下载"));


        //关闭服务 jvm无法对系统资源进行回收策略 防止资源泄露、积攒垃圾、系统崩溃
        executorService.shutdown();
    }
}
