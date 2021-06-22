package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 5
1 2 10
1 3 11
2 3 20
2 4 30
3 4 100
2 3
답: 61

2 0
1 2
답 : -1

3 3
1 3 20
1 2 15
2 3 6
1 3
답: 20

4 5
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
2 3
답: 8

7 7
1 2 3
3 2 5
1 3 1
6 5 3
7 5 8
5 4 2
6 4 3
2 6
답: -1
 */
public class Main_1504_G4_특정한최단경로 {
	static int n, e, mustA, mustB;
	static int[][] arr;
	static boolean[] visit;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = z;
		}
		st = new StringTokenizer(bf.readLine());
		mustA = Integer.parseInt(st.nextToken());
		mustB = Integer.parseInt(st.nextToken());

		// 1→mustA→mustB→n
		int a = dijkstra(1, mustA);
		int b = dijkstra(mustA, mustB);
		int c = dijkstra(mustB, n);
		int resultA;
		if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE)
			resultA = -1;
		else
			resultA = a + b + c;

		// 1→mustB→mustA→n
		a = dijkstra(1, mustB);
		b = dijkstra(mustB, mustA);
		c = dijkstra(mustA, n);
		int resultB;
		if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE)
			resultB = -1;
		else
			resultB = a + b + c;

		if (resultA != -1 && resultB != -1)
			System.out.println(Math.min(resultA, resultB));
		else if (resultA != -1 && resultB == -1)
			System.out.println(resultA);
		else if (resultB != -1 && resultA == -1)
			System.out.println(resultB);
		else if (resultA == -1 && resultB == -1)
			System.out.println(-1);
	}

	static int dijkstra(int start, int end) {
		visit = new boolean[n + 1];
		distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		for (int i = 1; i < n + 1; i++) {
			int current = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < n + 1; j++) {
				if (!visit[j] && min > distance[j]) {
					current = j;
					min = distance[j];
				}
			}

			visit[current] = true;
			if (current == end)
				return distance[end];

			for (int j = 1; j < n + 1; j++) {
				if (!visit[j] && arr[current][j] != 0 && distance[j] > min + arr[current][j])
					distance[j] = min + arr[current][j];
			}
		}
		return distance[end];
	}
}
