package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = Arrays.stream(new int[n]).map(i -> in.nextInt() ).toArray();
		int count = 0;
		/*for(int i = 0;i<n-2;i++)
		{
			int item = arr[i];
			if(item != 0)
			{
				for(int j = i+1;j<n-1;j++)
				{
					if(arr[i] == arr[j])
					{
						count++;
						arr[j]=0;
						break;
					}
				}
			}
		}*/
		
		/*Set<Integer> set = new HashSet<>();
		Arrays.stream(new int[n])
				.map(i -> in.nextInt() )
				.forEach(g -> {
					if(!set.add(g))
					{
						System.out.println(count);
						set.remove(g);
					}
					
				});*/
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0;i<n;i++)
		{
			if(!set.add(arr[i]))
			{
				count++;
				set.remove(arr[i]);
			}
		}
		
		
		
		
		System.out.println(count);
	}
	
}
