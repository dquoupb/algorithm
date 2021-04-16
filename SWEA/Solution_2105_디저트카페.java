package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	// 배열 크기, 시작x, 시작y(시작 인덱스들), 가장 많이 먹을 수 있는 디저트 종류 수
	static int n, startX, startY, max = -1;
	static int[][] arr;
	// 디저트 종류 저장
	static boolean[] type;
	// 대각선으로 움직임 우하, 좌하, 좌상, 우상
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			type = new boolean[101];
			max = -1;
			// 입력
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = 1; j < n-1; j++) {
					startX = i;
					startY = j;
					dfs(i, j, 0, 1);
				}
			}

			System.out.printf("#%d %d\n", test_case, max);
		}

	}
	
	static void dfs(int x, int y, int dir, int cnt) {
		type[arr[x][y]] = true;
		
		for(int i=0; i<2; i++) { // 두 방향만 체크하면 된다.
			if(dir + i == 4) break;
			
			int dirR = x + dr[dir + i];
			int dirC = y + dc[dir + i];
			
			// 사이클 발생 한 바퀴 다 돌은 것
			if(dirR == startX && dirC == startY) {
				max = Math.max(max, cnt);
				continue;
			}
			
			// 범위 체크, 먹지 않은 디저트여야 함
			if(dirR > -1 && dirR < n && dirC > -1 && dirC < n && !type[arr[dirR][dirC]]) {
				dfs(dirR, dirC, dir + i, cnt + 1);
			}
		}
		// 더 이상 갈 수 있는 곳이 없어서 뒤로 후퇴 = 먹은 거 뱉기
		type[arr[x][y]] = false;
	}

}
