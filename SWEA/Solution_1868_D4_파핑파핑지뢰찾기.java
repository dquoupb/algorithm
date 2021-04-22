package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1868_D4_파핑파핑지뢰찾기 {
	static int n, result;
	static char[][] arr;
	static int[][] showAns;
	// 8방탐색
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test = 1; test <= T; test++) {
			n = Integer.parseInt(bf.readLine());
			arr = new char[n][n];
			showAns = new int[n][n];
			visit = new boolean[n][n];
			result = 0;
			StringTokenizer st = null;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				String str = st.nextToken();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			// 미리 답 입력함 showAns배열에
			show();
			
			// 일단 0인 지점 
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(showAns[i][j] == 0 && !visit[i][j]) {
						result++;
						bfs(i,j);
					}
				}
			}
			
/*			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(showAns[i][j] == -1)
						System.out.print(-1);
					else if (!visit[i][j]) {
						System.out.print(0);
					} else
						System.out.print(2);
				}System.out.println();
			}*/
			
			
			// 0인거 다 세고 아직 방문하지 않은 0이 아닌 나머지 숫자들
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j] && showAns[i][j] != -1) {
						result++;
					}
				}
			}
			
			System.out.println("#" + test + " "+result);
		}
	}

	// 미리 답 까놓기
	static void show() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 지뢰는 -1
				if(arr[i][j] == '*')
					showAns[i][j] = -1;
				// 지뢰 아닐때 숫자 입력 되어야한다.
				if (arr[i][j] == '.') {
					int count = 0;
					for (int d = 0; d < 8; d++) {
						int dirR = i + dr[d];
						int dirC = j + dc[d];
						if (dirR > -1 && dirR < n && dirC > -1 && dirC < n) {
							if (arr[dirR][dirC] == '*')
								count++;
						}
					}
					showAns[i][j] = count;
				}
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int a = q.peek()[0];
			int b = q.peek()[1];
			q.poll();
			// 8방 탐색하면서 0인 곳 찾아서 까야함
			for (int i = 0; i < 8; i++) {
				int dirR = a + dr[i];
				int dirC = b + dc[i];
				if (dirR > -1 && dirR < n && dirC > -1 && dirC < n && !visit[dirR][dirC]) {
					// 깐 곳이 0일 때는 주변 8군데 다 들러서 까야함
					visit[dirR][dirC] = true;
					if(showAns[dirR][dirC] == 0)
						q.offer(new int[] { dirR, dirC});
				}
			}

		}
	}
}
