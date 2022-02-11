package algo;

import java.io.*;
import java.util.*;

public class BOJ_1475_¹æ¹øÈ£ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] numSet = new int[10];
		for(char c : N.toCharArray()) {
			int num = c - '0';
			if(num==9) { 
				num = 6;
			}
			numSet[num]++;
		}
        
		numSet[6] = numSet[6]/2 + numSet[6]%2;
		
		Arrays.sort(numSet); 
		System.out.println(numSet[9]);
	}
}
