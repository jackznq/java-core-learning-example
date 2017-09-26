package org.javacore.netty.callbacks;

/**
 * Created by ddfhznq on 2017/9/26.
 */
public class MyFetcher implements Fetcher {

    final Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetcherCallback callback) {
        try {
            callback.onData(data);
        } catch (Exception e) {
            callback.onError(e);
        } finally {

        }
    }
}
