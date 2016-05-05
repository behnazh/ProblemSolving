public class MainClass{
	public static void main(String[] args){
		GUMIAndSongsDiv2_test();
	}

	public static void GUMIAndSongsDiv2_test(){
		GUMIAndSongsDiv2 test = new GUMIAndSongsDiv2();

		System.out.println("exp0:");
		int[] duration = {3, 5, 4, 11};
		int[] tone = {2, 1, 3, 1};
		int T= 17;
		print_array(duration);
		print_array(tone);	
		System.out.println(test.maxSongs(duration, tone, T));

		System.out.println("exp1:");
		int[] duration1 = {100, 200, 300};
		int[] tone1 = {1, 2, 3};
		T= 10;
		print_array(duration1);
		print_array(tone1);	
		System.out.println(test.maxSongs(duration1, tone1, T));

		System.out.println("exp2:");
		int[] duration2 = {1, 2, 3, 4};
		int[] tone2 = {1, 1, 1, 1};
		T= 100;
		print_array(duration2);
		print_array(tone2);	
		System.out.println(test.maxSongs(duration2, tone2, T));

		System.out.println("exp3:");
		int[] duration3 = {10, 10, 10};
		int[] tone3 = {58, 58, 58};
		T= 30;
		print_array(duration3);
		print_array(tone3);	
		System.out.println(test.maxSongs(duration3, tone3, T));

		System.out.println("exp4:");
		int[] duration4 = {8, 11, 7, 15, 9, 16, 7, 9};
		int[] tone4 = {3, 8, 5, 4, 2, 7, 4, 1};
		T= 14;
		print_array(duration4);
		print_array(tone4);	
		System.out.println(test.maxSongs(duration4, tone4, T));

		System.out.println("exp5:");
		int[] duration5 = {5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614};
		int[] tone5 = {2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853};
		T= 302606;
		print_array(duration5);
		print_array(tone5);	
		System.out.println(test.maxSongs(duration5, tone5, T));

	}

	public static void print_array(int[] arr){
		if(arr.length == 0)
			return;
		for(int i = 0; i < arr.length - 1; i++){
			System.out.print(arr[i] + ",");
		}
		System.out.println(arr[arr.length - 1]);
	}
}
