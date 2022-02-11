package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz5215 {

	static int[] score,kal,result,kal_result;
	static int N,limit,sum,kal_sum,answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//햄버거 다이어트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			// 재료 개수 칼로리 제한
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			// 재료 점수 , 칼로리
			score = new int[N];
			kal = new int[N];
			
			for(int i =0;i<N;i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st1.nextToken());
				kal[i] = Integer.parseInt(st1.nextToken());
			}
			
//			System.out.println(Arrays.toString(score));
//			System.out.println(Arrays.toString(kal));
			
			
			//칼로리 아래의 재료를 조합해서 점수가 가장 높은것
			result = new int[N];
			kal_result = new int[N];
			sum=0;
			kal_sum=0;
			answer=0;
			
			for(int i=1;i<=N;i++) {
				combination(0,0,i);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(answer);
			
			System.out.println(sb.toString());
				
		}//tc 끝
		
	}

	public static void combination(int cnt,int start,int R ) {
		//기저조건
		if(cnt == R) {
			for(int i =0;i<score.length;i++) {
				sum+=result[i];
				kal_sum+=kal_result[i];
			}
			if(kal_sum<limit) {
				answer = Math.max(answer, sum);
			}
			sum=0;
			kal_sum=0;
			
			return;
		}
		
		
		for(int i=start;i<score.length;i++) {
			result[cnt] = score[i];
			kal_result[cnt] = kal[i];
			combination(cnt+1,i+1,R); //다음 자리는 현재 뽑은 i의 다음 수부터
		}
		
	}

}
