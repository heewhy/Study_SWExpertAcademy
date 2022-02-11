package D3;

import java.io.*;
import java.util.*;


public class Quiz2805 {

	public static void main(String[] args) throws Exception {
		// 농작물 수확하기
		//System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			//농장의 크기
			int N = Integer.parseInt(br.readLine());
			int[][] field = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					field[i][j] = input.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if((i+j >= N/2) && (i+j < N + N/2) && (j-i <= N/2) && (i-j <= N/2)) {
						sum += field[i][j];
					}
				}
			}
					
			// 출력
			System.out.println("#" + tc + " " + sum);			
			
		}
		
		br.close();
	}

}
