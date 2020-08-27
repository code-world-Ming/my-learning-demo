package com.learn.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }
}
