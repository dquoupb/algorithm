package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
6 2 3
0 1
0 1
0 0
1 1
0 0
1 1
→ 1

2 2 1
0 0
1 1
→ 0
 *
 */
public class Solution_2112_보호필름2 {

	static int[] A;
	static int[] B;

	static int D, W, K;
	static int[][] films;

	static boolean isValid() {
		loop: for (int j = 0; j < W; ++j) {
			int cnt = 0;
			int cell = films[0][j];

			for (int i = 0; i < D; ++i) {
				if (cell == films[i][j]) {
					cnt++;
				} else {
					cell = films[i][j];
					cnt = 1;
				}

				if (cnt == K)
					continue loop;
			}

			return false;
		}

		return true;
	}

	static boolean comb(int N, int cnt, int cur) {
		if (cnt == N)
			return isValid();

		if (D == cur)
			return false;

		int[] tmp = films[cur];

		films[cur] = Arrays.copyOf(A, W);
		if (comb(N, cnt + 1, cur + 1))
			return true;

		films[cur] = Arrays.copyOf(B, W);
		if (comb(N, cnt + 1, cur + 1))
			return true;

		films[cur] = tmp;
		if (comb(N, cnt, cur + 1))
			return true;

		return false;
	}

	static int solve() {
		int answer = 0;

		for (; answer < D; ++answer) {
			if (comb(answer, 0, 0))
				break;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int T = Integer.parseInt(reader.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			token = new StringTokenizer(reader.readLine());

			D = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());

			films = new int[D][W];

			for (int i = 0; i < D; ++i) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < W; ++j)
					films[i][j] = Integer.parseInt(token.nextToken());
			}

			A = new int[W];
			B = new int[W];
			
			Arrays.fill(A, 1);
			Arrays.fill(B, 0);

			System.out.println("#" + tc + " " + solve());
		}
	}
}
