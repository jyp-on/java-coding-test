package org.example.inflearn.normal.s8;

import java.util.*;
class P2 {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;
        int n = routes.length; // 호선 개수
        // {역, 호선(set)}
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) { // i는 호선
            for(int line : routes[i]) {
                // line 역이라는 key가 없으면 빈 HashSet 생성
                graph.putIfAbsent(line, new HashSet<Integer>());
                graph.get(line).add(i);
            }
        }
//        for(int key : graph.keySet()) {
//            System.out.print("역 : " + key + " ) 호선 : ");
//            for(int line : graph.get(key)) {
//                System.out.print(line + " ");
//            }
//            System.out.println();
//        }
        Queue<Integer> Q = new LinkedList<>(); // 역 저장
        Q.offer(s);
        int[] ch = new int[n]; // 지나온 호선 체크
        int L = 0; // 환승 횟수
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int curStop = Q.poll(); // 현재역
                for(int line : graph.get(curStop)) { // 현재역에 연결되어 있는 호선
                    if(ch[line] == 0) {
                        ch[line] = 1;
                        for(int stop : routes[line]) { // 각 호선에 있는 역들 Q에 넣기
                            if(stop == e) return L;
                            Q.offer(stop);
                        }
                    }

                }
            }
            L++;
        }


        return -1;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
