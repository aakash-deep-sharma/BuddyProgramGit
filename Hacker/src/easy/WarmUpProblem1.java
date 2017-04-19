package easy;

import java.util.Arrays;
import java.util.Scanner;

public class WarmUpProblem1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Arrays.stream(new int[n])
        .map(i -> in.nextInt())
        .map(g -> (g < 38 || g%5 < 3) ? g :g+5-g%5)
        .forEach(System.out::println);
		
		/*for(int grades_i=0;grades_i<n;grades_i++)
		{
			grades[grades_i] = in.nextInt();
		}*/
		/*int[] result = solve(grades);*/
		/*for (int i : result) {
			System.out.println("* "+i);
		}*/
	}

	/*private static int[] solve(int[] grades) {
		int[] result = new int[grades.length];
		for(int i=0;i<grades.length;i++)
		{
			result[i] =grades[i] < 38 || grades[i] % 5 < 3?grades[i]:(grades[i]+5-grades[i] % 5);
		}
		return result;
	}*/
	
}
