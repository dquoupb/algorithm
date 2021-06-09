package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_S2_차이를최대로 {
	static int n, max=0;
	static int[] arr, select;
	static boolean[] isSelect;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		select = new int[n];
		isSelect = new boolean[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken()); 
		
		permutation(0);
		System.out.println(max);
	}
	
	static private void permutation(int idx) {
		if(idx == n) {
			int result = 0;
			for(int i=0; i<n-1; i++) {
				result += Math.abs(select[i]-select[i+1]);
			}
			max = Math.max(max, result);
			return;
		}
		for(int i=0; i<n; i++) {
			if(isSelect[i]) continue;
			
			isSelect[i] = true;
			select[idx] = arr[i];
			permutation(idx+1);
			isSelect[i] = false;
		}
	}
}
