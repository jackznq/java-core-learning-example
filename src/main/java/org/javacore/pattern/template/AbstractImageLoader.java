package org.javacore.pattern.template;

public abstract class AbstractImageLoader {

    //抽象类定义整个流程骨架
    public String downloadImage(String imageUrl, int width, int height) {
        //先获取最终的数据源URL
        return getUrl(imageUrl, width, height);
        //然后开始执行下载
    }

    //以下是不同子类根据自身特性完成的具体步骤
    protected abstract String getUrl(String imageUrl, int width, int height);
}
