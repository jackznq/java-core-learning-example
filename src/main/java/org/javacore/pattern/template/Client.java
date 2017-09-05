package org.javacore.pattern.template;

/**
 * Created by ddfhznq on 2017/9/5.
 */
public class Client {
    public static void main(String []args){
        String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
        AbstractImageLoader loader =new  WebpImageLoader();
        System.out.println(loader.downloadImage(imageUrl,200,200));
    }

}
