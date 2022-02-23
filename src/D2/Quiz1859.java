package D2;

import java.io.*;
import java.util.*;

public class Quiz1859 {

	public static void main(String[] args) throws Exception{
		// 백만장자프로젝트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			int size = Integer.parseInt(br.readLine());
			int[] arr = new int[size];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
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

			
			
			sb.append("#"+tc+" "+sum+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
