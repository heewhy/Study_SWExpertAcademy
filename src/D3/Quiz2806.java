package D3;

import java.util.Scanner;

public class Quiz2806 {

	public static void main(String[] args) throws Exception{
		// 2806. N-Queen
		
				Scanner sc = new Scanner(System.in);
				int T = sc.nextInt();
				

				for(int test_case = 1; test_case <= T; test_case++)
				{
					int size = sc.nextInt();
					int[][] map = new int[size][size];
					
					//퀸의개수
					int cnt=0;
					
					int[] di = {-1,-1,0,1,1,1,0,-1};
					int[] dj = {0,1,1,1,0,-1,-1,-1};
					
//					int[] di1 = {-2,1,2,-1};
//					int[] dj1 = {1,2,-1,-2};
//					
//					int[] di2 = {-1,2,-1,-2};
//					int[] dj2 = {2,1,-2,-1};
					
					for(int i=0;i<map.length;i++) {
						for(int j=0;j<map[i].length;j++){
							if(map[i][j]==0) {
								map[i][j]=1;
								if(size==1) cnt++;
							//퀸의 개수
							for(int k=0;k<size;k++) {
								for(int l=0;l<9;l++) {
										for(int move=1;move<size;move++) {
											int r = i + di[l]*move;
											int c = j + dj[l]*move;
								
											if(r>=0&&r<map.length&&c>=0&&c<map.length) {
												map[r][c]++;
												cnt++;
											}
										}
									}
								
								}
							}
						}
					}
				}
			}
		
	}

