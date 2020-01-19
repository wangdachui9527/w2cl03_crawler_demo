package com.study;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Authror 卫骏
 * @Date 2020/1/18 17:53
 */
public class HttpGetConfigTest {
    public static void main(String[] args) {
        //打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //输入url地址
        HttpGet httpGet = new HttpGet("https://github.com/");

        //请求配置,对连接超时时间，请求超时时间以及数据传输超时时间的设置
        RequestConfig build = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(10 * 1000)
                .build();
        //设置到httpGet中
        httpGet.setConfig(build);
        //获取响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            //判断响应是否是200
            if(response.getStatusLine().getStatusCode() == 200){
                //解析响应实例
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "utf8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭响应
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭浏览器
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
