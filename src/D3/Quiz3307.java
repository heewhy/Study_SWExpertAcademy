package D3;

import java.io.*;
import java.util.*;

public class Quiz3307 {
	
	static int N;
	static int[] arr;
	static int[] LIS;

	public static void main(String[] args) throws Exception{
		// 최장증가부분수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//int max = LIS(0);
			int size = LIS_BS(0);
			System.out.println(Arrays.toString(LIS));
			
			//System.out.println("#"+tc+" "+max);
			System.out.println("#"+tc+" "+size);
		}
		
		br.close();

	}

	private static int LIS_BS(int size) {
		
//		int start=0;
//		LIS[0] = -1;
//
//		for(int cnt=0;cnt<N;cnt++) {
//			int min = Integer.MAX_VALUE;
//			for(int i=start;i<N;i++) {
//				//배열에서 최소값 찾기
//				if(arr[i]<min) {
//					min = arr[i];
//					//여기가 문제인가?
//					start = i;
//					LIS[size] = min;
//					System.out.println(start);
//				}
//			}
//			arr[start] = Integer.MAX_VALUE;
//			size++;
//		}
		for (int i=0; i < N; i++) {

            int temp = Arrays.binarySearch(LIS, 0, size, arr[i]); // 리턴값 : -insertPoint -1
            temp = Math.abs(temp)-1;//삽입위치
            LIS[temp] = arr[i];// temp 자리에 값을 update 하면 그 의미는 
            			     // 0인덱스 위치부터 temp위치까지의 원소 갯수가  temp위치에 저장된 그 값을 마지막으로 하는 LIS 길이가 됨
            				 // 배열의 원소가 LIS를 이루는 구성요소와는 관계가 없다.

            if (size == temp) {// 삽입위치의 인덱스와 크기가 같으면(결국,마지막이 삽입위치라는 얘기임) 크기 1늘림.
                size++;
            }
        }

		return size;
	}

	private static int LIS(int max) {
		for(int i=0;i<N;i++) {
			LIS[i] = 1;
			
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]&&LIS[i]<LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			}
			max = Math.max(max, LIS[i]);
		}
		return max;
	}

}
