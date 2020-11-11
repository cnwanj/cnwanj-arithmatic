package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_java;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: vovhh
 * @Date: 2020-11-10 22:35:26
 * @Description:
 *
 * 试题 D: 最优旅行
 * 本题总分：10 分
 * 【问题描述】
 * 中国的高铁四通八达，乘坐方便，小明经常乘坐高铁在城市间旅游。
 * 现在，小明又有了一个长假，他打算继续乘坐高铁旅游。这次，他打算到
 * 下面的城市旅游。
 * 上海、广州、长沙、西安、杭州、济南、成都、南京、昆明、郑州、天津、
 * 太原、武汉、重庆、南昌、长春、沈阳、贵阳、福州。
 * 小明打算从北京出发，游览以上每个城市正好一次，最终回到北京。在每
 * 个城市（除北京外），小明都至少停留 24 小时。而当小明决定从一个城市去往
 * 另一个城市时，他只会选择有直接高铁连接的城市，不会在中途换乘转车。
 * 在试题目录下有一个文件 trip.txt 保存了小明可以选择的车次，小明不会
 * 选择其他车次。
 * 小明出发的时间是第 1 天的中午 12:00。请问，小明游览完以上城市正好一
 * 次，最终回到北京，最快需要多少分钟（请注意单位为分钟，请注意除北京外
 * 的城市需要至少停留 24 小时，即最少停留 1440 分钟）。
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 */
public class Main4_最优旅行 {

    static int V, beijing;
    static boolean[] visit;
    static List<Edge>[] graph;
    static int endDay = 0x3F3F3F3F;
    static String endTime = "23:59";
    static Map<String, Integer> table;

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream data = null;
        {
            InputStream resource = new FileInputStream("trip.txt");
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            byte[] buff = new byte[8192];
            int len = 0;
            while ((len = resource.read(buff)) != -1)
                byteOut.write(buff, 0, len);
            data = new ByteArrayInputStream(byteOut.toByteArray());
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(data, "gbk"));
        Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]+)");
        table = new HashMap();
        String line = null;
        in.readLine();
        while ((line = in.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String city = matcher.group();
                if (table.get(city) == null)
                    table.put(city, V++);
            }
        }
        data.reset();
        in.close();
        in = new BufferedReader(new InputStreamReader(data, "gbk"));
        line = in.readLine();

        graph = new List[V];
        visit = new boolean[V];
        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList();
        while ((line = in.readLine()) != null) {
            StringTokenizer tok = new StringTokenizer(line);
            Edge edge = new Edge(tok.nextToken(),
                    tok.nextToken(),
                    table.get(tok.nextToken()),
                    tok.nextToken(),
                    tok.nextToken());
            graph[edge.v].add(edge);
        }
        beijing = table.get("北京");
        visit[beijing] = true;
        dfs(beijing, 0, "12:00", 1, new ArrayDeque());
        System.out.println(V);
        System.out.println((endDay + V - 1) + "天 "+ endTime);
    }

    static void dfs(int city, int day, String time, int vcnt, Deque<String> deque) {
        if (day > endDay) return;
        if (vcnt == V) {
            for (Edge edge: graph[city]) {
                if (edge.e == beijing) {
                    int nowDay = day;
                    String nowTime = edge.end;
                    if (nowTime.compareTo(time) > 0) nowDay++;
                    if (nowDay < endDay || nowTime.compareTo(endTime) < 0) {
                        for (String c: deque)
                            System.out.print(c + "<-");
                        System.out.println();
                        endDay = nowDay;
                        endTime = nowTime;
                    }
                }
            }
        } else {
            for (Edge edge: graph[city]) {
                if (visit[edge.e]) continue;
                visit[edge.e] = true;
                deque.push(edge.city);
                dfs(edge.e, day + (time.compareTo(edge.start) > 0? 1: 0), edge.end, vcnt + 1, deque);
                deque.pop();
                visit[edge.e] = false;
            }
        }
    }

    static class Edge {

        int v, e;

        String city, train, start, end;

        Edge(String train, String city, int e, String start, String end) {
            this.v = table.get(city);
            this.city = city;
            this.e = e;
            this.start = start;
            this.end = end;
        }
    }
}
