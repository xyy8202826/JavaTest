package com.xyy;
/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author XYY
 * @version Id: LianhangHao.java, v 0.1 2018/3/20 14:51 xuyuanye Exp $$
 */
public class LianhangHao {
    public static void main( String[] args )
    {
        while(true){
            CloseableHttpClient httpCilent2 = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(50000)   //设置连接超时时间
                    .setConnectionRequestTimeout(50000) // 设置请求超时时间
                    .setSocketTimeout(50000)
                    .setRedirectsEnabled(true)//默认允许自动重定向
                    .build();
            HttpGet httpGet2 = new HttpGet("http://127.0.0.1:8080/");
            httpGet2.setConfig(requestConfig);
            String srtResult = "";
            try {
                HttpResponse httpResponse = httpCilent2.execute(httpGet2);
                //System.out.println(httpResponse.);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    httpCilent2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
