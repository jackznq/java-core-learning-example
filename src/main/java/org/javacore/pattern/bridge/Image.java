package org.javacore.pattern.bridge;

//抽象图像类：抽象类

/**
 * className: Image
 * Package: org.javacore.pattern.bridge
 * Description:
 * Author:znq
 * Date 19/1/7 下午2:31
 */
abstract class Image {
    protected ImageImp imp;

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}

