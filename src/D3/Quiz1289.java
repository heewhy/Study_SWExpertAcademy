package D3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz1289 {

	public static void main(String[] args) throws FileNotFoundException {
		// T원재의 메모리 복구하기
		//1. 메모리의 길이 1~50
		//2. 배열의 인덱스를 바꾸면 뒤의 배열도 해당 값으로 바뀜
		//3. 최종으로 주어진 값과 같아져야함
		
		Scanner sc = new Scanner(new File("src/com/ssafy/ws01/input1289.txt"));
		
		//테스트케이스 입력받기
		int T = sc.nextInt();
		
		//테스트 케이스만큼 반복
		for(int tc=1; tc<=T;tc++) {
			//메모리의 원래 값 받기
			String str = sc.next();
			int[] answer = new int[str.length()];
			
			for(int i=0;i<str.length();i++) {
				answer[i] = str.charAt(i)-'0';
			}
			
			
			int cnt=0;
			for(int i=0;i<answer.length;i++) {
				//1부터 시작이면 카운트 미리 증가
				if(i==0&&answer[i]==1) cnt++;
				//앞의 숫자와 다르면 카운트 증가
				if(i+1<answer.length&&answer[i]!=answer[i+1]) {
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}
		
			
	}

}
