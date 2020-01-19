package com.study;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 带参数的POST请求
 * @Authror 卫骏
 * @Date 2020/1/18 17:53
 */
public class HttpPostParamTest {
    public static void main(String[] args) {
        //打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //输入url地址
        HttpPost httpPost = new HttpPost("https://tieba.baidu.com/f");
        //使用集合封装参数对象 NameValulePair
        List<NameValuePair> param = new ArrayList<>();
        //封装参数到NameValuePair的实现类
        param.add(new BasicNameValuePair("kw","2144手游"));
        param.add(new BasicNameValuePair("fr","wwwt"));

        try {
            //创建表单Entity对象，第一个参数是封装的参数对象集合，第二个参数是字符集
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(param,"utf8");
            httpPost.setEntity(encodedFormEntity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //获取响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
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
