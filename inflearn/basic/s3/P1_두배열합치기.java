package org.example.inflearn.basic.s3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1_두배열합치기 {
    public static ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while(p1<arr1.length && p2<arr2.length) {
            if (arr1[p1] <= arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while(p1 < arr1.length) answer.add(arr1[p1++]);
        while(p2 < arr2.length) answer.add(arr2[p2++]);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i<m; i++){
            arr2[i] = sc.nextInt();
        }

        for (int x : solution(arr1, arr2)) {
            System.out.print(x + " ");
        }
    }
}
