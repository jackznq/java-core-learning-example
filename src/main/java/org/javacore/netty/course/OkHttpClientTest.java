package org.javacore.netty.course;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @className: OkHttpClient
 * @description: TODO 类描述
 * @author: znq
 * @date: 2021-07-11
 **/
public class OkHttpClientTest {

    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {

        String url = "http://localhost:8081";
        String result = run(url);
        System.out.println(result);
    }


    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response.body().string();

    }
}
