package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_G4_문자열폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<Character>();
		String str = bf.readLine();
		String bomb = bf.readLine();
		StringBuilder sb = new StringBuilder()
		for(int i=0; i<str.length(); i++) {
			s.push(str.charAt(i));
			
			if(s.size() >= bomb.length()) {
				boolean flag = true;
				for(int j=0; j<bomb.length(); j++) {
					if(s.get(s.size()-bomb.length()+j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=0; j<bomb.length(); j++)
						s.pop();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (char ch : s) {
			sb.append(ch);
		}

		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
		
	}
	
	/* public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		char[] explosion = br.readLine().toCharArray();
		char[] ans = new char[str.length];
		int idx = 0;

		for (int i = 0; i < str.length; i++) { 
			ans[idx] = str[i];
			if (check(ans, idx, explosion))
				idx -= explosion.length;
			idx++;
		}

		String answer = String.valueOf(ans, 0, idx);               
		System.out.println(answer.length() == 0 ? "FRULA" : answer);
	}

	private static boolean check(char[] ans, int idx, char[] explosion) {
		if (idx < explosion.length - 1)
			return false;
		for (int i = 0; i < explosion.length; i++) {
			if (explosion[i] != ans[idx - explosion.length + i + 1])
				return false;

		}
		return true;
	}*/

}
