package D4;

import java.io.*;
import java.util.*;

public class Quiz3289 {

	static int N;
	static int[] parents;
	
	//단위 집합 생성
	public static void makeSet() {
		parents = new int[N+1];
		//자신의 부모노드를 자신의 값으로 세팅
		for(int i=1;i<N;i++) {
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
		// 서로소 집합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			sb.append("#"+tc+" ");
			while(M-->0) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(num==1) {
					if(findSet(a)==findSet(b)) sb.append(1);
					else sb.append(0);
				}else {
					union(a,b);
				}
				
			}
			sb.append("\n");
		
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
