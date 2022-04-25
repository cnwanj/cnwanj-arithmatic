package org.gxuwz.arithmatic.other.android.work4;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Stream {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\work4.txt";
        // 输入
        input(fileName, "Hello Android\nI love you");
        // 输出
        String text = output(fileName);
        // 显示到JFrame窗口
        jFrame(text);
    }

    // 输入
    public static void input(String fileName, String text) throws IOException {
        File file = new File(fileName);
        // 若不存在则创建该文件
        if (!file.exists())
            file.createNewFile();
        // 创建输入流将内容写入
        FileWriter writer = new FileWriter(fileName);
        writer.write(text);
        writer.close();
    }

    // 输出
    public static String output(String fileName) throws IOException {
        // 创建缓冲区
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        // 对文件进行每一行的读取
        String line = reader.readLine();
        StringBuffer str = new StringBuffer();
        // 若第一行存在信息则进行读取
        while (line != null) {
            str.append(line + "\n");
            line = reader.readLine();
        }
        reader.close();
        return String.valueOf(str);
    }

    // 显示窗口
    public static void jFrame(String text) {
        // 创建一个窗口
        JFrame frame = new JFrame();
        // 创建一个容器
        JPanel panel = new JPanel();
        // 创建一个文本域
        JTextArea textArea = new JTextArea();
        // 设置容器布局为网格布局
        panel.setLayout(new GridLayout());
        textArea.setText(text);
        // 当TextArea里的内容过长时生成滚动条
        panel.add(new JScrollPane(textArea));
        frame.add(panel);
        frame.setSize(400, 400);
        // 显示窗口
        frame.setVisible(true);
    }
}
