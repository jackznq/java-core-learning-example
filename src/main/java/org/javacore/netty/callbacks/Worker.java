package org.javacore.netty.callbacks;

/**
 * Created by ddfhznq on 2017/9/26.
 */
public class Worker {

    public void doWork(){
        Fetcher fetcher = new MyFetcher(new Data(1,1));
        fetcher.fetchData(new FetcherCallback() {
            @Override
            public void onData(Data data) throws Exception {
                System.out.println("data receive"+data);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("data error");
            }
        });
    }

    public static void main(String []args){
        new Worker().doWork();
    }
}
