package org.gxuwz.arithmatic.lanqiao.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo1 {
    public static void f1() {
        double[] d = {
                152.25, 121.65, 152.56, 451.89,
                166.25, 151.22, 466.45, 11.25,
                445.2, 53.15, 445.21, 63.02,
                546.25, 51.22, 2546.25, 53.22,
                221.21, 411.22, 15.21, 11.01,
                245.56, 12.89, 45.25, 51.65,
                12.28, 21.82, 126.25, 611.8,
                445.21, 546.05, 445.21, 3.02,
                246.4, 21.22, 26.25, 21.22,
                25.21, 311.22, 215.21, 11.01};
        double sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
        }
        System.out.println(sum);
    }

    public static void f2(int a, int n) {
        int r = 1;
        for (int i = 0; i < n; i++) {
            r = r * a;
        }
        System.out.println(r);
    }

    /**
     * 3.（填空题 10分）如下图所示，在二维平面上有无数个1x1的小方格。
     * 我们以某个小方格的一个顶点为圆心画一个半径为5的圆。
     * 计算出这个圆里有个完整的小方格。
     * 只计算一个象限，然后再*4
     * 只需要计算每一个方格的右上角与原点距离是否<=5
     * 通过x和y轴确定每个方格的右上角
     */
    public static int f3(int r, int x, int y) {
        int count = 0;
        for (int i = x + 1; i < r; i++) {
            for (int j = y + 1; j < r; j++) {
                double s = Math.sqrt(i * i + j * j);
                if (s <= r) {
                    count++;
                }
            }
        }
        return count * 4;
    }

    /**
     * 4.（填空题15分）现假设有一根足够长的面筋，假设我们第1次先将面筋对折1次后切半，
     * 那么我们将得到3根面筋，第2次我们将3根面筋分别连续对折2次后切半，
     * 那么我们将得到15根面筋，以此类推，第7次操作后我们将得到多少根面筋。
     * 解答：
     * n: 1   2   3   4
     * p: 1   3   7   15...
     * s: 3   15  135...
     * p = (p-1)*2+1
     * p*s+2*s
     */
    public static int f4(int n) {
        int sum = 1;
        int p = 0;
        for (int i = 1; i <= n; i++) {
            p = p * 2 + 1;
            sum = p * sum + 2 * sum;
        }
        return sum;
    }

    /**
     * 6.（程序题 20分）已知一个整数序列A=(a0,a1,…，an-1),其中0≤ai<n(0≤i<n)。若存在ap1=ap2=…=apm=x且m>n/2（0≤pk<n,1≤k≤m）,则称x为A的主元素。例如A=(0,5,5,3,5,7,5,5),则5为主元素；又如A=(0,5,5,3,5,1,5,7),则A中没有主元素。假设A中的n个元素保存在一个以为数组中，请设计一个尽可能高效的算法，找出A的主元素。若存在主元素，则输出该元素；否则输出-1.
     * 输入：
     * 首先输入n（表示A序列中元素的个数），之后依次输入n个A序列中的各个元素。
     * 输出：
     * A的主元素。若存在主元素，则输出该元素；否则输出-1.
     * 数据样例：
     * 输入：
     * 8
     * 0 5 5 3 5 7 5 5
     * 输出：
     * 5
     */
    public static int f6(int[] A, int n) {
        int i, c, count = 1;                //c用来保存候选主元素，count用来计数
        c = A[0];                        //首先假设A[0]为候选主元素
        for (i = 1; i < n; i++) {                //查找候选主元素
            if (A[i] == c) {
                count++;                //依次遍历查找，找到的话个数加一
            } else {
                if (count > 0)
                    count--;            //抵消
                else {
                    c = A[i];
                    count = 1;        //count<0则更改候选主元素
                }
            }
        }

        if (count > 0) {
            for (i = count = 0; i < n; i++)
                if (A[i] == c)
                    count++;
        }
        if (count > n / 2)
            return c;
        else
            return -1;
    }

