import java.util.*;

public class MainClass{
	public static void main(String[] args){
		Problem1_test();
	}

	public static void Problem1_test(){
		Problem1 test = new Problem1();
		int[] a = {16, 3, 5, 19, 10, 14, 12, 0, 15};
		List<Integer> result = test.findLongestSubSequence(a);
		Object[] b = result.toArray();	
		print_array(b);	 

		
		int[] a1 = new int[2000];
		Random randomno = new Random();
		for(int i = 0; i< 2000; i++){
			a1[i] = randomno.nextInt(2000);
		}
		result = test.findLongestSubSequence(a1);
		Object[] b1 = result.toArray();	
		print_array(b1);	
	
	}

	public static void print_array(Object[] arr){
		if(arr.length == 0)
			return;
		for(int i = 0; i < arr.length - 1; i++){
			System.out.print(arr[i] + ",");
		}
		System.out.println(arr[arr.length - 1]);
	}
}
