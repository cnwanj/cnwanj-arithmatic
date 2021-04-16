package org.gxuwz.arithmatic.lanqiao;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 */
public class Main1 extends ClassLoader {

    private String path;

    // 默认构造方法，使用根加载器getSystemClassLoader()
    public Main1() {
        super();
    }

    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        // 若自定义路径不为空，设置自定义路径名称
        if (path != null) {
            // 获取全路径中末尾的类名称
            name = path + name.substring(name.lastIndexOf(".") + 1) + ".class";
        } else {
            name = splitDot("out.production.MyProject_02_arithmetic." + name) + ".class";
        }
        FileInputStream inputStream = null;
        ByteOutputStream outputStream = null;
        byte[] res = null;
        try {
            // 文件输入流获取文件数据
            inputStream = new FileInputStream(new File(name));
            // 获取输出流
            outputStream = new ByteOutputStream();
            // 创建缓冲区
            byte[] buf = new byte[2];
            int len = -1;
            // 循环的将缓冲区输出到输出流中
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            // 返回输出流字节数组
            res =  outputStream.toByteArray();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    // 将"."替换成"/"
    private String splitDot(String s) {
        return s.replace(".", "/");
    }

    public static void main(String[] args) throws Exception {
        Main1 main1 = new Main1();
        // 自定义类路径，D:/MyClass.class
        main1.path = "D:/";
        Class<?> myClass = main1.loadClass("org.gxuwz.arithmatic.lanqiao.MyClass");
        // 621009875
        // 1173230247
//        System.out.println(myClass.hashCode());
//        System.out.println(myClass.getClassLoader());
    }
}
class MyClass {}
