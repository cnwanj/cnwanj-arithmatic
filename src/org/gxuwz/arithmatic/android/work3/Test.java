package org.gxuwz.arithmatic.android.work3;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws SQLException {
        StudentData data = new StudentData();
        // 添加
        Student stu = new Student(null, "张三", 1, "17软件2班", "2020年01月");
        int n = data.add(stu);
        if (n > 0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");

        // 删除
        int d = data.delete(1);
        if (d > 0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败！");

        // 修改
        Student stu1 = new Student(1, "李四", 0, "17软件2班", "2020年02月");
        int u = data.update(stu1);
        if (u > 0)
            System.out.println("修改成功！");
        else
            System.out.println("修改失败！");

        // 查询
        List<Student> listStu = data.find();
        if (listStu.size() == 0)
            System.out.println("结果为空！");
        else {
            for (Student stu2 : listStu) {
                System.out.println(stu2);
            }
        }
    }
}
