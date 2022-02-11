package D2;

import java.util.Scanner;

public class Quiz1954_2 {
	
	private static int[][] map;
	private static int cnt;
	private static int n;
	
	public static void move(int r,int c) {

		
		if(cnt==n*n) return;
		
		//처음 찍기
		map[r][c]=++cnt;
		
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};
		
		//테두리 돌기
		for(int i=0; i<di.length;i++) {
			for(int j=1;j<n;j++) {
				r = r+di[i];
				c = c+dj[i];
				if(r>=0&&c>=0&&r<n&&c<n&&map[r][c]==0) {
					map[r][c]=++cnt;
				}
			}
		}
		
		/*	1	2	3	4
		 * 
		 * 	12	0	0	5
		 * 
		 * 	11	0	0	6
		 * 				
		 * 	10	9	8	7
		 */			
		
		//0찾기 무조건 좌상단이 먼저찾아져야하는데 ..
		loop:
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0) {
					r=i;
					c=j;
					break loop;
				}
			}
		}
		
//		System.out.println("r ="+r);
//		System.out.println("c ="+c);
		move(r,c);
		
	}

	public static void main(String[] args) {
		// 1954. 달팽이 숫자 D2 이따가 1244
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};
		
		move(0,0);

		
		for(int[] arr : map) {
			for(int a : arr) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
		
	}

}
