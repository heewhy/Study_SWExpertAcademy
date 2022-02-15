package D4;

import java.io.*;
import java.util.*;

public class Quiz5432 {

	public static void main(String[] args) throws Exception{
		// 쇠막대기 자르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String s = br.readLine();
			int answer=0;
			int cnt=0;
			
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c=='(') cnt++;
				else {
					cnt--;
					if(s.charAt(i-1)=='(') {//레이저
						answer+=cnt;
					}else {//쇠막대기
						answer++;
					}
				}
			}
			
			sb.append("#"+tc+" "+answer+"\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
