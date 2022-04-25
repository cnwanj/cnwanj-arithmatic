package org.gxuwz.arithmatic.other.android.work2;

// 定义一个多边形抽象类
public abstract class Shape {

    double blength = 3;
    double height = 3;

    public void setBlength(double blength) {
        this.blength = blength;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // 计算面积方法
    public abstract void area();

}

// 三角形
class Triangle extends Shape {

    public void area() {
        double area = (blength * height) / 2;
        System.out.println(area);
    }

}

// 长方形
class Square extends Shape {

    public void area() {
        double area = blength * height;
        System.out.println(area);
    }

}

abstract class Test {

    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.area();
        Square s = new Square();
        s.area();
    }

}
