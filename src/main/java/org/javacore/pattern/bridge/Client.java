package org.javacore.pattern.bridge;


class Client {
    public static void main(String args[]) {
        Image image;
        ImageImp imp;
        image = new Image() {
            @Override
            public void parseFile(String fileName) {

            }
        };
        imp = new ImageImp() {
            @Override
            public void doPaint(Matrix m) {

            }
        };
        image.setImageImp(imp);

        image.parseFile("小龙女");
    }
}

