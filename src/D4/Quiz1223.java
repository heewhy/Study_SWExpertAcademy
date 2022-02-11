package D4;

import java.io.*;
import java.util.*;

public class Quiz1223 {

	public static void main(String[] args) throws Exception {
		// S/W 문제해결 기본] 6일차 - 계산기2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T=10;
		
		for(int tc=1; tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			//문자열에 저장
			String str = br.readLine();
			//후위식
			String bop = "";
			
			Stack<Character> op = new Stack<>();
			Stack<Integer> stack = new Stack<>();
			
			//전위 식을 후위 식으로 변환
			for(int i=0;i<str.length();i++) {
				//현재
				char now = str.charAt(i);
				
				//숫자 담기
				if(0<=now-'0'&&now-'0'<=9) {
					bop +=now;
				}
				else {//연산자
					
					//우선순위
					if(now=='*') op.push(now);
					else {
						while(!op.isEmpty()&&(op.peek()=='*'||op.peek()=='+')) {
							bop += op.pop();
						}
						op.push(now);
					}
				}				
			}
			
			while(!op.empty()) bop+=op.pop();
			
			//System.out.println(bop);
			
			//후위 식 계산
			for(int i=0;i<N;i++) {
				char now = bop.charAt(i);
				
				
				//숫자면 
				if(0<=now-'0'&&now-'0'<=9) {
					stack.push(now-'0');
				}
				else { //연산자면
					int num1 = stack.pop();
					int num2 = stack.pop();
					
					if(now=='*') stack.push(num1*num2);
					else if(now == '+') stack.push(num1+num2);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("#"+tc+" ").append(stack.pop());
			
			bw.write(sb+"\n");
			
		}		
		br.close();
		bw.flush();
		bw.close();
		

	}

}
