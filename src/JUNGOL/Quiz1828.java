package JUNGOL;

import java.io.*;
import java.util.*;

public class Quiz1828 {

	public static void main(String[] args) throws Exception{
		// 냉장고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		//냉장고 개수
		int cnt=1;
		//냉장고 최저점 최고점 보관온도 저장배열
		int[][] chemicals = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			chemicals[i][0] = Integer.parseInt(st.nextToken());
			chemicals[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//for(int[] a : chemicals)System.out.println(Arrays.toString(a));
		
		//최고 온도를 오름차 순으로 정렬
		Arrays.sort(chemicals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
			
		});
		//for(int[] a : chemicals)System.out.println(Arrays.toString(a));
		
		int max_Degree = chemicals[0][1];
		
		for(int i=0;i<N;i++) {
			if(chemicals[i][0]<=max_Degree) {
				if(chemicals[i][1]<max_Degree) {
					max_Degree = chemicals[i][1];
				}
				continue;
			}
			else {
				max_Degree = chemicals[i][1];
				cnt++;
			}
		}
		
		sb.append(cnt);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}
	
		
}

