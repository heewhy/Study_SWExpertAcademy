package D4;

import java.io.*;
import java.util.*;

public class Quiz1233 {
	
	static StringBuilder sb = new StringBuilder();
	static boolean check;

	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = 10;
		
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			char[] tree = new char[N+1];
			
			for(int i=1;i<=N;i++) {
				String[] input = br.readLine().split(" ");
				tree[i] = input[1].charAt(0);
			}
			sb.append("#"+tc+" ");
			check = true;
			dfs(tree,1,N);
			
			if(check) sb.append("1\n");
			else sb.append("0\n");
					
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(char[] tree, int current,int N) {
		if(current>N) {
			return;
		}
		
		int child = current*2;
		
		//현재 노드의 자식노드들 방문
		dfs(tree,current*2,N);
		//현재 노드 방문
		if(tree[current]-'0'>=0&&tree[current]-'0'<=9) { //숫자일때
			if(child>=0&&child<N&&tree[child]-'0'>=0&&tree[child+1]>=0&&tree[child]-'0'<=9&&tree[child+1]-'0'<=9) {
				//자식도 숫자?
				check=false;
				return;
			}
		}else {
			if(child<0&&child<N&&tree[child]-'0'<0&&tree[child+1]<0&&tree[child]-'0'>9&&tree[child+1]-'0'>9) {
				check=false;
				return;
			}
		}
		
		
		dfs(tree,current*2+1,N);
	}

}
