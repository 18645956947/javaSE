package network_programming;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {

    public static void main(String[] args) {
        //String keyword = URLDecoder.decode()
        String urlStr = URLEncoder.encode("疯狂动物城");
        System.out.println(urlStr);
        String decoder = URLDecoder.decode(urlStr);
        System.out.println(decoder);
    }
}
