package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_S1_토마토 {
	static int m, n, h, day = 0;
	static int[][][] arr;
	static boolean[][][] visit;
	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static Queue<Node> q = new LinkedList<Node>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken()); // 5
		n = Integer.parseInt(st.nextToken()); // 3
		h = Integer.parseInt(st.nextToken()); // 1
		arr = new int[h][n][m];
		visit = new boolean[h][n][m];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		/* 입력 받기 완료 */

		// 1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈칸
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[k][i][j] == 1) {
						q.add(new Node(k,i,j,0));
					}
				}
			}
		}

		bfs();
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 익지 않은 토마토 발견
					if (arr[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(day);
	}

	static public void bfs() {
		while (!q.isEmpty()) {
			Node temp = q.poll();
			day = Math.max(day, temp.day);
			for (int i = 0; i < 6; i++) {
				int dirX = temp.x + dh[i];
				int dirY = temp.y + dr[i];
				int dirZ = temp.z + dc[i];
				if (check(dirX, dirY, dirZ) && arr[dirX][dirY][dirZ] != -1 && !visit[dirX][dirY][dirZ]) {
					if(arr[dirX][dirY][dirZ]==0) {
						q.add(new Node(dirX, dirY, dirZ, temp.day+1));
						arr[dirX][dirY][dirZ] = 1;
					}
					else if(arr[dirX][dirY][dirZ] == 1)
						q.add(new Node(dirX, dirY, dirZ, temp.day));
					
					visit[dirX][dirY][dirZ] = true;
				}
			}
		}

	}

	// 범위 체크
	static boolean check(int x, int y, int z) {
		if (x > -1 && y > -1 && z > -1 && x < h && y < n && z < m)
			return true;
		return false;
	}

	static class Node {
		int x, y, z, day;

		// h, n, m
		public Node(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
}
