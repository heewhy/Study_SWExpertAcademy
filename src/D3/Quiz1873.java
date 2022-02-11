package D3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Quiz1873 {

	public static void main(String[] args) throws FileNotFoundException {
		// 상호의 배틀필드
		System.setIn(new FileInputStream("src/com/ssafy/ws02/input1873.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 입력받기
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			//맵 생성
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			
			int r=0;
			int c=0;
			int dir=0; //0좌 1우 2상 3하
			int idx=0;
			
			//맵 입력
			for(int i=0;i<H;i++) {
				String s = sc.next();
				for(int j=0;j<W;j++) {
					map[i][j] = s.charAt(j);
					//탱크찾기
					if(map[i][j]=='<') {
						r=i;
						c=j;
						dir=0;
						
					}else if(map[i][j]=='>') {
						r=i;
						c=j;
						dir=1;
						
					}else if(map[i][j]=='^') {
						r=i;
						c=j;
						dir=2;
						
					}else if(map[i][j]=='v') {
						r=i;
						c=j;
						dir=3;
						
					}
				}
			}
			
//			for(char[] arr : map) {
//				for(char e : arr) {
//					System.out.println(e+" ");
//				}
//				System.out.println();
//			}
			
			//탱크의 움직임 입력받기
			int N = sc.nextInt();	
			String s = sc.next();
			char[] move = s.toCharArray();
			
			//탱크 움직이기
			//0좌 1우 2상 3하
			for(int i=0;i<N;i++) {
			if(move[i]=='L') {
					dir = 0;
					map[r][c]='<';
					//map 안이고 평지인가?
					if(c>0&&map[r][c-1]=='.') {
						//탱크 옮기고 있던자리 평지
						map[r][c-1]=map[r][c];
						map[r][c]='.';
						c-=1;
					}
				}else if(move[i]=='R') {
					dir = 1;
					map[r][c]='>';
					//map 안이고 평지인가?
					if(c<W-1&&map[r][c+1]=='.') {
						//탱크 옮기고 있던자리 평지
						map[r][c+1]=map[r][c];
						map[r][c]='.';
						c+=1;
					}else if(move[i]=='U') { //위
						dir = 2;
						map[r][c]='^';
						//map 안이고 평지인가?
						if(r>0&&map[r-1][c]=='.') {
							//탱크 옮기고 있던자리 평지
							map[r-1][c]=map[r][c];
							map[r][c]='.';
							r-=1;
						}
						
					}else if(move[i]=='D') {
						dir = 3;
						map[r][c]='v';
						//map 안이고 평지인가?
						if(r<H-1&&map[r+1][c]=='.') {
							//탱크 옮기고 있던자리 평지
							map[r+1][c]=map[r][c];
							map[r][c]='.';
							r+=1;
						}
						
					}
					
				}else if(move[i]=='S') {
					//0좌 1우 2상 3하
					if(dir==0){
						idx = c;
						while(true) {//좌
							if(idx-1<0||map[r][idx-1]=='#') break;
							if(map[r][idx-1]=='*') {
								map[r][idx-1]='.';
								break;
							}
							idx--;
						}
					}else if(dir==1) {//우
						idx = c;
						while(true) {
							if(idx+1>=W||map[r][idx+1]=='#') break;
							if(map[r][idx+1]=='*') {
								map[r][idx+1]='.';
								break;
							}
							idx++;
						}
						
					}else if(dir==2) {//상
						idx = r;
						while(true) {
							if(idx-1<0||map[idx-1][c]=='#') break;
							if(map[idx-1][c]=='*') {
								map[idx-1][c]='.';
								break;
							}
							idx--;
						}
						
					}else if(dir==3) {//하
						idx = r;
						while(true) {
							if(idx+1>=H||map[idx+1][c]=='#') break;
							if(map[idx+1][c]=='*') {
								map[idx+1][c]='.';
								break;
							}
							idx++;
						}
					}
				}
				
				
				
			}
		
			System.out.printf("#%d ",tc);
			for(char[] arr: map) {
				for(char e : arr) {
					System.out.print(e);
				}
				System.out.println();
			}
			
		}
	 
		
	}

}
