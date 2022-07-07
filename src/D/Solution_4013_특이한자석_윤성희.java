package D;

import java.io.*;
import java.util.*;

public class Solution_4013_특이한자석_윤성희 {
	
	static class gear{
		private LinkedList<Integer> info;

		public gear(LinkedList<Integer> info) {
			super();
			this.info = info;
		}


		public boolean isChain(gear gear) {
			if(this.info.get(6)+gear.info.get(2)==1) return true;
			return false;
		}
		
	}
	
	static gear[] gears = new gear[5];

	public static void main(String[] args) throws Exception{
		// 특이한 자석
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int K = Integer.parseInt(br.readLine());
			
			for(int i=1;i<=4;i++) {
				LinkedList<Integer> info = new LinkedList<Integer>();
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					int num = Integer.parseInt(st.nextToken());
					info.add(num);
				}
				gears[i] = new gear(info);
			}
			
			while(K-->0) {
				st = new StringTokenizer(br.readLine());
				int gearNum = Integer.parseInt(st.nextToken());
				int turnDir = Integer.parseInt(st.nextToken());
				
				rotateR(gearNum+1,-turnDir);
				rotate(gearNum,turnDir);
			}
			int ans=0;
			int score=1;
			
			for(int i=1;i<=4;i++) {
//				for(int j=0;j<8;j++) {
//					System.out.print(gears[i].info.get(j));
//				}
//				System.out.println();
				if(gears[i].info.peek()>0) {
					ans+=score;
				}
				score*=2;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		
		br.close();
	}

	private static void rotateR(int gearNum, int turnDir) {
		if(gearNum<5&&gears[gearNum].isChain(gears[gearNum-1])) {
			rotateR(gearNum+1,-turnDir);
			//시계 방향
			if(turnDir>0) {
				gears[gearNum].info.addFirst(gears[gearNum].info.pollLast()); 
			}
			//반시계 방향
			else {
				gears[gearNum].info.addLast(gears[gearNum].info.pollFirst());
			}
			
		}
		
	}

	private static void rotate(int gearNum, int turnDir) {
		
		//다음 기어
		//범위 체크, 연결되어있는지
		if(gearNum-1>0&&gears[gearNum].isChain(gears[gearNum-1])) {
			rotate(gearNum-1,-turnDir);
		}
		
		//시계 방향
		if(turnDir>0) {
			gears[gearNum].info.addFirst(gears[gearNum].info.pollLast()); 
		}
		//반시계 방향
		else {
			gears[gearNum].info.addLast(gears[gearNum].info.pollFirst());
		}
		
	}

}
