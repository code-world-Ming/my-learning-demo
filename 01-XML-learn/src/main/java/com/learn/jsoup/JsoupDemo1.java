package com.learn.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupDemo1 {
    private static Document document = null;

    static {
        try {
            String path = JsoupDemo1.class.getClassLoader().getResource("User.xml").getPath();
            //获取document对象
            document = Jsoup.parse(new File(path), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过标签名获取元素
     */
    @Test
    void test1(){
        Elements elementsByTag = document.getElementsByTag("user");
        System.out.println(elementsByTag);
        System.out.println("------------------");
    }

    /**
     * 通过ID获取元素
     */
    @Test
    void test2(){
        Element elementById = document.getElementById("2");
        System.out.println(elementById);
        System.out.println("------------------");
    }

    /**
     * 通过属性获取元素
     */
    @Test
    void test3(){
        Elements elementsByAttribute = document.getElementsByAttribute("id");
        System.out.println(elementsByAttribute);
        System.out.println("------------------");
    }

    /**
     * 获取标签中的内容
     */
    @Test
    void test4(){
        //通过标签名获取
        Elements elements = document.getElementsByTag("user");
        System.out.println(elements.size());
        for (Element element : elements) {
            //获取标签中的html内容
            System.out.println(element.html());
            Elements allElements = element.getElementsByTag("name");
            System.out.println("id:"+element.attr("id"));
            for (Element allElement : allElements) {
                //获取标签中的文字内容
                System.out.println(allElement.text());
            }
        }
    }

    /**
     * 选择器获取元素
     */
    @Test
    void test5(){
        //获取用户标签中id 为2的元素
        Elements select1 = document.select("user[id ='2']");
        System.out.println(select1);
        //获取用户标签中id 为2，子标签为age的元素
        Elements select2 = document.select("user[id ='2'] > age");
        System.out.println(select2);
    }

    /**
     * XPath获取元素
     */
    @Test
    void test6(){
        JXDocument jxDocument = JXDocument.create(document);

        // //user:直接获取整个doc中的user节点
        List<JXNode> jxNodes = jxDocument.selN("//user");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("---------------------------------");

        // 获取user节点下的所有name节点
        List<JXNode> jxNodes1 = jxDocument.selN("//user/name");
        for (JXNode jxNode : jxNodes1){
            System.out.println(jxNode);
        }
        System.out.println("---------------------------------");

        // 获取name节点中带有test属性的节点
        List<JXNode> jxNodes2 = jxDocument.selN("//user/name[@test]");
        for (JXNode jxNode : jxNodes2){
            System.out.println(jxNode);
        }

        // 获取name节点中带有test属性的节点
        List<JXNode> jxNodes3 = jxDocument.selN("//user/name[@test]");
        for (JXNode jxNode : jxNodes3){
            System.out.println(jxNode);
        }
    }
}
