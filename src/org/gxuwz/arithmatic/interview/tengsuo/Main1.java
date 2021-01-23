package org.gxuwz.arithmatic.interview.tengsuo;

import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2021-01-22 14:43:31
 * @Description: 腾梭科技笔试
 *
 * 密码安全等级
 */
public class Main1 {

    boolean zd, zx, s, f;

    public String getSecurityLevel(String password) {
        int score = 0;
        score = check1(score, password);
        score = check2(score, password);
        score = check3(score, password);
        score = check4(score, password);
        score = check5(score);
        if (score >= 90)
            return "VERY_SECURE";
        else if (score >= 80)
            return "SECURE";
        else if (score >= 70)
            return "VERY_STRONG";
        else if (score >= 60)
            return "STRONG";
        else if (score >= 50)
            return "AVERAGE";
        else if (score >= 25)
            return "WEAK";
        else
            return "VERY_WEAK";
    }

    public int check1(int score, String password) {
        int len = password.length();
        if (len <= 4)
            score += 5;
        else if (len <= 7)
            score += 10;
        else
            score += 25;
        return score;
    }

    public int check2(int score, String password) {
        zd = false;
        zx = false;
        boolean tag1 = false;
        boolean tag2 = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90)
                tag1 = true;
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122)
                tag2 = true;
        }
        zd = tag1;
        zx = tag2;
        if (tag1 && tag2)
            score += 20;
        else if (tag1 || tag2)
            score += 10;
        return score;
    }

    public int check3(int score, String password) {
        s = false;
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57)
                count ++;
        }
        if (count > 0)
            s = true;
        if (count > 1)
            score += 20;
        else if (count == 1)
            score += 10;
        return score;
    }

    public int check4(int score, String password) {
        f = false;
        int count = 0;
        // 48 57 -- 65 90 -- 97 122
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c < 48 || (c > 57 && c < 65) || (c > 90 && c < 97) || c > 122)
                count ++;
        }
        if (count > 0)
            f = true;
        if (count > 1)
            score += 25;
        else if (count == 1)
            score += 10;
        return score;
    }

    public int check5(int score) {
        if (zd && zx && s && f)
            score += 5;
        else if ((zd || zx) && s && f)
            score += 3;
        else if ((zd || zx) && s)
            score += 2;
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            Main1 m = new Main1();
            System.out.println(m.getSecurityLevel(s));
        }
    }
}
