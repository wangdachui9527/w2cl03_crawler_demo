package com.study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Jsoup解析测试类
 * @Authror 卫骏
 * @Date 2020/1/19 10:41
 */
public class JsoupParseTest {
    @Test
    public void jsoupParseTest() throws Exception {
        Document doc = Jsoup.parse(new URL("https://szsg.2144.cn"), 1000);
        Elements titles = doc.getElementsByTag("title");
        String text = titles.first().text();
        System.out.println(text);
    }
}
