package com.company.tsb;

public class Test3 {

    public static int solution(int[] A) {
        int n = A.length;   //3 - 1000
        int ans = 1000000;
        for (int i = 0; i < n - 1; i++) {  // Change 1: Loop through all elements, not just n-1
            for (int j = i + 1; j < n; j++) {  // Change 2: Add a second loop for different indices
                ans = Math.min(ans, A[i] * A[j]);
            }
        }
        /*for (int i = 0; i <= n - 1; i++) {
            for (int j = i; j <= n - 1; j++) {
                //int checkVal = A[i] * A[j];
                if (((A[i] * A[j]) > 0) && i!=j) {
                    ans = Math.min(ans, A[i] * A[j]);
                }
            }
        }*/
        return ans;
    }

    public static void main(String[] args){
        int[] a = {3,4,4,2};
        int s = solution(a);
        System.out.println(s);

    }
}
