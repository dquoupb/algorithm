package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_S3_123더하기 {
	static int n;
	static int[] arr = new int[12];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i=4; i<12; i++) {
			arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
		}
		
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(bf.readLine());
			System.out.println(arr[temp]);
		}
		
	}
}
