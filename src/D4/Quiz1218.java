package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Quiz1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//[S/W 문제해결 기본] 4일차 - 괄호 짝짓기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 10번
		for(int tc=1;tc<=10;tc++) {
			
			//길이 입력 받기
			int N = Integer.parseInt(br.readLine());
			
			Stack<Character> stack = new Stack<>();
			//등호를 담을 list
			char[] list = br.readLine().toCharArray();
			//등호 판별을 위한 배열, 결과확인
			char[] start = {'(','<','[','{'};
			char[] end = {')','>',']','}'};
			int result=1;
			
			loop:
			for(int i=0;i<N;i++) {
				for(int j=0;j<start.length;j++) {
					if(start[j]==list[i]) {
						stack.push(list[i]);
						break;
					}else if(end[j]==list[i]) {
						//괄호가 닫히는 지 검사
						if(start[j]==stack.peek()) {
							stack.pop();
						}else {
							result = 0;
							break loop;
						}
					}
				}
			} 
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(result);
			System.out.println(sb.toString());
			
			
		}
		
	}

}
