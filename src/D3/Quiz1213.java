package D3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz1213 {

	public static void main(String[] args) throws FileNotFoundException {
		// [S/W 문제해결 기본] 3일차 - String
		Scanner sc = new Scanner(new File("src/com/step3/input.txt"));
		int T = 10;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tc = sc.nextInt();
			
			int cnt=0;
			//찾을 값입력
			String val = sc.next();
			//문장 받기
			String str = sc.next();
			
			
//			System.out.println(val);
//			System.out.println(str);
			
//			System.out.println(str.substring(0,1));
//			System.out.println(str.substring(0, 2));
			
//			if(val.length()==2) {
//				for(int i=0; i<str.length()-1;i++) {
//					String a = str.substring(i, i+2);
//					if(val.equals(a)) {
//						cnt++;
//					}
//				
//				}
//			}else {
//				for(int i=0; i<str.length()-2;i++) {
//					String a = str.substring(i, i+3);
//					if(val.equals(a)) {
//						cnt++;
//					}
//				
//				}
//			}
			
			for(int i=0; i<str.length()-val.length()+1;i++) {
				
				String a = str.substring(i, i+val.length());
				
				if(val.equals(a)) {
					cnt++;
				}
			
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
