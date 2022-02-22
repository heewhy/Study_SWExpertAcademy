package D3;

import java.io.*;
import java.util.*;

public class Quiz4047 {

	public static void main(String[] args) throws Exception{
		// 영준이의 카드 카운팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			int[] counting = new int[4];
			int[][] card = new int[4][14];
			
			for(int i=0;i<=str.length()-3;i+=3) {
				String temp =str.substring(i,i+3);
				//System.out.println(temp);
				char shape = temp.charAt(0);
				String num = temp.substring(1,3);
				//System.out.println(shape);
				//System.out.println(num);
				
				switch (shape) {
				case 'S':
					counting[0]++;
					card[0][Integer.parseInt(num)]++;
					break;
				case 'D':
					counting[1]++;
					card[1][Integer.parseInt(num)]++;
					break;
				case 'H':
					counting[2]++;
					card[2][Integer.parseInt(num)]++;
					break;
				case 'C':
					counting[3]++;
					card[3][Integer.parseInt(num)]++;
					break;
				}
				
			}
			//System.out.println(Arrays.toString(counting));
			
			boolean check = true;
			
			sb.append("#"+tc+" ");
			
			for(int[] i:card) {
				for(int j:i) {
					if(j>1) check=false;
				}
			}
			
			if(!check) {
				sb.append("ERROR");
			}else {
				for(int i:counting) {
					if(i>13) check=false;
					sb.append(13-i+" ");
				}
				
			}
			
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}

