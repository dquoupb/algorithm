package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1522_G5_문자열교환 {
	static String s;
	static int size, count;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine();
		size = s.length();
		for(int i=0; i<size; i++)
			if(s.charAt(i) == 'b')
				count++;
		int answer=Integer.MAX_VALUE;
		for(int i=0; i<size; i++)
			answer = Math.min(answer, solve(i));
		
		System.out.println(answer);
	}

	static int solve(int idx) {
		int result = 0;
		for (int i = idx; i < idx + count; i++)
			if(s.charAt((i+1)%size) == 'a')
				result++;
		return result;
	}
}
