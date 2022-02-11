package D2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Quiz2001 {

	public static void main(String[] args) throws IOException {
		// 파리퇴치
		System.setIn(new FileInputStream("src/com/ssafy/hw02/input2001.txt"));
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int sum=0;
			int max = Integer.MIN_VALUE;
			
			
			int[][] map = new int[N][N];
			
			//map 입력받기
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {				
					sum=0;
					for(int k=0;k<M;k++) {
						for(int l=0;l<M;l++) {
							int r = i+k;
							int c = j+l;
							if(r>=0&&c>=0&&r<N&&c<N) {
								sum+=map[r][c];
							}
						}
					}
					if(sum>max) max= sum;
					
				}
			}
			
			System.out.println("#"+test_case+" "+max);
			
			
		}

	}

}
