package org.gxuwz.arithmatic.designPattern.main1_接口隔离原则;

public class Segregation {
    public static void main(String[] args) {
        B b = new B();
        b.operation1();
        b.operation2();
        b.operation3();
    }
}

interface Interface1 {
    void operation1();
}

interface Interface2 {
    void operation2();

    void operation3();
}

interface Interface3 {
    void operation4();

    void operation5();
}

class B implements Interface1, Interface2 {

    @Override
    public void operation1() {
        System.out.println("方法1");
    }

    @Override
    public void operation2() {
        System.out.println("方法2");
    }

    @Override
    public void operation3() {
        System.out.println("方法3");
    }
}

class D implements Interface1, Interface3 {

    @Override
    public void operation1() {
        System.out.println("方法1");
    }

    @Override
    public void operation4() {
        System.out.println("方法4");
    }

    @Override
    public void operation5() {
        System.out.println("方法5");
    }
}

// 实现接口 1 2 3
class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }
}

// 实现接口 1 4 5
class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface3 i) {
        i.operation4();
    }

    public void depend5(Interface3 i) {
        i.operation5();
    }
}
