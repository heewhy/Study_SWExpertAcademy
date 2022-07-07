package JUNGOL;

import java.io.*;
import java.util.*;

public class Quiz2577 {
	
	static int plateCnt;
	static int foodType;
	static int eatCnt;
	static int CPNum;
	static int[] foods;
	static int[] selected;

	public static void main(String[] args) throws Exception{
		// 회전 초밥(고)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		plateCnt = Integer.parseInt(st.nextToken());
		foodType = Integer.parseInt(st.nextToken());
		eatCnt = Integer.parseInt(st.nextToken());
		CPNum = Integer.parseInt(st.nextToken());
				
		selected = new int[foodType+1];
		foods = new int[plateCnt];
		
		for(int i=0;i<plateCnt;i++) {
			foods[i] = Integer.parseInt(br.readLine());
		}
		
		int max = eat(0,0);
		
		System.out.println(max);
		br.close();
	}

	private static int eat(int total,int max) {
		for(int i=0;i<eatCnt;i++) {
			if(selected[foods[i]]==0) total++;
			selected[foods[i]]++;
		}
		
		max = total;
		
		for(int i=1;i<plateCnt;i++) {
			if(max <= total) {
				if(selected[CPNum]==0) max = total+1;
				else max = total;
			}
			selected[foods[i-1]]--;
			if(selected[foods[i-1]]==0) total--;
			
			if(selected[foods[(i+eatCnt-1)%plateCnt]]==0) total++;
			selected[foods[(i+eatCnt-1)%plateCnt]]++;
		}
		
		
		return max;
	}

}
