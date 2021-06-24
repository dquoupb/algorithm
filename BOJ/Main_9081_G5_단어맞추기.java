package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9081_G5_단어맞추기 {
	static int n;
	static char[] word;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		for(int i=0; i<n; i++) {
			String str = bf.readLine();
			word = new char[str.length()];
			for(int j=0, size=str.length(); j<size; j++)
				word[j] = str.charAt(j);
			NPermutation();
			for(int j=0, size=str.length(); j<size; j++)
				System.out.print(word[j]);
			System.out.println();
		}
	}

	static public boolean NPermutation() {
		int i=word.length-1;
		while(i>0&&word[i-1]>=word[i]) --i;
		
		if(i==0) return false;
		
		int j=word.length-1;
		while(word[i-1]>=word[j]) --j;
		swap(i-1,j);
		
		int k = word.length-1;
		while(i<k)
			swap(i++,k--);
		
		return true;
	}
	
	static public void swap(int x, int y) {
		char temp = word[x];
		word[x] = word[y];
		word[y] = temp;
	}
}
