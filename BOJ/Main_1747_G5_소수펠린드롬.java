package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1747_G5_소수펠린드롬 {
	static int n;
	static int[] arr = new int[1004001];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		primeNumber();
		
		while(true) {
			n++;
			if(arr[n]!=0&&pelindrome(n)) {
				System.out.println(n);
				break;
			}
		}
	}

	// 소수 판별
	static public void primeNumber() {
		for(int i=1; i<=1004000; i++) {
			arr[i] = i;
		}
		
		int num = (int)Math.sqrt(1004000);
		
		for(int i=2; i<=num; i++) {
			if(arr[i] != 0)
				for(int j=i; i*j<=1004000; j++)
					arr[i*j] = 0;
		}
	}
	
	// 펠린드롬 여부 확인하기
	static public boolean pelindrome(int num) {
		String number="";
		while(num>0) {
			number+=num%10;
			num/=10;
		}
		
		for(int i=0, size=number.length(); i<size/2; i++) {
			if(number.charAt(i) == number.charAt(size-1-i)) continue;
			return false;
		}
		return true;
	}
}
