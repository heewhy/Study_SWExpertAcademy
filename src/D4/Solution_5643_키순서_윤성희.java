package D4;

import java.io.*;
import java.util.*;

public class Solution_5643_키순서_윤성희 {

	static int N;
	static int[][] adjMatrix;
	static int[][] radjMatrix;
	
	public static void main(String[] args) throws Exception{
		// [Professional] 키 순서
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {

			N = Integer.parseInt(br.readLine()); //학생들의 수
			int M = Integer.parseInt(br.readLine()); //비교한 횟수
			
			adjMatrix = new int[N+1][N+1];
			
			int from,to;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				radjMatrix[to][from] = adjMatrix[from][to] = 1;
			}
			
			int ans = 0; //자신의 키를 알 수 있는 학생 수
			
			//방법 1. BFS 탐색
//			for(int i=1;i<=N;i++) {
//				if(gtBFS(i, new boolean[N+1])+ltBFS(i, new boolean[N+1]) == N-1){
//					++ans;
//				}
//			}
			
			//방법 2. DFS 탐색
//			for(int i=1;i<=N;i++) {
//				gtDFS_ans=0;
//				ltDFS_ans=0;
//				gtDFS(i,new boolean[N+1]);
//				ltDFS(i,new boolean[N+1]);
//				if(gtDFS_ans+ltDFS_ans == N-1) {
//					++ans;
//				}
//			}
				
			//방법 3. 통합
			for(int i=1;i<=N;i++) {
				DFS_ans=0;
				DFS(i,new boolean[N+1],adjMatrix);
				DFS(i,new boolean[N+1],radjMatrix);
				if(DFS_ans == N-1) ++ans;
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
		}

		br.close();
	
	}
	
	/**
	 * 모든 학생 들여다 보며 자신보다 키가 큰 학생 따라 BFS 탐색
	 * @param start 시작정점
	 * @param visited
	 * @return
	 */
	static int gtBFS(int start,boolean[] visited) {
		
		int cnt=0;
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			
			int current = q.poll();
			
			for(int i=1;i<=N;i++) { //모든 학생 들여다 보며 자신보다 키가 큰 학생 따라 탐색
				if(adjMatrix[current][i] != 0 && !visited[i]) {
					++cnt;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
		return cnt;
	}
	
	/**
	 * 모든 학생 들여다 보며 자신보다 키가 작은 학생 따라 BFS 탐색
	 * @param start 시작정점
	 * @param visited
	 * @return
	 */
	static int ltBFS(int start,boolean[] visited) {
		
		int cnt=0;
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			
			int current = q.poll();
			
			for(int i=1;i<=N;i++) { 
				if(adjMatrix[i][current] != 0 && !visited[i]) {
					++cnt;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}
	
	static int gtDFS_ans = 0;
	/**
	 * 모든 학생 들여다 보며 자신보다 키가 큰 학생 따라 DFS 탐색
	 * @param cur 현재정점
	 * @param visited
	 */
	static void gtDFS(int cur,boolean[] visited) {
		visited[cur] = true;
		
		for(int i=1;i<=N;i++) {
			if(adjMatrix[cur][i] != 0 && !visited[i]) {
				++gtDFS_ans;
				gtDFS(i,visited);
			}
		}
		
	}
	static int ltDFS_ans = 0;
	/**
	 * 모든 학생 들여다 보며 자신보다 키가 작은 학생 따라 DFS 탐색
	 * @param cur 현재정점
	 * @param visited
	 */
	static void ltDFS(int cur,boolean[] visited) {
		visited[cur] = true;
		
		for(int i=1;i<=N;i++) {
			if(adjMatrix[i][cur] != 0 && !visited[i]) {
				++ltDFS_ans;
				ltDFS(i,visited);
			}
		}
		
	}
	
	static int DFS_ans=0;
	/**
	 * 코드의 재사용성을 활용해 키가 크고 작은 학생 모두 DFS 탐색
	 * @param cur 현재정점
	 * @param visited
	 * @param adj 키가 큰, 작은을 결정하는 2차원 배열
	 */
	static void DFS(int cur,boolean[] visited,int[][] adj) {
		visited[cur] = true;
		
		for(int i=1;i<=N;i++) {
			if(adj[cur][i] != 0 && !visited[i]) {
				++DFS_ans;
				DFS(i,visited,adj);
			}
		}
	}
	
}
