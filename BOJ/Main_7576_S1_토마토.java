package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_S1_토마토 {
	static Queue<int[]> q = new LinkedList<>();
	static int n, m, dayMax;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.offer(new int[] {i,j,0});
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(dayMax);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int day = q.peek()[2];
			dayMax = Math.max(day, dayMax);
			q.poll();
			for (int i = 0; i < 4; i++) {
				int dirR = x + dr[i];
				int dirC = y + dc[i];
				if (dirR > -1 && dirR < m && dirC > -1 && dirC < n && arr[dirR][dirC] == 0) {
					q.offer(new int[] {dirR, dirC, day+1});
					arr[dirR][dirC] = 1;
				}
			}
		}
	}
}
