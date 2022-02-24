package D3;

import java.io.*;
import java.util.*;

public class Quiz1220 {

	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 기본] 5일차 - Magnetic
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트 케이스 횟수 
		int T = 10;
		
		//테스트 케이스만큼 반복
		for(int tc=1;tc<=T;tc++) {
			//한 변의 길이 입력
			int N = Integer.parseInt(br.readLine());
			//입력 정보 저장
			int[][] map = new int[N][N];
			
			//맵 정보 입력 - 비교를 위해 거꾸로 넣기
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			//1은 아래로 2는 위로 12가 교착상태
			int ans=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//1일때 2를 만날때까지 탐색
					if(map[i][j]==1) {
						for(int k=0;k<N-j;k++) {
							if(map[i][j+k]==2) {
								ans++;
								//j위치 변경
								j=j+k;
								break;
							}
						}
					}
				}
			}
			
			sb.append("#"+tc+" "+ans+"\n");
			
			
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
