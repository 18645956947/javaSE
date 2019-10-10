package network_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 向指定URL发送GET请求
 * @author zhx
 */
public class GetPostTest {

    public static String sendGet(String url, String param){
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //建立实际的连接
            conn.connect();
            //获取所有响应头的字段
            Map<String, List<String>> map = conn.getHeaderFields();
            //遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));)
            {
                String line;
                while ((line = in.readLine()) != null){
                    result += "\n"+line;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "aaa";
    }

}
