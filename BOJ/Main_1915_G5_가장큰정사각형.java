package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1915_G5_가장큰정사각형 {
	static int n, m;
	static int[][] arr;
	static int[] dr = { -1, -1, 0 };
	static int[] dc = { 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int result = 0;
		arr = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String str = bf.readLine();
			here:
			for (int j = 1; j <= m; j++) {
				int temp = str.charAt(j-1)-'0';
				arr[i][j] = temp;
				if (temp != 0) {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < 3; k++) {
						int dirR = i + dr[k];
						int dirC = j + dc[k];
						
						// 배열 범위 안에 있으면
						if (check(dirR, dirC)) {
							// 0 이면 세 방향 둘러볼 필요도 없음
							if (arr[dirR][dirC] == 0)
								continue here;
							min = Math.min(min, arr[dirR][dirC]);
						}
					}
					arr[i][j] = (int) Math.pow(Math.sqrt(min) + 1, 2);
				}
			}
		}
		for(int i=1; i<=n; i++ ) {
			for(int j=1; j<=m; j++)
				result = Math.max(result,  arr[i][j]);
		}
		System.out.println(result);
	}

	static boolean check(int x, int y) {
		if (x > -1 && x <= n && y > -1 && y <= m)
			return true;
		return false;
	}
}
