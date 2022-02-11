package D3;

import java.io.*;
import java.util.*;

public class Quiz3499 {

	public static void main(String[] args) throws Exception{
		// 퍼펙트셔플
		//System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			
			boolean check = true;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int center = (N%2==1)?N/2+1:N/2;
			
			for(int i=1;i<=N;i++) {
				if(i<=center) {
					q1.offer(st.nextToken());
				}else {
					q2.offer(st.nextToken());
				}
			}
			
//			System.out.println(q1.toString());
//			System.out.println(q2.toString());
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= N; i++) {
                if (i % 2 == 1) {
                    sb.append(q1.poll() + " ");
                } else {
                    sb.append(q2.poll() + " ");
                }
            }
		
			
			bw.write("#"+tc+" "+sb+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
