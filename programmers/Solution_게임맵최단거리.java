package programmers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {
	static int[][] maps = {{1}};
	//{{1,0,1},{0,0,1},{1,0,1},{1,1,1}};
	//{ { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } }
	// {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}
	static int min = Integer.MAX_VALUE;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution(maps));
	}

	static public int solution(int[][] maps) {
		// 세로길이
		int n = maps.length;
		// 가로길이
		int m = maps[0].length;
		// 방문배열 생성
		visit = new boolean[n][m];
		
		// 0,0부터 시작, 현재있는 칸 카운트 하고 들어가서 1
		return bfs(0, 0, n, m, 1, maps);
	}

	static int bfs(int x, int y, int n, int m, int count, int[][] maps) {
		Queue<int[]> q = new LinkedList<>();
		// 인덱스(x, y)와 count = 몇 번 갔는지
		q.offer(new int[] { x, y, count });
		visit[0][0] = true;
		
		while (!q.isEmpty()) {
			int a = q.peek()[0];
			int b = q.peek()[1];
			int cnt = q.peek()[2];
			// 도착하면
			if (a == n - 1 && b == m - 1)
				return cnt;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int dirR = a+dr[i];
				int dirC = b+dc[i];
				if (check(dirR, dirC, n, m, maps)) {
					q.offer(new int[] { dirR, dirC, cnt + 1 });
					visit[dirR][dirC] = true;
				}
			}
		}
		return -1;
	}

	// 경계체크 함수 & 방문하지 않았을 때까지
	static boolean check(int x, int y, int n, int m, int[][] maps) {
		if (x > -1 && x < n && y > -1 && y < m && !visit[x][y] && maps[x][y] == 1)
			return true;
		else
			return false;
	}
}
