package D2;

import java.io.*;
import java.util.*;

public class Quiz1940 {

	public static void main(String[] args) throws Exception{
		// 가랏! RC카!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트케이스 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int C = Integer.parseInt(br.readLine());
			int distance=0;
			int speed=0;
			
			for(int i=0;i<C;i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				
				if(cmd==0) {
					distance+=speed; 
				}else if(cmd==1) {
					int s = Integer.parseInt(st.nextToken());
					speed += s;
					distance+=speed;
				}else if(cmd==2) {
					int s = Integer.parseInt(st.nextToken());
					if(speed>s) {
						speed -= s;
						distance+=speed;
					}else {
						speed =0;
					}
				}
			}
			
			sb.append("#"+tc+" "+distance+"\n");
		}
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
