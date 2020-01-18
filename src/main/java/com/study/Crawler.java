package com.study;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Authror 卫骏
 * @Date 2020/1/18 17:10
 */
public class Crawler {
    public static void main(String[] args) throws IOException {
        //打开浏览器
        CloseableHttpClient client = HttpClients.createDefault();
        //输入网址
        HttpGet httpGet = new HttpGet("https://szsg.2144.cn/");
        //获取到响应
        CloseableHttpResponse response = client.execute(httpGet);
        //判断响应状态码是否是200
        if(response.getStatusLine().getStatusCode() == 200) {
            //获取响应实体
            HttpEntity entity = response.getEntity();
            //将响应的实体转化程字符串打印
            String content = EntityUtils.toString(entity, "utf8");
            System.out.println(content);
        }
    }
}
