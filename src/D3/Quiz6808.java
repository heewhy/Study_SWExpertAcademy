package D3;

import java.io.*;
import java.util.*;


public class Quiz6808 {
	
	static int N,R,win_cnt,lose_cnt;
	static int[] input,numbers,check;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		// 규영이와 인영이의 카드게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			win_cnt=0;
			lose_cnt=0;
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[19];
			
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				arr[a]++;
			}
			
			N=9;
			R=9;
			check = new int[N];
			input = new int[N];
			numbers = new int[R];
			visited = new boolean[N];
			
			
			int input_idx=0;
			int check_idx=0;
			for(int i=1;i<=18;i++) {
				if(arr[i]!=1) {
					input[input_idx] = i;
					input_idx++;
				}else {
					check[check_idx]=i;
					check_idx++;
				}
			}
//			System.out.println("input");
//			System.out.println(Arrays.toString(input));
//			System.out.println("check");
//			System.out.println(Arrays.toString(check));
			
			perm(0);
			
			sb.append("#"+tc+" "+lose_cnt+" "+win_cnt+"\n");
			
		}
		
		
		bw.write(sb.toString());
		
		
		
		br.close();
		bw.flush();
		bw.close();

	}

	
	/**
	 * 순열
	 * @param 고른 자리수
	 * */
	private static void perm(int cnt) {
		if(cnt==9) {
			int win_sum=0;
			int lose_sum=0;
			for(int i=0;i<R;i++) {
				if(numbers[i]>check[i]) {
					win_sum+=numbers[i]+check[i];
				}else {
					lose_sum+=numbers[i]+check[i];
				}
			}
			if(win_sum>lose_sum) {
				win_cnt++;
			}else {
				lose_cnt++;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			numbers[cnt] = input[i];
			perm(cnt+1);
			visited[i] = false;
		}
		
	}

}
