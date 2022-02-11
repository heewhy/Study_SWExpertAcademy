package D3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz1215 {

	public static void main(String[] args) throws FileNotFoundException{
		// [S/W 문제해결 기본] 3일차 - 회문1
		Scanner sc = new Scanner(new File("src/com/step3/input.txt"));
		int T = 10;
		int size = 8;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[][] arr = new char[size][size];
			int length = sc.nextInt();
			int cnt =0;
			
			for(int i=0;i<size;i++) {
				String s = sc.next();
				for(int j=0;j<s.length();j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			//가로
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					boolean t = false;
					for(int k=0;k<length/2;k++) {
						if((j+length-k-1)>=size||(j+k)>=size){
							t=true;
							break;
						}
						if(arr[i][j+k]!=arr[i][j+length-k-1]) {
							t=true;
						}
					}
					if(!t) {
						cnt++;
					}
				}
			}
			
			//세로
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					boolean t = false;
					for(int k=0;k<length/2;k++) {
						if((j+length-k-1)>=size||(j+k)>=size){
							t=true;
							break;
						}
						if(arr[j+k][i]!=arr[j+length-k-1][i]) {
							t=true;
						}
					}
					if(!t) {
						cnt++;
					}
				}
			}
			System.out.println("#"+test_case+" "+cnt);
		}
		
	}

}
