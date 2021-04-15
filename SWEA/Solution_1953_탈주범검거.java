package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int n, m, r, c, l;
	static int[][] map, arr;
	// 파이프별로 저장했다.
	static int[][] dr = { { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, { -1, 0, 0, 0 } };
	static int[][] dc = { { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, -1, 0 }, { 0, 0, -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			arr = new int[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(r, c);
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] != 0)
						count++;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, count);
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> s = new LinkedList<>();
		s.offer(new int[] { x, y, 1 });
		arr[x][y] = 1;
		while (!s.isEmpty()) {
			int a = s.peek()[0];
			int b = s.peek()[1];
			int time = s.peek()[2];
			s.poll();
			if(time == l)
				break;
			
			int pipe = map[a][b] - 1;
			for (int i = 0; i < 4; i++) {
				// 움직이지 않을 경우
				if (dr[pipe][i] == 0 && dc[pipe][i] == 0) continue;
				
				int dirR = a + dr[pipe][i];
				int dirC = b + dc[pipe][i];
				if (dirR > -1 && dirR < n && dirC > -1 && dirC < m && map[dirR][dirC] != 0 && arr[dirR][dirC] == 0) {
					int temp = map[dirR][dirC];
					switch (i) {
					case 0:
						if (temp == 1 || temp == 2 || temp == 5 || temp == 6) {
							s.offer(new int[] { dirR, dirC, time + 1 });
							arr[dirR][dirC] = time + 1;
						}
						break;
					case 1:
						if (temp == 1 || temp == 2 || temp == 4 || temp == 7) {
							s.offer(new int[] { dirR, dirC, time + 1 });
							arr[dirR][dirC] = time + 1;
						}
						break;
					case 2:
						if (temp == 1 || temp == 3 || temp == 4 || temp == 5) {
							s.offer(new int[] { dirR, dirC, time + 1 });
							arr[dirR][dirC] = time + 1;
						}
						break;
					case 3:
						if (temp == 1 || temp == 3 || temp == 6 || temp == 7) {
							s.offer(new int[] { dirR, dirC, time + 1 });
							arr[dirR][dirC] = time + 1;
						}
						break;
					}
				}
			}
		}
	}
}
