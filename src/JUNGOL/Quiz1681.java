package JUNGOL;

import java.io.*;
import java.util.*;

public class Quiz1681 {
	
	public static class Node implements Comparable<Node>{
		int to,weight,bit; //다음 노드, 가중치, 비트

		public Node(int to, int weight, int bit) {
			super();
			this.to = to;
			this.weight = weight;
			this.bit = bit;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
		
	}
	
	static int N;
	static int map[][];
	static int min=Integer.MAX_VALUE;
	static PriorityQueue<Node> q=new PriorityQueue<Node>();

	public static void main(String[] args) throws Exception{
		// 해밀턴 순환회로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 배달 해야하는 장소의 수 입력 받기
		N = Integer.parseInt(br.readLine());
		// 배당 비용정보 저장 공간
		map = new int[N][N];
		
		// 비용 정보 입력 받기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new Node(0,0,0));
		delivery();
		
		sb.append(min);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void delivery() {
		while(!q.isEmpty()) {
			Node p=q.remove();
			//모든 곳을 다 탐색하고 다시 1로 돌아온 경우
			if(p.bit==((1<<N)-1)) {
				min=Math.min(min,p.weight);
				return;
			}
			//자기의 회사로 돌아오는 것을 제외한 다른 곳으로 향함
			for(int i=1;i<N;i++) {
				if((p.bit&(1<<i))!=0||map[p.to][i]==0)
					continue;
				else
					q.add(new Node(i,p.weight+map[p.to][i],p.bit|(1<<i)));
			}
			//자기 자신의 회사를 제외한 모든 배달 지를 다 돌았을 경우
			if(p.bit==((1<<N)-2)&&map[p.to][0]!=0) {
				q.add(new Node(0,p.weight+map[p.to][0],p.bit|(1<<0)));
			}
		}
	}

}
