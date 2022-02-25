package D3;

import java.io.*;
import java.util.*;

public class Quiz11315 {

	public static void main(String[] args) throws Exception{
		// 오목 판정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		//테스트 케이스 입력 받기
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			//문자열 길이 입력 받기
			int N = Integer.parseInt(br.readLine());
			
			//오목판 입력 공간
			char[][] map = new char[N][N];
			
			//오목판 정보 입력 받기
			for(int i=0;i<N;i++) {
				String temp = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			
			int[] dr = {0,1,1,1}; //우 우하 하 좌하
			int[] dc = {1,1,0,-1};

			//오목 성공여부 변수
			boolean check = false;
			
			//오목탐색
			loop:
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//오목 확인 변수
					int cnt = 0;
					//오목일때
					if(map[i][j]=='o') {
						for(int d=0;d<4;d++) {
							for(int k=1;k<5;k++) {
								int r = i+dr[d]*k;
								int c = j+dc[d]*k;
								if(r>=0&&c>=0&&r<N&&c<N&&map[r][c]=='o') {
									cnt++;
								}
							}
							if(cnt==4) {
								check=true;
								break loop;
							}
							cnt=0;
						}
					}
				}
			}
			sb.append("#"+tc+" ");
			if(check) sb.append("YES"+"\n");
			else sb.append("NO"+"\n");
			
		}
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
