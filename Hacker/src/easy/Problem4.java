package easy;

import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		String[] arr = input.split(":");
		
		/*if(arr[2].contains("A"))
		{
			if(arr[0].equals("12"))
				arr[0] = "00";
		}
		else
		{
			if(!arr[0].equals("12"))
				arr[0] =( Integer.parseInt(arr[0])+12)+"";
		}
		
		System.out.println(arr[0]+":"+arr[1]+":"+arr[2].substring(0, 2));*/
		
		
		arr[0] = arr[2].contains("A")?(arr[0].equals("12")?"00":arr[0]):(!arr[0].equals("12")?(Integer.parseInt(arr[0])+12)+"":arr[0]);
		System.out.println(arr[0]+":"+arr[1]+":"+arr[2].substring(0, 2));
	}
}
