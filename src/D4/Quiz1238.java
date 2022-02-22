package D4;

import java.io.*;
import java.util.*;

public class Quiz1238 {
	
	static int ans;
	static class Node{
		int Vertex;
		Node link;
		
		public Node(int Vertex,Node link) {
			this.Vertex = Vertex;
			this.link = link;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		// [S/W 문제해결 기본] 10일차 - Contact
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken())/2;
			int start = Integer.parseInt(st.nextToken());
			
			Node[] nodes = new Node[101];
			
			st = new StringTokenizer(br.readLine());
			while(N-->0) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				nodes[from] = new Node(to, nodes[from]);
			}
			
			bfs(nodes,start);
			
			sb.append("#"+tc+" "+ans+"\n");
			
		}
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

	private static void bfs(Node[] nodes, int start) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			int max=-1;
			
			for(int s=0;s<size;s++) { //같은
				int current = queue.poll();
				//같은 레벨에서 더 큰거 넣기 (size를 활용해서)
				max = max < current ? current : max;
				//System.out.print(current+" ");
				for(Node temp=nodes[current];temp!=null;temp=temp.link) {
					if(!visited[temp.Vertex]) {
						ans=0;
						queue.offer(temp.Vertex);
						visited[temp.Vertex]=true;
					}
				}
			}
			ans = max;
		}
		
		
	}

}
