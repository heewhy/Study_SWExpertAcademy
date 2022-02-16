package D;

import java.io.*;
import java.util.*;

public class Quiz5644 {

	public static void main(String[] args) throws Exception{
		// [모의 SW 역량테스트] 무선 충전
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			//총 이동 시간
			int M = Integer.parseInt(st.nextToken());
			//배터리 개수
			int A = Integer.parseInt(st.nextToken());
			
			int[] cmd_A = new int[M+1];
			int[] cmd_B = new int[M+1];
			
			//A 이동정보
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				cmd_A[i] = Integer.parseInt(st.nextToken());
			}
			//B 이동정보
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				cmd_B[i] = Integer.parseInt(st.nextToken());
			}
			
			//System.out.println(Arrays.toString(cmd_A));
			//System.out.println(Arrays.toString(cmd_B));
			
			int[][] BC = new int[A][4];
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][1] = Integer.parseInt(st.nextToken()); //col
				BC[i][0] = Integer.parseInt(st.nextToken()); //row
				BC[i][2] = Integer.parseInt(st.nextToken()); //충전범위
				BC[i][3] = Integer.parseInt(st.nextToken()); //처리량 
				
			}
			//for(int[] a : BC)System.out.println(Arrays.toString(a));
			//처리량 큰 순으로 정렬 (중복되었을 때)
			Arrays.sort(BC, (a,b)->b[3]-a[3]);
			//for(int[] a : BC)System.out.println(Arrays.toString(a));
			
			int sum=0;
			int[] di = {0,-1,0,1,0}; //중앙, 상, 우, 좌, 하
			int[] dj = {0,0,1,0,-1};
			
			//초기 위치
			int move_ar = 1;
			int move_ac = 1;
			int move_br = 10;
			int move_bc = 10;
			
			for(int d=0;d<=M;d++) {
				//움직이기
				move_ar += di[cmd_A[d]];
				move_ac += dj[cmd_A[d]];
				move_br += di[cmd_B[d]];
				move_bc += dj[cmd_B[d]];
				
				//어느 배터리에 속해있는지 저장할 변수 
				//BC의 인덱스가 0이 존재함으로 제외
				//bc_a==bc_b 가 될수있기때문에 다르게 설정
				int bc_a=-1;
				int bc_b=-2;
				
				for(int bc=0;bc<A;bc++) {
					//A가 배터리에 들어가 있는가?
					//System.out.println(Math.abs(move_ar-BC[bc][0])+Math.abs(move_ac-BC[bc][1]));
					if(BC[bc][2]>=(Math.abs(move_ar-BC[bc][0])+Math.abs(move_ac-BC[bc][1]))) {
						//bc배터리에 들어가있음
						bc_a=bc;
//						System.out.println("d :"+d);
//						System.out.println("bc_a"+bc_a);
						break;
					}
				}
				for(int bc=0;bc<A;bc++) {
					//B가 배터리에 들어가 있는가?
					if(BC[bc][2]>=(Math.abs(move_br-BC[bc][0])+Math.abs(move_bc-BC[bc][1]))) {
						//bc배터리에 들어가있음
						bc_b=bc;
						break;
					}
				}
				
				//같은 배터리안에 들어와있다면
				if(bc_a==bc_b) {
					int num = bc_a+1; //더 작은 처리량
					for(;num<A;num++) {
						//배터리의 범위에 a가 들어와있거나 b가 들어와있는가?
						if(BC[num][2]>=Math.abs(move_ar-BC[num][0])+Math.abs(move_ac-BC[num][1])||BC[num][2]>=Math.abs(move_br-BC[num][0])+Math.abs(move_bc-BC[num][1])) {
							//하나만 작은범위로 변경
							bc_a=num;
							break;
						}
					}
					//num은 계속 ++되서 나오거나 
					//두개 다 최저량 배터리 안에 들어와있거나
					if(num==A) {
						//한번만 더하기
						sum+=BC[bc_a][3];
					}else {
						sum+=(BC[bc_a][3]+BC[bc_b][3]);
					}
				}
				//같은 배터리가 아니라면
				else {
					if(bc_a!=-1)sum+=BC[bc_a][3];
					if(bc_b!=-2)sum+=BC[bc_b][3];
				}
				
				
				
				}
			
			sb.append("#"+tc+" "+sum+"\n");
		}//tc end
		
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}//main end

}
