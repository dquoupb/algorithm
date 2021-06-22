package baekjoon;

/*
 * 메모리 초과남!!! 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753_G5_최단경로 {
	static int v, e, start;
	static int[][] arr;
	static int[] distance;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(bf.readLine());

		// 1 → v번까지
		arr = new int[v + 1][v + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (arr[x][y] != 0)
				arr[x][y] = Math.min(arr[x][y], Integer.parseInt(st.nextToken()));
			else
				arr[x][y] = Integer.parseInt(st.nextToken());
		}
		 입력 받기 끝 

		// 다익스트라 함수
		dijkstra(start, v + 1);

		for (int i = 1; i <= v; i++)
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
	}

	// s에서 e로 가는 최소비용 distance배열에 저장함
	static void dijkstra(int s, int e) {
		distance = new int[v + 1];
		visit = new boolean[v + 1];

		// 무한대로 채워놓기
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		for (int i = 1; i <= v; i++) {
			int current = 0; // 최소비용에 해당하는 정점의 변호를 저장할 변수
			int min = Integer.MAX_VALUE;

			// 처리하지 않은 정점들 중에서 가장 가까운 정점 선택하기
			for (int j = 1; j <= v; j++) {
				// 아직 방문하지 않았고 최소인 경우
				if (!visit[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			// 방문했으므로(최소인 경우에 방문해야함!) true로 변경
			visit[current] = true;

			// 마지막 도착점까지 구했으면
			if (current == e)
				break;

			// current를 경유지로 하여 아직 처리되지 않은 다른 정점으로가는 다른 최소비용 따져보기
			for (int j = 1; j <= v; j++) {
				if (!visit[j] && arr[current][j] != 0 && distance[j] > min + arr[current][j])
					distance[j] = min + arr[current][j];
			}
		}
	}
}*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_G5_최단경로 {
	// 해당 노드[i]에서 idx로 갈때의 가중치 w
	static class Node implements Comparable<Node> {
		int idx, w;

		public Node(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}

		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static int v, e, start;
	static ArrayList<Node> list[];
	static int[] distance;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// 정점과 간선의 최대값이 크므로 인접행렬이 아닌 인접리스트로 풀어야 한다!!
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(bf.readLine());

		// 1 → v번까지
		// 초기화하는 법 까먹지 말기
		list = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list[x].add(new Node(y, z));
		}
		/* 입력 받기 끝 */ 

		// 다익스트라 함수
		dijkstra();

		for (int i = 1; i <= v; i++)
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
	}

	static public void dijkstra() {
		distance = new int[v + 1];
		visit = new boolean[v + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			if(visit[temp.idx]) continue;
			visit[temp.idx] = true;
			
			for(Node o : list[temp.idx]) {
				if(distance[o.idx] > distance[temp.idx]+o.w) {
					distance[o.idx] = distance[temp.idx]+o.w;
					pq.add(new Node(o.idx, distance[o.idx]));
				}
			}
		}
	}
}