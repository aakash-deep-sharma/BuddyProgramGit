package easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int []arr = Arrays.stream(new int[n]).map(i -> in.nextInt()).toArray();
		int charged = in.nextInt();
		int sum = Arrays.stream(arr).sum();
		/*int sum = IntStream.range(0, n).map(g -> in.nextInt()).filter(i -> i != k).sum();*/
		
		//sum = sum - arr[k];
		sum = sum /2;
		System.out.println("sum="+sum);
		if(sum < charged)
			System.out.println(charged-sum);
		else
			System.out.println("Bon Appetit");
	}
}
