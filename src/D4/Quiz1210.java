package D4;

import java.io.*;
import java.util.*;

public class Quiz1210 {

	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 기본] 2일차 - Ladder1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		for(int tc=1;tc<=10;tc++) {
			//현재 tc
			int T = Integer.parseInt(br.readLine());
			
			//배열의 크기
			int N = 100;
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[100][100];
			int r = 0, c = 0, ans = 0;
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j]== 2){
						r=i;
						c=j;
					}
				}
			}
			
			//for(int[] a : map) System.out.println(Arrays.toString(a));
			
			
			//종착지에서 출발
			//좌우위
			int[] dr = {0, 0, -1};
		    int[] dc = {-1, 1, 0};
			
		    while (true) {
                boolean flag = false;
                visit[r][c] = true;
                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr == 0) { //시작점에 도달했을 때
                        ans = c;
                        flag = true;
                        break;
                    }
                    //이동하기
                    if (nr < 0 || nc < 0 || nc > 99 || map[nr][nc] == 0 ||  visit[nr][nc]) continue;
                    r = nr;
                    c = nc;
                    break;
                }
                if (flag) break;
            }
			
			
			
			bw.write("#"+T+" "+ans+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
