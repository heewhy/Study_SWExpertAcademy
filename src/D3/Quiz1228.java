package D3;


import java.io.*;
import java.util.*;

public class Quiz1228 {

	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 기본] 8일차 - 암호문1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		
		for(int tc=1;tc<=T;tc++) {
			//암호문 숫자
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<String> result = new LinkedList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<10;i++) {
				result.add(st.nextToken());
			}
			
			//명령어
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=M;i++) {
				st.nextToken(); //I
				int idx = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				
				for(int j=idx;j<idx+cnt;j++) {
					if(j>=10) st.nextToken();
					else {
						result.add(j,st.nextToken());
						result.removeLast();
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			while(result.size()>0) {
				sb.append(" "+result.removeFirst());
			}
			bw.write("#"+tc+sb+"\n");
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	}//end main

}
