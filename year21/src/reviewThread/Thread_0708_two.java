package reviewThread;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Thread_0708_two extends Thread{
    static LoadingPicture loadingPicture = new LoadingPicture();
    private int i;
    private String url;
    private String localUrl;

    public Thread_0708_two(int i, String url, String localUrl) {
        this.i = i;
        this.url = url;
        this.localUrl = localUrl;
    }

    @Override
    public void run() {
        loadingPicture.loadThis(this.url,this.localUrl);
        System.out.println("我是线程："+i+"---下载的地址"+localUrl);
    }

    public static void main(String[] args) {
        String[] arrStr = new String[]{"https://img2.baidu.com/it/u=2102736929,2417598652&fm=26&fmt=auto&gp=0.jpg",
                "https://img1.baidu.com/it/u=2192265457,2884791613&fm=26&fmt=auto&gp=0.jpg",
                "https://img2.baidu.com/it/u=3960470193,627689163&fm=26&fmt=auto&gp=0.jpg"};
        Thread_0708_two th1 = new Thread_0708_two(1,arrStr[0],"D://log/1.jpg");
        Thread_0708_two th2 = new Thread_0708_two(2,arrStr[1],"D://log/2.jpg");
        Thread_0708_two th3 = new Thread_0708_two(3,arrStr[2],"D://log/3.jpg");

    th1.start();
    th2.start();
    th3.start();
    }
}

class LoadingPicture{

    public void loadThis(String url,String localUrl){

        try {
            //copy文件到              资源路径      文件存放位置
            FileUtils.copyURLToFile(new URL(url),new File(localUrl));
        } catch (IOException e) {
            System.out.println("io流异常");
            e.printStackTrace();
        }

    }
}