package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5582_G5_공통부분문자열 {
	static String str1, str2;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str1 = bf.readLine();
		str2 = bf.readLine();
		
		int[][] arr = new int[str2.length()][str1.length()];
		int max = 0;
		for(int i=0; i<str2.length(); i++) {
			for(int j=0; j<str1.length(); j++) {
				if(str2.charAt(i) == str1.charAt(j)) {
					if(i==0 || j==0)
						arr[i][j] = 1;
					else
						arr[i][j] = arr[i-1][j-1]+1;
					max = Math.max(max, arr[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
