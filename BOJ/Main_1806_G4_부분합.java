package baekjoon;

/**
10 21
11 2 5 6 8 9 2 3 10 9 10
→ 3

10 10
1 1 1 1 1 1 1 1 1 10
1

10 10
3 3 3 3 3 3 3 3 3 3
답: 4

4 5
1 2 2 3
답: 2

10 9
1 1 1 1 1 1 1 1 1 8
답: 2

10 100
32 23 42 2 94 3 1 45 37 4
답: 3

10 271 
17 50 83 12 28 34 59 74 90 5
답: 5

100 1200 
60 71 85 40 95 70 56 88 29 59 6 4 4 48 31 80 31 51 14 100 45 42 77 39 47 77 19 80 31 9 91 54 55 27 82 34 55 3 42 64 18 96 75 46 88 32 81 9 61 24 51 6 96 28 49 84 13 78 35 63 20 62 99 82 96 69 86 64 68 93 46 78 14 4 34 9 52 86 84 94 48 59 77 4 26 27 80 55 48 99 55 83 15 56 61 29 25 14 7 30
답: 19

 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 투포인터 이용
public class Main_1806_G4_부분합 {
	static int n, total;
	static int[] arr, arrSum;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		total = Integer.parseInt(st.nextToken());
		arr = new int[n];
		arrSum = new int[n];
		
		// 시작점을 가리키는 인덱스, 끝점을 가리키는 인덱스 두개가 있음
		// 합이 total을 넘는 순간 시작점인덱스를 움직여가면서 길이 최소값을 찾음
		int temp = 0, startIdx = 0, min = Integer.MAX_VALUE;
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			temp += arr[i];
			arrSum[i] = temp;
			if(temp >= total) {
				while(startIdx <= i && arrSum[i]-arrSum[startIdx] >= total) {
					startIdx++;
				}
				min = Math.min(min, i-startIdx+1);
			}
		}
		
		if(min == Integer.MAX_VALUE)
			min = 0;
		System.out.println(min);
	}
}
