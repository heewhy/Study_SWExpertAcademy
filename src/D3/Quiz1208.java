package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//[S/W 문제해결 기본] 1일차 - Flatten
		//Tc
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			
			int N = 100;
			int cnt = Integer.parseInt(br.readLine());//덤프횟수
			int[] height = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//높이 값 입력받기
			for(int i=0; i<N;i++) height[i] = Integer.parseInt(st.nextToken()); 
			
			//초기 정렬
			Arrays.sort(height);
			
			for(int i=0; i<cnt;i++) {
				height[0]++;
				height[99]--;
				Arrays.sort(height);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(height[99]-height[0]);
			
			System.out.println(sb.toString());
			
			
		}
	}

	

}
