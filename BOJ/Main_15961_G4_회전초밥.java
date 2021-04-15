package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 연속된 k갯수 속에서 종류를 세는것!!!*
 * 
2 2 2 2
1
1
→ 2
 * 
8 30 8 8
1
1
1
1
1
1
1
1
→ 2
 * 
8 30 8 8
1
1
2
2
2
3
3
3
→ 4
 *
 */
public class Main_15961_G4_회전초밥 {
	static int n, d, k, c, max;
	static int[] plate, count;
	// static Queue<Integer> q = new LinkedList<>();
	static int[] shisi;
	static boolean[] total;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// n : 접시 수, d : 초밥 가짓수, k : 연속해서 먹는 접시 수, d : 쿠폰번호
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		plate = new int[n];
		shisi = new int[d + 1];
		for (int i = 0; i < n; i++) {
			plate[i] = Integer.parseInt(bf.readLine());
		}

		int count = 0;
		for (int i = 0; i < k; i++) {
			if (shisi[plate[i]] == 0)
				count++;
			shisi[plate[i]]++;
		}
		max = count;

		for (int i = 1; i < n; i++) {
			if (max <= count) {
				if (shisi[c] == 0)
					max = count + 1;
				else
					max = count;
			}
			shisi[plate[i - 1]]--;
			// 빼고, 안남아있으면 count에서 빼주어야함(중복일 경우는 이 과정을 안 거침)
			if (shisi[plate[i - 1]] == 0) count--;
			
			// 새로운 거 추가
			if (shisi[plate[(i + k - 1) % n]] == 0) count++;
			shisi[plate[(i + k - 1) % n]]++;
		}
		System.out.println(max);
	}
}
