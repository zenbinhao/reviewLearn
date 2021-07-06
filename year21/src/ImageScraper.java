import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class ImageScraper {

    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println("爬虫开始......");
        // 爬取的网址列表，一共十个网页
        ArrayList<String> urls = new ArrayList<String>();
        urls.add("https://photo.ifeng.com/");
        String dir = "D://log/";  // 图片储存目录
        // 利用循环下载每个页面中的图片
        for(String url: urls) {
            int index = urls.indexOf(url)+1;
            System.out.println("开始下载第"+index+"个网页中的图片...");
            getPictures(url, dir);
            System.out.println("第"+index+"个网页中的图片下载完毕！\n");
        }
        System.out.println("程序运行完毕！");
        Date d2 = new Date();
        // 计算程序的运行时间，并输出
        long seconds = (d2.getTime()-d1.getTime())/1000;
        System.out.println("一共用时： "+seconds+"秒.");
    }
    // getContent()函数: 将网页中的电影图片下载到本地
    public static void getPictures(String url, String dir){
        // 利用URL解析网址
        URL urlObj = null;
        try{
            urlObj = new URL(url);
        }
        catch(MalformedURLException e){
            System.out.println("The url was malformed!");
        }
        // URL连接
        URLConnection urlCon = null;
        try{
            // 打开URL连接
            urlCon = urlObj.openConnection();
            // 将HTML内容解析成UTF-8格式
            Document doc = Jsoup.parse(urlCon.getInputStream(), "utf-8", url);
            // 提取电影图片所在的HTML代码块
//            Elements elems = doc.getElementsByClass("url");
//            Elements pic_block = elems.first().getElementsByTag("a");

//            Elements elements = doc.getElementsByClass("root");
            Elements allScript = doc.getElementsByTag("script");
            Element allDataList = allScript.get(3);
            String a = allDataList.data();
            String  aa= a.substring(a.indexOf("var allData")+13,a.lastIndexOf("var adData")-14);
            JSONObject object = JSONObject.parseObject(aa);
            JSONArray object1= (JSONArray)object.get("newsPhotoData");
            JSONObject object2 = new JSONObject();
            JSONObject object3 = new JSONObject();
            JSONArray object4 = new JSONArray();
            JSONObject object5 = new JSONObject();
            Object object6 = new JSONObject();
            for (int i = 0;i<object1.size();i++){
                object2 = (JSONObject)object1.get(i);
                object3 = (JSONObject) object2.get("intelligentImages");
                if (object3!=null){
                    object4 = (JSONArray) object3.get("image");
//                    System.out.println(object4);
//                    System.out.println(object4.size());
                }
                for (int j =0 ; j< object4.size(); j++){
                    object5 = (JSONObject)object4.get(j);
//                    System.out.println(object5);
                    object6 = object5.get("url");
                    System.out.println(object6);
                    // 用download()函数将电影图片下载到本地
                    UUID uuid = UUID.randomUUID();
                    download((String) object6, dir, uuid.toString());
                    System.out.println("第"+(i+1)+"张图片下载完毕！");
                }
            }

        }
        catch(IOException e){
            System.out.println("There was an error connecting to the URL");
        }
    }
    // download()函数利用图片的url将图片下载到本地
    public static void download(String url, String dir, String filename) {
        try {
            /* httpurl: 图片的url
             * dirfile: 图片的储存目录
             */
            URL httpurl = new URL(url);
            File dirfile = new File(dir);
            // 如果图片储存的目录不存在，则新建该目录
            if (!dirfile.exists()) {
                dirfile.mkdirs();
            }
            // 利用FileUtils.copyURLToFile()实现图片下载
            FileUtils.copyURLToFile(httpurl, new File(dir+filename+".jpg"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}