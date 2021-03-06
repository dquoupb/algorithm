package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
5
0
5
4 D
8 D
12 D
15 D
20 L
답 : 20

8
3
5 4
5 8
2 5
6
7 D
11 D
15 D
18 D
19 D
20 D
답 : 21

8
5
6 1
7 3
3 5
5 7
5 6
12
2 D
8 D
10 D
12 D
18 L
20 L
22 L
24 L
25 L
28 L
32 D
33 L
답 : 27

20
13
6 15
7 18
20 14
14 13
11 9
7 10
3 18
10 10
13 13
13 5
6 9
10 4
4 3
19
17 D
36 D
41 D
54 D
56 L
57 L
63 L
68 L
72 L
73 L
76 D
79 D
82 D
85 D
87 D
93 L
105 D
110 D
114 D
답 : 90

35
28
21 2
22 23
3 5
34 30
29 31
3 28
20 12
27 26
31 7
5 10
21 10
19 2
15 23
4 23
3 19
3 35
13 30
30 30
23 27
32 17
22 24
8 27
4 8
30 18
15 28
22 29
28 5
16 33
20
27 D
61 L
68 L
100 L
133 L
160 L
165 D
168 D
170 D
182 D
206 D
207 D
214 D
215 D
216 L
237 D
240 D
241 L
251 D
252 D
답 : 237

58
58
31 50
13 34
54 27
21 40
17 36
28 48
38 27
13 51
53 44
28 57
10 25
26 20
29 31
2 6
53 24
19 45
31 58
30 36
2 33
52 31
22 30
15 56
44 36
26 12
47 18
10 57
4 5
28 52
6 30
48 15
5 38
25 38
29 48
50 40
36 5
35 15
45 9
56 42
18 15
51 9
33 29
26 47
46 28
43 29
16 41
16 30
38 35
49 14
20 7
39 50
21 36
40 25
9 5
6 4
49 23
15 32
41 4
42 2
78
5 D
8 D
10 L
15 L
17 L
18 L
20 L
32 L
64 D
65 L
76 D
81 L
82 D
86 L
87 D
88 L
91 L
94 D
100 D
103 D
107 D
109 L
110 D
111 D
115 D
116 L
117 D
118 D
119 L
120 L
121 D
143 D
192 D
229 D
276 L
287 L
313 L
365 D
366 D
403 L
404 L
439 D
440 D
463 L
464 L
469 D
470 L
482 D
493 D
494 D
498 L
510 L
513 D
514 L
519 L
520 D
529 L
545 L
552 D
558 D
564 D
565 D
568 L
570 L
574 D
576 D
581 D
588 D
597 D
619 D
672 D
678 D
693 D
742 L
743 L
747 D
748 L
751 L
답 : 586

100
100
42 68
35 1
70 25
79 59
63 65
6 46
82 28
62 92
96 43
28 37
92 5
3 54
93 83
22 17
19 96
48 27
72 39
70 13
68 100
36 95
4 12
23 34
74 65
42 12
54 69
48 45
63 58
38 60
24 42
30 79
17 36
91 43
89 7
41 43
65 49
47 6
91 30
71 51
7 2
94 49
30 24
85 55
57 41
67 77
32 9
45 40
27 24
38 39
19 83
30 42
34 16
40 59
5 31
78 7
74 87
22 46
25 73
71 30
78 74
98 13
87 91
62 37
56 68
56 75
32 53
51 51
42 25
67 31
8 92
8 38
58 88
54 84
46 10
10 59
22 89
23 47
7 31
14 69
1 92
63 56
11 60
25 38
49 84
96 42
3 51
92 37
75 21
97 22
49 100
69 85
82 35
54 100
19 39
1 89
28 68
29 94
49 84
8 22
11 18
14 15
100
99 D
198 D
297 D
396 D
495 D
594 D
693 D
792 D
891 D
990 D
1089 D
1188 D
1287 D
1386 D
1485 D
1584 D
1683 D
1782 D
1881 D
1980 D
2079 D
2178 D
2277 D
2376 D
2475 D
2574 D
2673 D
2772 D
2871 D
2970 D
3069 D
3168 D
3267 D
3366 D
3465 D
3564 D
3663 D
3762 D
3861 D
3960 D
4059 D
4158 D
4257 D
4356 D
4455 D
4554 D
4653 D
4752 D
4851 D
4950 D
5049 D
5148 D
5247 D
5346 D
5445 D
5544 D
5545 D
5644 L
5645 L
5744 D
5745 D
5844 L
5845 L
5944 D
5945 D
6044 L
6045 L
6144 D
6145 D
6244 L
6245 L
6344 D
6345 D
6444 L
6445 L
6544 D
6545 D
6644 L
6645 L
6744 D
6745 D
6844 L
6845 L
6944 D
6945 D
7044 L
7045 L
7094 D
7095 L
7099 L
7101 D
7106 L
7114 D
7115 D
7117 D
7124 L
7130 L
7138 L
7142 L
7150 D
답 : 7118
 * @author cmk53
 *
 */
public class Main_3190_G5_뱀 {
	static int n, k, l, curTime, curDir = 3, leng, changeTime, result;
	static int[][] arr;
	static int[] head = new int[2];
	static int[] tail = new int[2];
	// i초 direction[i]방향으로 회전한다.
	static char[] direction;

	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		k = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x-1][y-1] = 1;
		}

		l = Integer.parseInt(bf.readLine());
		direction = new char[10001];
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int temp = Integer.parseInt(st.nextToken());
			direction[temp] = st.nextToken().charAt(0);
		}

		// 아무것도 없으면 0, 사과는 1, 뱀은 2
		arr[0][0] = 2;

		System.out.println(dummy(0, 0, 1)+1);
	}

	// 뱀 부분을 큐에 넣어주면서 진행, 사과 먹었으면 offer만, 사과 안 먹고 전진하면 poll, offer
	// 매개변수 : 뱀 위치, 방향
	public static int dummy(int x, int y, int d) {
		Deque<int[]> q = new ArrayDeque<>();
		// 머리위치, 꼬리위치, 방향, 경과 시간
		q.add(new int[] { x, y, d, 0 });
		while (!q.isEmpty()) {
			// 머리부분 빼야함
			int time = q.peekLast()[3];
			int dir = q.peekLast()[2];
			if (direction[time] == 'D') { // 오른쪽으로 회전
				dir++;
			} else if (direction[time] == 'L') { // 왼쪽으로 회전
				dir += 3;
			}
			
			int dirR = q.peekLast()[0] + dr[dir % 4];
			int dirC = q.peekLast()[1] + dc[dir % 4];
			if (dirR > -1 && dirR < n && dirC > -1 && dirC < n) {
				if (arr[dirR][dirC] == 1) { // 사과있으면 한 칸 전진, 뱀 길이 늘리기
					arr[dirR][dirC] = 2;
					q.add(new int[] { dirR, dirC, dir, time + 1 });
				} else if (arr[dirR][dirC] == 2) { // 뱀있으면 게임 끝
					break;
				} else if (arr[dirR][dirC] == 0) { // 아무것도 없으면 한 칸 전진, 뱀 길이는 그대로
					arr[dirR][dirC] = 2;
					q.add(new int[] { dirR, dirC, dir, time + 1 });
					// 꼬리부분 빼는 것이니까 가장 예전에 집어넣었던 정보 빼야지(peek과 peekFirst는 동일)
					arr[q.peek()[0]][q.peek()[1]] = 0;
					q.poll();
				}
			} else { // 범위 벗어나면 게임 끝
				break;
			}
		}

		// 가장 최근 것의 시간
		return q.peekLast()[3];
	}

}