//    public static int f7(int[] A, int n){
//        int c, count = 1;
//        c = A[0];
//        for(int i=0; i<n; i++){
//            if(A[i] == c){
//                count ++;
//            }else{
//                if(count > 0){
//                    count --;
//                }else{
//                    c = A[i];
//                    count = 1;
//                }
//            }
//        }
//        if(count > 0){
//            for (int i = 0; i < n; i++) {
//                if(A[i] == c){
//                    count ++;
//                }
//            }
//        }
//        if(count > n/2){
//            return c;
//        }else{
//            return -1;
//        }
//    }

    /**
     * 8.（程序题 10分）质数（Prime number，又称素数），
     * 指在大于1的自然数中，除了1和该数自身外，无法被其他自然数整除的数。
     * 而10以内的质数有2, 3, 5, 7共四个，其中最大的两个数为5和7，
     * 我们把5加上1称之为小合数（6），把7加上1称之为大合数（8），
     * 而小合数与大合数的最大公约数与最小公倍数之和称之为10的有缘数（24+2=26），
     * 现要求编写一道程序，程序开始时输入n（10≤n≤200），求n的有缘数。
     * 输入：
     * 输入n（10≤n≤200）
     * 输出：
     * n的有缘数
     * 数据样例：
     * 输入：
     * 10
     * 输出：
     * 26
     */
    public static void f8() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 10 || n > 200) {
            System.out.println("n的取值范围：10<=n<=200");
            return;
        }
        // 求质数
        List<Integer> list = prime(n);
        // 求大合数
        int max = maxNum(list);
        // 求小合数
        int min = minNum(list);
        // 最大公约数
        int div = divisor(max, min);
        // 最小公倍数
        int mul = multiple(max, min);
        System.out.println(div + mul);
    }

    // 求质数
    public static List<Integer> prime(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = n; i > 1; i--) {
            if (i == 3) {
                list.add(i);
            } else if (i % 2 != 0 && i % 3 != 0) {
                list.add(i);
            }
        }
        return list;
    }

    // 求大合数
    private static int maxNum(List<Integer> list) {
        return list.get(0) + 1;
    }

    // 求小合数
    private static int minNum(List<Integer> list) {
        return list.get(1) + 1;
    }

    // 最大公约数
    private static int divisor(int max, int min) {
        if (max % min == 0) {
            return min;
        }
        return divisor(min, max % min);
    }

    // 最小公倍数
    private static int multiple(int max, int min) {
        return (max * min) / divisor(max, min);
    }

    public static void main(String[] args) {
//        f2(6, 6);
//        System.out.println(Math.sqrt(2));
//        System.out.println(f3(5, 0, 0));
//        System.out.println(f4(3));

//        第六题
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = input.nextInt();
//        }
//        System.out.println(f7(arr, n));

//        第八题
//        f8();

//        第七题
        String str1 = "loading";
        String str2 = "being";
        Node node1 = new Node(1, "a");
        Node node2 = new Node(2, "i");
        Node node3 = new Node(3, "n");
        Node node4 = new Node(4, "g");

        Node node5 = new Node(5, "b");
        Node node6 = new Node(6, "i");
        Node node7 = new Node(7, "n");
        Node node8 = new Node(8, "g");
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
//        for(int i=0; i<str1.length(); i++){
//            list1.addNode(new Node(i, str1.charAt(i)+""));
//        }
//        for(int i=0; i<str2.length(); i++){
//            list2.addNode(new Node(i, str2.charAt(i)+""));
//        }
        list1.addNode(node1);
        list1.addNode(node2);
        list1.addNode(node3);
        list1.addNode(node4);

        list2.addNode(node5);
        list2.addNode(node6);
        list2.addNode(node7);
        list2.addNode(node8);
        list1.show(list1.getHead());
        list2.show(list2.getHead());

        System.out.println(list1.size(list1.getHead()));

    }
}

/**
 * 7.（程序题 20分）假定采用带头结点的单链表保存单词，
 * 当两个单词有相同的后缀时，则可共享相同的后缀存储空间，
 * 例如，“loading”和“being”的存储映像如下图所示。
 * <p>
 * 设str1和str2分别指向两个单词所在的单链表的头结点，
 * 链表结点结构为,请设计一个时间上尽可能高效的算法，
 * 找出由str1和str2所指向两个链表共同后缀的起始位置（如图中国字符i所在结点的位置p在str1单词中为第5个，在str1单词中为第3个）。
 * 输入：
 * 输入str1和str2两个单词
 * 输出：
 * 输出str1和str2所指向两个链表共同后缀的起始位置，如果不存在共同后缀的起始位置则输出-1。
 * 数据样例：
 * 输入：
 * loading
 * being
 * 输出：
 * 5 3
 */
class LinkedList {
    // 初始化头结点
    Node head = new Node(0, "");

    public Node getHead() {
        return head;
    }

    public void prepare(Node a, Node b) {

    }

    public void f7() {
//        Node node1 = new Node(1, "loading");
//        Node node2 = new Node(1, "being");
//        String str1 = "loading";
//        String str2 = "being";
//        for(int i=0; i<str1.length(); i++){
//            addNode(new Node(i, str1.charAt(i)+""));
//        }
//        for(int i=0; i<str2.length(); i++){
//            addNode(new Node(i, str2.charAt(i)+""));
//        }
    }

    // 添加节点
    public void addNode(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    // 取出
//    public Node getNode(int n){
//        if(head.next == null){
//            return;
//        }
//    }
    // 显示
    public void show(Node head) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) break;
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 链表总数
    public int size(Node head) {
        if (head.next == null) return 0;
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class Node {
    public int id;
    public String word;
    public Node next;
    public Node pre;

    public Node(int id, String word) {
        this.id = id;
        this.word = word;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", word=" + word +
                '}';
    }
}
