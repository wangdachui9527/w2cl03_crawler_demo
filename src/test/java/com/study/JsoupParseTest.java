package com.study;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
}
