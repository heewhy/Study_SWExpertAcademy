package D4;

import java.io.*;
import java.util.*;

public class Quiz7465 {

	static int N;
	static int[] parents;
	
	//단위 집합 생성
	public static void makeSet() {
		parents = new int[N+1];
		//자신의 부모노드를 자신의 값으로 세팅
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
	}

	//a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	//a,b 두 집합 합치기
	public static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		// 창용 마을 무리의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
		st = new StringTokenizer(br.readLine());
		//정점의 수
		N = Integer.parseInt(st.nextToken());
		//간선의 수
		int M = Integer.parseInt(st.nextToken());
			
		makeSet();
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}else {
				union(a,a);
			}
			
		}
		
		//System.out.println(Arrays.toString(parents));
		
		int cnt=0;
		
		for(int i = 1; i <= N; i++) if(parents[i] == i) cnt++;
		
		
		
			
		sb.append("#"+tc+" "+cnt+"\n");
			
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
