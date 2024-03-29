package org.example.inflearn.basic.s1;

import java.util.Scanner;

public class P3 {

    public static String solution(String str) {
        String answer = "";
        int max_length = -1;
        String[] split = str.split(" ");

        for (String x : split) {
            if (x.length() > max_length) {
                answer = x;
                max_length = x.length();
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
