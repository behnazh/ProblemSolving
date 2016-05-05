public class MainClass{
	public static void main(String[] args){
		Problem1_test();
	}

	public static void Problem1_test(){
		Problem1 p1 = new Problem1();

		System.out.println("exp1:");
		int[] a1 = {1,2,5,9,78};
		for(int i: a1){
			System.out.print(i + ",");		
		}
		System.out.println();
		p1.init(a1);
		System.out.println(p1.search(78));

		System.out.println("exp2:");
		int[] a2 = {0,0,1,1,1};
		for(int i: a2){
			System.out.print(i + ",");		
		}
		System.out.println();
		p1.init(a2);
		System.out.println(p1.search(1));
	}

}
