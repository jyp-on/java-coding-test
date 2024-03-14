package org.example.inflearn.normal.s3;
import java.util.*;
public class P2 {
    public String solution(String s){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                ArrayList<Character> arr = new ArrayList<>();
                while(true){
                    char p = stack.pop();
                    if(p=='(') break;
                    else arr.add(p);
                }
                if(stack.peek()=='(') {
                    String v_target = "";
                    for(int j=arr.size()-1; j>=0; j--){
                        v_target += arr.get(j); // reverse
                    }
                    for(int j=0; j<arr.size(); j++){
                        stack.add(v_target.charAt(j)); // add
                    }
                } else {
                    int v = stack.pop()-'0';
                    String v_target = "";
                    for(int j=arr.size()-1; j>=0; j--){
                        v_target += arr.get(j); // reverse
                    }
                    for(int j=0; j<v*arr.size(); j++){
                        stack.add(v_target.charAt(j%arr.size())); // add
                    }
                }

            }
            else stack.push(c);
        }
        for(char x : stack){
            answer += String.valueOf(x);
        }

        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
//        System.out.println(T.solution("3(a2(b))ef"));
//        System.out.println(T.solution("2(ab)k3(bc)"));
//        System.out.println(T.solution("2(ab3((cd)))"));
//        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
//        System.out.println(T.solution("3(ab2(sg))"));
    }
}
