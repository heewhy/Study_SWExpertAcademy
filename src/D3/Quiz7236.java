package D3;

import java.io.*;
import java.util.*;

public class Quiz7236 {
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1}; //8방 탐색 상부터 시계
	static int[] dc = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws Exception{
		// 7236. 저수지의 물의 총 깊이 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트 케이스 횟수 입력 받기
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			//저수지 구획의 크기
			int N = Integer.parseInt(br.readLine());
			//저수지 생성
			char[][] lake = new char[N][N];
			
			//저수지 정보 입력
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					lake[i][j] = st.nextToken().charAt(0);
				}
			}

			//입력 확인
			//for(char[] c : lake)System.out.println(c);
			
			//저수지의 최대 깊이 저장변수
			int ans = Integer.MIN_VALUE;
			
			//저수지 탐색
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(lake[i][j]=='W') {
						//주변 탐색
						int cnt=0;
						
						for(int d=0;d<8;d++) {
							int r = i+dr[d];
							int c = j+dc[d];
							
							if(r>=0&&c>=0&&r<N&&c<N&&lake[r][c]=='W') {
								//주변 W(물) 만큼 깊이 증가
								cnt++;
							}
						}
						//주변이 다 G'땅'일 경우
						if(cnt==0) cnt=1;
						
						//호수 깊이를 최대깊이로 갱신
						ans = Math.max(ans, cnt);
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
