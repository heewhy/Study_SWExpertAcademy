package D4;

import java.io.*;
import java.util.*;

public class Quiz3324 {
	
	static int N,cnt;
	static int[] weight,left;
			
	public static void main(String[] args) throws Exception{
		// 준환이의 양팔저울
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			left = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			cnt=0;
			check(0,0);
			
			sb.append("#"+tc+" "+cnt+"\n");
			
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	//순열
	static void check(int cnt,int flag) { 
		//기저조건
		if(cnt==N) {
			isPossible(0,0,0);
			return;
		}
		
		//유도파트
		for(int i=0;i<N;i++) {
			if((flag&1<<i)!=0) continue;
			left[cnt]=weight[i];
			check(cnt+1,flag|1<<i);
		}
		
	}
	
	
	private static void isPossible(int idx, int sumL, int sumR) {
        if(idx == N ) {
            cnt++;
            return;
        }
        //왼쪽 저울 올리기
        isPossible(idx + 1, sumL + left[idx], sumR);
        //오른쪽 저울 올리기
        if(sumR + left[idx] <= sumL) isPossible(idx + 1, sumL, sumR + left[idx]);
		
	}

}
