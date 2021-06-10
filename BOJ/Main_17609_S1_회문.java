package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
1
baaba
→ 1
 *
 */
public class Main_17609_S1_회문 {
	static int n;
	static String[] palindrome;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		palindrome = new String[n];
		for(int i=0; i<n; i++) {
			palindrome[i] = bf.readLine();
			if(isPalindrome(palindrome[i]))
				System.out.println(0);
			else if(makePalindrome(0, palindrome[i].length()-1, palindrome[i]))
				System.out.println(1);
			else
				System.out.println(2);
		}
		
	}

	// 펠린드롬 확인하기
	static public boolean isPalindrome(String str) {
		int size = str.length();
		for(int i=0; i<size/2; i++) {
			if(str.charAt(i)== str.charAt(size-1-i)) continue;
			else return false;
		}
		return true;
	}
	
	// 유사 펠린드롬인지 확인하기
	static public boolean makePalindrome(int start, int end, String str) {
		while(start<end) {
			if(str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				int tempStart = start, tempEnd = end;
				tempStart++;
				if(isPalindrome(str.substring(tempStart,end+1)))
					return true;
				
				tempEnd--;
				if(isPalindrome(str.substring(start,tempEnd+1)))
					return true;
				return false;
			}
		}
		return false;
	}
}
