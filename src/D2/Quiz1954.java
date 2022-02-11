package D2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz1954 {

	public static void main(String[] args) throws FileNotFoundException {
		// 1954. 달팽이 숫자 D2 이따가 1244
		System.setIn(new FileInputStream("src/com/ssafy/hw01/input1954.txt"));
		Scanner s = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		int T = s.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int N = s.nextInt();
			
			int[][] map = new int[N][N];
			
			int dir = 0; //방향 값(초기- 오른쪽)
			//시작 좌표 0,0
			int r = 0;
			int c = 0;
			
			for(int num=1;num<=N*N;num++) {
				
				//숫자 채우기
				map[r][c] = num;
				
				//다음 위치 좌표 (방향전환 여부를 체크하기 위한 변수) ** 다음위치 좌표얻기!
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				
				//다음위치좌표확인
				//다음 위치가 경계를 벗어나거나
				//다음 위치의 요소가 0이 아닌경우
				if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]!=0) {
					//방향 전환
					dir = ++dir%4;
				}
				
				//실제 해당 방향으로 이동
				r = r+ dr[dir];
				c+=dc[dir];
				
			}
			
			//출력
			sb.append("#"+tc+"\n");
			for(int[] arr: map) {
				for(int e : arr) {
					sb.append(e+" ");
				}
				sb.append("\n");
			}
			
			System.out.print(sb.toString());
		}
	}

}
