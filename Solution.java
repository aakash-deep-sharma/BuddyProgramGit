package easy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 0; i < test; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			Long count = Arrays.stream(new int[n]).map(j ->  sc.nextInt()).filter(g -> g <= 0).count();
			String res = (count < k) ? "YES":"NO";
			System.out.println(res);
		}	
	}
	
}
