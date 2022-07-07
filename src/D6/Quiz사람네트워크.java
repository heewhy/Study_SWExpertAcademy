package D6;

import java.io.*;
import java.util.*;

public class Quiz사람네트워크 {

	static int N;
	static final int INF = 2000;//최대한 경유했을 때 비용보다 좀 더 큰 값으로 설정
	static int[][] adjMatrix;
	
	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 응용] 8일차 - 사람 네트워크2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			//인접행렬 입력 받기
			adjMatrix = new int[N+1][N+1];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					int val = Integer.parseInt(st.nextToken());
					if(val==1) adjMatrix[i][j] = val;
					//자기자신으로의 거리정보가 아니고 인접해있지 않다면 INF로 채우기
					else if(i!=j) adjMatrix[i][j] = INF;
				}
			}
			
			//경유지 -> 출발지 -> 도착지
			for(int k=1;k<=N;++k) {// k : 경유지
//				if(i==k) continue;
				for(int i=1;i<=N;++i) {	//i : 출발지
					for(int j=1;j<=N;++j) {//j : 도착지
//						if(i==j || j==k) continue; 
						//k=3 인 경우 아래 값들의 의미
						//경유지 1,2 모두 고려한 i->j 최단거리 와  
						//i -> k -> j (i->k 최단거리) + (k->j 최단거리) 비교
						if(adjMatrix[i][j]>adjMatrix[i][k]+adjMatrix[k][j]) {
							adjMatrix[i][j]=adjMatrix[i][k]+adjMatrix[k][j];
						}
						//adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i]
					}
				}
			}
			
			System.out.println("#"+tc+" "+getMinCC());
			
		}
		
		
		br.close();
	}
	private static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(adjMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}

	//최소 CC 값 반환
	private static int getMinCC() {
		int minCC = Integer.MAX_VALUE;
		
		//각 행별 총합 중 최솟값 구하기
		for(int i=1; i<=N; i++) {
			int curCC = 0;
			for(int j=1; j<=N; j++) {
				curCC+=adjMatrix[i][j];
			}
			minCC = Math.min(minCC, curCC);
		}
		
		return minCC;
	}

}
