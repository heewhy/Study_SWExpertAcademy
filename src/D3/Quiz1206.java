package D3;

import java.io.*;
import java.util.*;

public class Quiz1206 {

	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 기본] 1일차 - View
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int sum=0;
			for(int i=2;i<list.size()-2;i++) {
				int front = Math.max(list.get(i-1), list.get(i-2));
				int back = Math.max(list.get(i+1), list.get(i+2));
				int max =Math.max(front, back);
				if(list.get(i)-max>0) {
					sum+=list.get(i)-max;
				}
			}
			
			sb.append("#"+tc+" "+sum+"\n");
			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
