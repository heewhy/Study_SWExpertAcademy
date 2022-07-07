package D;

import java.io.*;
import java.util.*;

public class Quiz4014 {

	static int N; // 맵 크기
	static int M; // 활주로 높이
	static int[][] map;
	static int[][] rmap;
	
	public static void main(String[] args) throws Exception{
		// [모의 SW 역량테스트] 활주로 건설
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			rmap = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					rmap[j][i] = num;
				}
			}
			
//			int[] temp = {4,4,3,3,3,3,2,2,2};
//			System.out.println(isValid(temp));
			int ans=0; // 활주로 설치 가능 개수
			for(int i=0;i<N;i++) {
				if(isValid(map[i],new boolean[N])) ++ans;
				if(isValid(rmap[i],new boolean[N])) ++ans;
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
		
		br.close();

	}

	/**
	 * 활주로 설치 가능 여부
	 * @param arr
	 * @param visited
	 * @return
	 */
	private static boolean isValid(int[] arr,boolean[] visited) {
		for(int i=1;i<N;i++) {
			int idx = i-1;
			//같은 경우
			if(arr[idx]==arr[i]) continue;
			
			//감소하는 경우
			if(arr[idx]==arr[i]+1) {
				int num = arr[i];
				if(i+(M-1)>=N) {
					return false;
				}
				for(int j=i;j<i+M;j++) {
					//이전과 높이가 다르거나 경사로가 설치 되어있다면
					if(arr[j]!=num||visited[j]) {
						return false;
					}
					else {
						visited[j] = true;
					}
				}
			}
			//증가하는 경우
			else if(arr[idx]==arr[i]-1) {
				int num = arr[idx];
				if(idx-(M-1)<0) return false;
				for(int j=idx;j>idx-M;j--) {
					//이전과 높이가 다르거나 경사로가 설치 되어있다면
					if(arr[j]!=num||visited[j]) {
						return false;
					}
					else {
						visited[j] = true;
					}
				}
			}
			//숫자가 1 차이 나지 않는 경우
			else {
				return false;
			}
		}
		
		return true;
	}

}
