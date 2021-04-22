package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10026_G5_적록색약 {
	static int n;
	static char[][] arr, arr2;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new char[n][n];
		arr2 = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'R')
					arr2[i][j] = 'G';
				else arr2[i][j] = arr[i][j];
			}
		}

		int count = 0;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					count++;
					dfs(i, j, arr);
				}
			}
		}
		System.out.print(count+" ");
		
		count = 0;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					count++;
					dfs(i, j, arr2);
				}
			}
		}
		System.out.print(count+" \n");
	}

	static void dfs(int x, int y, char[][] arr) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int dirR = x + dr[i];
			int dirC = y + dc[i];
			if (check(dirR, dirC) && arr[x][y] == arr[dirR][dirC]) {
				dfs(dirR, dirC, arr);
			}
		}
	}
	
	// 경계체크 함수 & 방문하지 않았을 때까지
	static boolean check(int x, int y) {
		if(x > -1 && x < n && y > -1 && y < n && !visit[x][y])
			return true;
		else return false;
	}
}
