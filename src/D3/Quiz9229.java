package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Quiz9229 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 한빈이와 Spot Mart
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] snack = new int[N];
			int max = 0;
			int sum = 0;
		
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				snack[i] = Integer.parseInt(st.nextToken());				
			}
			
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					sum = snack[i]+snack[j];
					if(sum<=M&&max<sum) max= sum;
				}
			}
			
//			Arrays.sort(snack);
//			//System.out.println(Arrays.toString(snack));
//			Stack<Integer> stack = new Stack<>();
//			
//			for(int i=snack.length-1;i>=0;i--) {
//				if(snack[i]<M) {
//					if(!stack.isEmpty()) {
//						if(snack[i]+stack.peek()<=M) {
//							stack.push(snack[i]);
//							break;
//						}
//					}else {
//						if(snack[i]+snack[0]<=M)
//						stack.push(snack[i]);
//					}
//				}
//			}
//			//System.out.println(stack);
//			
//			StringBuilder sb = new StringBuilder();
//			int sum=0;
//			try {
//				sum = stack.pop() + stack.pop();
//			} catch (Exception e) {
//				sum=-1;
//			}
			
			if(max==0) max=-1;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc+" ").append(max);
			System.out.println(sb.toString());
		}

	}

}
