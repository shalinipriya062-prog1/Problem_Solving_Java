package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDistances {


    public static void main(String[] args) {
        int[][] edges = {{0,6,3},{6,5,3},{0,3,1},{3,2,7},{3,1,6},{3,4,2}};
        List<int[]>[] g;
        int signalSpeed = 3;
        g = new List[edges.length + 1];
        int[] ans = countPairsOfConnectableServers(edges,signalSpeed, g);
        for(int i: ans)
            System.out.println(i);
    }

    public static int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed, List<int[]>[] g) {
        int n = edges.length + 1;

        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1], w = e[2];
            g[a].add(new int[] {b, w});
            g[b].add(new int[] {a, w});
        }
        int[] ans = new int[n];
        for (int a = 0; a < n; ++a) {
            int s = 0;
            for (var e : g[a]) {
                int b = e[0], w = e[1];
                int t = dfs(b, a, w, signalSpeed, g);
                ans[a] += s * t;
                s += t;
            }
        }
        return ans;
    }

    private static int dfs(int a, int fa, int ws, int signalSpeed , List<int[]>[] g) {
        int cnt = ws % signalSpeed == 0 ? 1 : 0;
        for (var e : g[a]) {
            int b = e[0], w = e[1];
            if (b != fa) {
                cnt += dfs(b, a, ws + w, signalSpeed, g);
            }
        }
        return cnt;
    }


}
