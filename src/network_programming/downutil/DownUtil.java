package network_programming.downutil;

import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownUtil {
    //定义下载的资源的路径
    private String path;
    //定义下载资源后的保存位置
    private String targetFile;
    //定义需要使用多少个线程下载资源
    private int threadNum;
    //定义下载的线程对象
    private DownThread[] threads;
    //定义下载的文件的总大小
    private int fileSize;

    public void DownUtil(String path, String targetFile, int threadNum){
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        //初始化threads数组
        threads = new DownThread[threadNum];
    }

    public void download() throws IOException {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5*1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept",
                "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                + "application/x-shockwave-flash, application/xaml+xml, "
                + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                + "application/x-ms-application, application/vnd.ms-excel, "
                + "application/vnd.ms-powerpoint, application/msword, */*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");

        //得到文件大小
        fileSize = conn.getContentLength();
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        //设置本地文件的大小



    }



    private class DownThread extends Thread{
        @Override
        public void run(){

        }
    }

}
