package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
1
3 1
7 7 7
4 5 6
3 2 1
→ 7
 *
 */
public class Solution_1949_등산로조성 {
	static int n, k, wayMax, max;
	static int[][] map, copyMap;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			
			wayMax = 0;
			int max = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(map[i][j], max);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == max) {
						// 원본 맵이 있어야 한다.
						copyMap = new int[n][n];
						copy(copyMap);
						// 초기화처리
						visit = new boolean[n][n];
						visit[i][j] = true;
						dfs(i, j, false, 1, copyMap);
					}
				}
			}

			System.out.printf("#%d %d\n", test_case, wayMax);
		}
	}

	// flag : 깎았는지 안 깎았는지 확인하기 위한 변수 true 한번 깎음, false 아직 안깎음
	static void dfs(int x, int y, boolean flag, int cnt, int[][] arr) {
		wayMax = Math.max(wayMax,  cnt);
		
		for (int i = 0; i < 4; i++) {
			int dirR = x + dr[i];
			int dirC = y + dc[i];
			// 범위체크, 방문 여부 체크
			if (dirR > -1 && dirR < n && dirC > -1 && dirC < n && !visit[dirR][dirC]) {
				// 일단 앞으로 전진할 곳이 더 높을 때
				if (arr[dirR][dirC] >= arr[x][y]) {
					// 이미 공사했으면 공사 못함
					if(flag) continue;
					// 깎을 수 있는 높이인데 공사할 수 있으면
					if(arr[dirR][dirC]-k<arr[x][y]) {
						// 어쨌든 제일 높게 깎는 것이 유리하므로
						arr[dirR][dirC] = arr[x][y] - 1;
						flag = true;
						visit[dirR][dirC] = true;
						dfs(dirR, dirC, flag, cnt + 1, arr);
						// 원위치로 돌려두기
						arr[dirR][dirC] = map[dirR][dirC];
						flag = false;
						visit[dirR][dirC] = false;
					} else // 깎을 수 없는 높이
						continue;
				} else { // 앞으로 갈 곳이 낮으면 그냥 방문
					visit[dirR][dirC] = true;
					dfs(dirR, dirC, flag, cnt + 1, arr);
					visit[dirR][dirC] = false;
				}
			}
			
			// 범위밖이거나 이미 방문했으면 패쓰-
		}
	}

	static void copy(int[][] copyMap) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}
