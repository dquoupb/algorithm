package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G4_16916_부분문자열 {
	static String p, s;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine();
		p = bf.readLine();

		// 패턴 문자열로 실패함수 만들기
		int[] fail = new int[p.length()];
		for (int i = 1, j = 0; i < p.length(); i++) {
			// 일치하지 않을 때까지 반복
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = fail[j - 1];
			}
			// 일치한 개수를 실패함수에 저장해야 한다.
			if (p.charAt(i) == p.charAt(j))
				fail[i] = ++j;
		}
		
		for (int i = 0, j = 0; i < s.length(); i++) {
			// 일치하지 않을 때까지 반복
			while (j > 0 && s.charAt(i) != p.charAt(j))
				j = fail[j - 1];
			if (s.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) { // 패턴 문자열의 마지막이면 부분문자열이라는 것을 의미
					System.out.println(1);
					return;
				} else // 다음칸부터 다시 비교
					j++;
			}
		}
		System.out.println(0);
	}

}
