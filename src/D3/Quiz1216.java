package D3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz1216 {

	public static void main(String[] args) throws FileNotFoundException{
		// [S/W 문제해결 기본] 3일차 - 회문2
		Scanner sc = new Scanner(new File("src/com/step3/input.txt"));
		int T = 10;
		int size = 100;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tc = sc.nextInt();
			char[][] arr = new char[size][size];
			
			for(int i=0; i<100; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			int max = 0;
			for(int k=0; k<100; k++) {
				for(int l=99; l>k+max-1; l--) {
					
					int length = l-k+1;
					int half = length/2;
					
					//가로
					for(int i=0; i<100; i++) {
						boolean flag = true;
						for(int j=0; j<half; j++) {
							if(arr[i][k+j] != arr[i][l-j]) {
								flag = false;
								break;
							}
						}
						if( !flag ) continue;
						if( length > max ) max = length;
					}
					
					//세로
					for(int i=0; i<100; i++) {
						boolean flag = true;
						for(int j=0; j<half; j++) {
							if(arr[k+j][i] != arr[l-j][i]) {
								flag = false;
								break;
							}
						}
						if( !flag ) continue;
						if( length > max ) max = length;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
		
	}

}
