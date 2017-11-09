package org.javacore.classloader;

import java.io.*;

/**
 * 自定义类加载
 * Created by ddfhznq on 2017/11/4.
 */
public class MyClassLoader extends ClassLoader {

    private String root;

    private String name;

    MyClassLoader(String root, String name) {
        this.name = name;
        this.root = root;
    }

    MyClassLoader(ClassLoader parent, String root, String name) {
        super(parent);//父类加载器
        this.name = name;
        this.root = root;
    }

    /**
     * 通过重写该类 自定义
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = readClassFile(name);
        return defineClass(bytes, 0, bytes.length);
    }

    private byte[] readClassFile(String name) {
        InputStream is = null;
        byte[] data = null;
        name = name.replaceAll("\\.", "/");
        String filePath = root + name + ".class";
        File file = new File(filePath);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(file);
            int tmp = 0;
            while ((tmp = is.read()) != -1) {
                out.write(tmp);

            }
            data = out.toByteArray();
        } catch (Exception e) {

        } finally {
           try {
               out.close();
                is.close();
           } catch (IOException e){

           }
        }

        return data;
    }

    @Override
    public String toString() {
        return name;
    }
}
