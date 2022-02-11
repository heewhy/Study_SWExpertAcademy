package D2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz1859 {

	public static void main(String[] args) throws FileNotFoundException{
		// 백만장자프로젝트
		Scanner sc = new Scanner(new File("src/com/step2/input1859.txt"));
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T;tc++) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			
			for(int i=0;i<arr.length;i++) {
				arr[i] = sc.nextInt();
			}
			
//			for(int i : arr) {
//				System.out.println(i);
//			}
			
			//int save=0;
			long sum=0;
			
			for(int i=size-1;i>=0;i--) {
//				if(check>=arr[i]) {
//					cnt++;
//					save += arr[i];
//					check = arr[i];
//				}else {
//					sum += arr[i]*cnt-save;
//					save=0;
//					cnt=0;
//				}
				int j = i-1;
				int save=0;
				while(j>=0&&arr[i]>arr[j]) {
						//파는날의 매매가 더하기
						save += arr[i];
						//사는날의 매매가 빼기
						save -= arr[j];
						j--;
				}
				
				sum += save;
				i = j+1;
			}
			
			//else if(arr[i+j]<arr[i+j+1]){

			
			
			
			System.out.println("#"+tc+" "+sum);
		}

	}

}
