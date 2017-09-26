package org.javacore.netty.callbacks;

/**
 * Created by ddfhznq on 2017/9/26.
 */
public interface FetcherCallback {

    void onData(Data data) throws Exception;

    void onError(Throwable t);
}
