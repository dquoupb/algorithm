package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int n, w, h, totalBlock, max;
	static int[][] original, arr;
	// topBlock : 맨 위에 있는 블럭의 h인덱스 저장 배열, select : 구슬 떨굴 위치 저장할 배열
	static int[] topBlock, select;
	static int[] dr = { 1,-1, 0, 0 };
	static int[] dc = { 0, 0,-1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			max = 0;
			totalBlock = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			original = new int[h][w];
			select = new int[n];
			// 맨 위에 있는 블록 위치 저장하기 위한 배열
			// 구슬 떨굴 때 일일이 안 찾으려고,,
			topBlock = new int[w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					original[i][j] = Integer.parseInt(st.nextToken());
					if (original[i][j] != 0) {
						totalBlock++;
						if (topBlock[j] == 0)
							topBlock[j] = i;
					}
				}
			}

			permutation(0);
			
			System.out.printf("#%d %d\n", test_case, totalBlock - max);
		}
	}

	// arr[a][b]를 쳤을 때 사라지는 블록 갯수 리턴
	static int attack(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { a, b, arr[a][b] });
		int block = 1;
		arr[a][b] = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int size = q.peek()[2];
			q.poll();
			if(size == 1)
				continue;
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < size; j++) {
					int dirR = x + j * dr[i];
					int dirC = y + j * dc[i];
					if (dirR > -1 && dirR < h && dirC > -1 && dirC < w && arr[dirR][dirC] != 0) {
						block++;
						q.offer(new int[] { dirR, dirC, arr[dirR][dirC] });
						arr[dirR][dirC] = 0;
					}
				}
			}
		}
		return block;
	}

	// 블록 부수고 없어진 만큼 블록들이 내려와야 함
	static void makeBlock() {
		// 세로로 확인해야 함
		for (int i = 0; i < w; i++) {
			Stack<Integer> s = new Stack<>();
			// 위에서부터 0이아닌, 남아있는 블록들 stack에 담고
			for (int j = 0; j < h; j++) {
				if (arr[j][i] != 0)
					s.push(arr[j][i]);
				arr[j][i] = 0;
			}
			
			if(s.isEmpty())
				topBlock[i] = -1;
			
			// stack에 담았던거 다시 꺼내서 블럭 아래서부터 쌓아야함
			int tempSize = s.size();
			for (int j = 0; j < tempSize; j++) {
				arr[h - 1 - j][i] = s.pop();
				// 새로운 탑 위치 저장
				if (s.isEmpty())
					topBlock[i] = h - 1 - j;
			}
		}
	}

	// 중복조합
	static void permutation(int idx) {
		if (idx == n) {
			arr = deepCopy(original);
			makeBlock();
			int count = 0;
			for (int i = 0; i < n; i++) {
				if(topBlock[select[i]]==-1)
					continue;
				
				count += attack(topBlock[select[i]], select[i]);
				makeBlock();
			}
			max = Math.max(max, count);
			return;
		}
		for (int i = 0; i < w; i++) {
			select[idx] = i;
			permutation(idx + 1);
		}
	}

	// 2차원 배열 깊은 복사
	private static int[][] deepCopy(int[][] original2) {
		if (original2 == null)
			return null;
		int[][] result = new int[original2.length][original2[0].length];

		for (int i = 0; i < original2.length; i++) {
			System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
		}
		return result;
	}
}