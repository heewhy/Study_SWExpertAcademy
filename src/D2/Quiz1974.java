package D2;

import java.io.*;
import java.util.*;

public class Quiz1974 {

	static int[][] a = new int[9][9];
	static boolean check;
	
	public static void main(String[] args) throws Exception{
		// 스도쿠 검증
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			for(int i=0;i<9;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//for(int[] b : a) System.out.println(Arrays.toString(b));
			
			check=true;
			int answer=0;
			vaild();
			if(check) answer=1;
			else answer=0;
			
			sb.append("#"+tc+" "+answer+"\n");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void vaild() {
		//행과 열 체크
		for(int i=0;i<9;i++) {
			int rowsum=0;
			int colsum=0;
			for(int j=0;j<9;j++) {
				rowsum+=a[j][i];
				colsum+=a[i][j];
			}
			if(colsum!=45) { 
				check=false;
				return;
			}
			if(rowsum!=45) {
				check=false;
				return;
			}
		}
		
		//3x3체크
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int sum=0;
				for(int k=0;k<3;k++) {
					for(int l=0;l<3;l++) {
						sum+=a[i*3+k][j*3+l];
					}
				}
				if(sum!=45) {
					check=false;
					return;
				}
			}
		}
	}

}
/*
1
7 3 6 4 2 9 5 8 1
5 8 9 1 6 7 3 2 4
2 1 4 5 8 3 6 9 7
8 4 7 9 3 6 1 5 2
1 5 3 8 4 2 9 7 6
9 6 2 7 5 1 8 4 3
4 2 1 3 9 8 7 6 5
3 9 5 6 7 4 2 1 8
6 7 8 2 1 5 4 3 9 
 */