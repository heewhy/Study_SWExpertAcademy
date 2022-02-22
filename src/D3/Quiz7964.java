package D3;

import java.io.*;
import java.util.*;

public class Quiz7964 {

	public static void main(String[] args) throws Exception{
		// 부먹왕국의 차원 관문
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int cnt=0;
			int ans=0;
			while(N-->0) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					cnt=0;
				}else {
					cnt++;
				}
				
				if(cnt==D) {
					cnt=0;
					ans++;
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
