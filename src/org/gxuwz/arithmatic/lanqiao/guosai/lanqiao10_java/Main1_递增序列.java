package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: vovhh
 * @Date: 2020-11-10 22:35:26
 * @Description:
 *
 * 试题 A: 递增序列
 * 本题总分：5 分
 * 【问题描述】
 * 对于一个字母矩阵，我们称矩阵中的一个递增序列是指在矩阵中找到两个
 * 字母，它们在同一行，同一列，或者在同一 45 度的斜线上，这两个字母从左向
 * 右看、或者从上向下看是递增的。
 * 例如，如下矩阵中
 * LANN
 * QIAO
 * 有LN、LN、AN、AN、IO、AO、LQ、AI、NO、NO、AQ、IN、AN 等 13 个
 * 递增序列。注意当两个字母是从左下到右上排列时，从左向右看和从上向下看
 * 是不同的顺序。
 * 对于下面的 30 行 50 列的矩阵，请问总共有多少个递增序列？（如果你把
 * 以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在
 * 试题目录下有一个文件 inc.txt，内容与下面的文本相同）
 * VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG
 * SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF
 * ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA
 * BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL
 * YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH
 * ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU
 * XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR
 * ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG
 * MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA
 * VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF
 * GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC
 * EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK
 * PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW
 * CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP
 * RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS
 * PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR
 * JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL
 * YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP
 * HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN
 * DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF
 * LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW
 * CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ
 * IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI
 * ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB
 * HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP
 * FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS
 * VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ
 * BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR
 * RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY
 * ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 答案：52800
 */
public class Main1_递增序列 {

    static int N = 30, M = 50, count = 0;
//    static Set<String> set = new HashSet<String>();

    /**
     * LANN
     * QIAO
     * LANN
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] a = new char[N][M];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextLine().toCharArray();
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(a[i]));
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 行
                for (int k = j + 1; k < M; k++) {
                    if (a[i][j] < a[i][k]) {
                        count ++;
//                        System.out.println(a[i][j] + "" + a[i][k]);
                    }
                }
                // 列
                for (int k = i + 1; k < N; k++) {
                    if (a[i][j] < a[k][j]) {
                        count ++;
//                        System.out.println(a[i][j] + "" + a[k][j]);
                    }
                }
                // 右下斜线
                int x = i + 1;
                int y = j + 1;
                while (x < N && y < M && x >= 0 && y >= 0) {
                    if (a[i][j] < a[x][y]) {
                        count ++;
//                        System.out.println(a[i][j] + "" + a[x][y]);
                    }
                    x++;
                    y++;
                }
                // 左下斜线
                x = i + 1;
                y = j - 1;
                while (x < N && y < M && x >= 0 && y >= 0) {
                    if (a[i][j] < a[x][y]) {
                        count ++;
//                        System.out.println(a[i][j] + "" + a[x][y]);
                    }
                    x++;
                    y--;
                }
                // 右上斜线
                x = i - 1;
                y = j + 1;
                while (x < N && y < M && x >= 0 && y >= 0) {
                    if (a[i][j] < a[x][y]) {
                        count ++;
//                        System.out.println(a[i][j] + "" + a[x][y]);
                    }
                    x--;
                    y++;
                }
            }
        }
        System.out.println(count);
    }
}
