package com.study;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.awt.image.TileObserver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

/**
 * Jsoup解析测试类
 * @Authror 卫骏
 * @Date 2020/1/19 10:41
 */
public class JsoupParseTest {
    /**
     * 使用Jsoup解析网址Url上的数据
     * @throws Exception
     */
    @Test
    public void jsoupParseTest() throws Exception {
        Document doc = Jsoup.parse(new URL("https://szsg.2144.cn"), 1000);
        Elements titles = doc.getElementsByTag("title");
        String text = titles.first().text();
        System.out.println(text);
    }

    /**
     * 使用Jsoup解析String字符串中的数据
     * @throws Exception
     */
    @Test
    public void jsoupParseStringTest() throws Exception {
        String content = FileUtils.readFileToString(new File("C:\\Users\\admin123\\Desktop\\test.html"), "utf8");
        Document doc = Jsoup.parse(content);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    /**
     * Jsoup解析文件数据
     * @throws Exception
     */
    @Test
    public void JsoupParseFileTest() throws Exception {
        Document content = Jsoup.parse(new File("C:\\Users\\admin123\\Desktop\\test.html"), "utf8");
        String title = content.getElementsByTag("title").first().text();
        System.out.println(title);
    }


    @Test
    public void JsoupParseByDom() throws IOException {
        Document document = Jsoup.parse(new File("C:\\Users\\admin123\\Desktop\\test.html"), "utf8");
        //根据id获取元素
//        Element fourL = document.getElementById("fourL");
//        String text = fourL.text();
//        String[] infos = text.split("查看详情");
//        for (String info : infos) {
//            System.out.println(info);
//        }
        //根据class获取元素
//        Elements elementsByClass = document.getElementsByClass("four-txt");
//        String text1 = elementsByClass.first().text();
//        System.out.println(text1);

        //根据属性的key和value来获取元素
        Elements href = document.getElementsByAttributeValue("href", "/view/id/171081");
        System.out.println(href.first().text());
    }

    @Test
    public void getJsoupParseData() throws IOException {
        Document d = Jsoup.parse(new File("C:\\Users\\admin123\\Desktop\\test.html"), "utf8");
        //从元素中获取id
        Element pbc1 = d.getElementById("pbc1");
//        Elements href = pbc1.getElementsByAttributeValue("href", "/view/id/171971");
//        System.out.println(href.first().text());
        String id = pbc1.attr("id");
        System.out.println("元素id：" + id);
        //从元素中获取className
        String s = pbc1.className();
        System.out.println("元素类名：" + s);
        Set<String> classNameSet = pbc1.classNames();
        for (String s1 : classNameSet) {
            System.out.println("元素类名：" + s1);
        }
        //从元素中获取所有属性
        Attributes attributes = pbc1.attributes();
        System.out.println("所有属性：" + attributes.toString());

    }
}
