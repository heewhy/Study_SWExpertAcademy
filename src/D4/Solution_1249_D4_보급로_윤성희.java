package D4;

import java.io.*;
import java.util.*;

public class Solution_1249_D4_보급로_윤성희 {

	static int N;
	static int[][] map;
	static int[][] dp;
	static int dr[] = {-1,0,1,0};
 	static int dc[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 응용] 4일차 - 보급로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dp = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j)-'0';
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(0,0);
			
			System.out.println("#"+tc+" "+dp[N-1][N-1]);
		}
		
		br.close();
	}

	private static void bfs(int i, int j) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		dp[i][j] = map[i][j];
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0&&nc>=0&&nr<N&&nc<N) {
					if (dp[nr][nc] > dp[r][c] + map[nr][nc]) {
						dp[nr][nc] = dp[r][c] + map[nr][nc];
						q.add(new int[] {nr, nc});
					}
				}
			}
			
		}
		
	}

}
