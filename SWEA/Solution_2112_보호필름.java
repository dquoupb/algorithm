package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
// 시간 초과ㅠㅜ
public class Solution_2112_보호필름 {
	static int d, w, k, min=999999;
	static int[][] arr;
	static boolean[] selectRow;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[d][w];
			// 약물을 투여할 행 선택하는 배열(selectRowFunc에서 사용함)
			selectRow = new boolean[d];
			// 초기화
			min=999999;
			
			// 입력
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// k가 1이면 볼 것도 없이 0, 통과기준에 미치면 dfs함수 돌릴 필요없이 0
			if (k==1||pass(arr)) {
				System.out.printf("#%d %d\n", test_case, 0);
			} else { // 통과기준에 못 미쳤을 경우 부분집합 뽑은 후 약물처리
				selectRowFunc(0);
				System.out.printf("#%d %d\n", test_case, min);
			}

		}
	}
	
	// 부분집합, 어떤 행에 약물을 투여할 지 선택하는 함수
	static void selectRowFunc(int idx) {
		if (idx == d) {
			if(min == 1) return;
			ArrayList<Integer> choose = new ArrayList<>();
			// 약물을 투여할 행만 가지고 감
			for(int i=0; i<d; i++) {
				if(selectRow[i])
					choose.add(i);
			}
			
			// 제대로 뽑혔나 확인
			/*for(int i=0; i<choose.size(); i++)
				System.out.print(choose.get(i));
			System.out.println();*/
			
			// 선택한 것을 A칠할 것인지 B칠할 것인지 골라야함
			// choose배열에는 선택한 행의 인덱스가 저장되어있음
			for(int i=0; i <= choose.size()/2; i++) {
				boolean[] selectA = new boolean[choose.size()]; 
				medi(0, 0, selectA, choose, i);
			}
			
			return;
		}
		selectRow[idx] = true;
		selectRowFunc(idx + 1);
		
		selectRow[idx] = false;
		selectRowFunc(idx + 1);
	}
	
	// 부분집합으로 뽑은 후 해당 행을 어떤 약물 투여할지는 중복 조합
	static void medi(int idx, int start, boolean[] selectA, ArrayList<Integer> choose, int n) {
		if(idx == n) {
			if(min == 1) return;
			
			// 복사한 배열에 약물을 칠해주고 확인해야함
			int[][] copyArr = new int[d][w];
			copy(copyArr);
			for(int i=0; i<choose.size(); i++) {
				if(selectA[i]) {
					for(int j=0; j<w; j++)
						copyArr[choose.get(i)][j] = 0;
				} else {
					for(int j=0; j<w; j++)
						copyArr[choose.get(i)][j] = 1;
				}
			}
			if(pass(copyArr)) min = Math.min(min, choose.size());
			
			for(int i=0; i<choose.size(); i++) {
				if(selectA[i]) {
					for(int j=0; j<w; j++)
						copyArr[choose.get(i)][j] = 1;
				} else {
					for(int j=0; j<w; j++)
						copyArr[choose.get(i)][j] = 0;
				}
			}
			if(pass(copyArr)) min = Math.min(min, choose.size());
			return;
		}
		for(int i=start; i<choose.size(); i++) {
			if(selectA[i]) continue;
			selectA[i] = true;
			medi(idx+1, i+1, selectA, choose, n);
			selectA[i] = false;
		}
	}

	// 통과기준에 미치는지 아닌지 확인
	// true이면 통과, flase이면 통과X
	static boolean pass(int[][] passArr) {
		int count=0;
		for (int i = 0; i < w; i++) {
			count = 1;
			for (int j = 1; j < d; j++) {
				if (passArr[j - 1][i] == passArr[j][i])
					count++;
				else
					count = 1;
				// 만족하는 것 찾으면 다음 열로 넘어가야함
				if (count == k)
					break;
				if(j == d - 1)
					return false;
			}
		}
		return true;
	}
	
	// 원래 배열 저장해두기 위한 배열 복사 함수
	static void copy(int[][] copyArr) {
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < w; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
	}
}
