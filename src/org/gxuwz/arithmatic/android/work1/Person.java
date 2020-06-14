package org.gxuwz.arithmatic.android.work1;

public class Person {

    Integer pNo;
    String pName;
    String pSex;
    Integer pAge;

    public Person() {
    }

    public Person(Integer pNo, String pName, String pSex, Integer pAge) {
        this.pNo = pNo;
        this.pName = pName;
        this.pSex = pSex;
        this.pAge = pAge;
    }

    public Integer getpNo() {
        return pNo;
    }

    public String getpName() {
        return pName;
    }

    public String getpSex() {
        return pSex;
    }

    public Integer getpAge() {
        return pAge;
    }
}

class Student extends Person {

    double sAnd;

    public Student() {
    }

    public Student(Integer pNo, String pName, String pSex, Integer pAge, double sAnd) {
        this.pNo = pNo;
        this.pName = pName;
        this.pSex = pSex;
        this.pAge = pAge;
        this.sAnd = sAnd;
    }

    public String toString() {
        return "学号: " + pNo + ", 姓名: " + pName + ", 性别: " + pSex + ", 年龄: " + pAge + ", Android: " + sAnd;
    }

    // 计算平均分
    public static double average(double[] scores) {
        return maxAndMin(scores)[2];
    }

    // 计算最大值
    public static double max(double[] scores) {
        return maxAndMin(scores)[0];
    }

    // 计算最小值
    public static double min(double[] scores) {
        return maxAndMin(scores)[1];
    }

    // 计算最小值、最大值的、平均分公共部分
    public static double[] maxAndMin(double[] scores) {
        double max = scores[0];
        double min = scores[0];
        double sum = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max)
                max = scores[i];
            if (scores[i] < min)
                min = scores[i];
            sum += scores[i];
        }
        return new double[]{max, min, sum / scores.length};
    }

    public static void main(String[] args) {
        // 创建并打印学生信息
        Student s1 = new Student(1, "张三", "男", 23, 90);
        System.out.println(s1);
        Student s2 = new Student(2, "李四", "女", 24, 81);
        System.out.println(s2);
        Student s3 = new Student(3, "王五", "男", 25, 82);
        System.out.println(s3);
        Student s4 = new Student(4, "赵六", "女", 26, 85);
        System.out.println(s4);
        Student s5 = new Student(5, "陶七", "男", 27, 88);
        System.out.println(s5);

        // 获取平均分
        double[] scores = {s1.sAnd, s2.sAnd, s3.sAnd, s4.sAnd, s5.sAnd};
        System.out.println(average(scores));

        // 获取最大值
        System.out.println(max(scores));

        // 获取最小值
        System.out.println(min(scores));
    }
}
