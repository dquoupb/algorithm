package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1461_G4_도서관 {
	static int n, m;
	static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr.add(0);
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		Collections.sort(arr);
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<arr.indexOf(0); i+=m) {
			result.add(Math.abs(arr.get(i)));
		}
		
		Collections.reverse(arr);
		for(int i=0; i<arr.indexOf(0); i+=m) {
			result.add(Math.abs(arr.get(i)));
		}
		
		int answer = 0;
		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++) {
			if(i==result.size()-1)
				answer+=result.get(i);
			else
				answer+=result.get(i)*2;
		}
		
		System.out.println(answer);

	}
}
