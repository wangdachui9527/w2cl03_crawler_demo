package com.study;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 使用连接池来开启浏览器连接
 * @Authror 卫骏
 * @Date 2020/1/18 19:04
 */
public class HttpClientPoolTest {
    public static void main(String[] args) {
        //创建连接池管理器
        PoolingHttpClientConnectionManager phccm = new PoolingHttpClientConnectionManager();
        //设置最大连接数100
        phccm.setMaxTotal(100);
        //设置每个主机最大连接数10
        phccm.setDefaultMaxPerRoute(10);

        //模拟多次使用get请求访问浏览器获取数据
        doGet(phccm);
        doGet(phccm);
    }

    /**
     * Get请求获取浏览器数据
     * @param phccm
     */
    private static void doGet(PoolingHttpClientConnectionManager phccm) {
        //从连接池中获取httpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(phccm).build();
        //请求地址
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity, "utf8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
