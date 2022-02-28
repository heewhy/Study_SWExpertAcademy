package D3;

import java.io.*;
import java.util.*;

public class Quiz13038 {

	public static void main(String[] args) throws Exception{
		// 교환학생
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트 케이스 입력 받기
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int week[] = new int[7];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<7;i++) {
				week[i] = Integer.parseInt(st.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			for(int start=0;start<7;start++) {
				//수업이 시작하는 모든 요일 처리
				if(week[start]==0) continue; //수업이 열리지 않은 날은 패스
				
				int day=start,cnt=0;
				while(true) {
					if(week[day%7]==1) cnt++; //수업이 열리면 카운팅
					
					++day; //하루지남
					if(cnt==N) { //머무른 최소일수
						min = Math.min(min, day-start);
						break;
					}
				}
			}
			
			sb.append("#"+tc+" "+min+"\n");
			
			
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
