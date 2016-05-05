public class MainClass{
	public static void main(String[] args){

	}

	public static void ThreeTeleports_test(){
		ThreeTeleports test = new ThreeTeleports();
	
		System.out.println("exp0");
		int xMe = 3;
		int yMe = 3;
		int xHome = 4;
		int yHome = 5;
		String[] tele = {"1000 1001 1000 1002", "1000 1003 1000 1004", "1000 1005 1000 1006"};
		System.out.println(test.shortestDistance(xMe, yMe, xHome, yHome, tele));

		System.out.println("exp1");
		xMe = 0;
		yMe = 0;
		xHome = 20;
		yHome = 20;
		String[] tele1 = {"1 1 18 20", "1000 1003 1000 1004", "1000 1005 1000 1006"};
		System.out.println(test.shortestDistance(xMe, yMe, xHome, yHome, tele1));

		System.out.println("exp2");
		xMe = 0;
		yMe = 0;
		xHome = 20;
		yHome = 20;
		String[] tele2 = {"1000 1003 1000 1004", "18 20 1 1", "1000 1005 1000 1006"};
		System.out.println(test.shortestDistance(xMe, yMe, xHome, yHome, tele2));

		System.out.println("exp3");
		xMe = 10;
		yMe = 10;
		xHome = 10000;
		yHome = 20000;
		String[] tele3 = {"1000 1003 1000 1004", "3 3 10004 20002", "1000 1005 1000 1006"};
		System.out.println(test.shortestDistance(xMe, yMe, xHome, yHome, tele3));

		System.out.println("exp4");
		xMe = 3;
		yMe = 7;
		xHome = 10000;
		yHome = 30000;
		String[] tele4 = {"3 10 5200 4900", "12212 8699 9999 30011", "12200 8701 5203 4845"};
		System.out.println(test.shortestDistance(xMe, yMe, xHome, yHome, tele4));

		System.out.println("exp5");
		xMe = 0;
		yMe = 0;
		xHome = 1000000000;
		yHome = 1000000000;
		String[] tele5 = {"0 1 0 999999999", "1 1000000000 999999999 0", "1000000000 1 1000000000 999999999"};
		System.out.println(test.shortestDistance(xMe, yMe, xHome, yHome, tele5));
	}

	public static void callCentaurCompanyDiv2_test(){
		System.out.println("exp0:");
		int[] a1 = {1};
		int[] b1 = {2};
		callCentaurCompanyDiv2(a1, b1);

		System.out.println("exp1:");
		int[] a2 = {2, 2};
		int[] b2 = {1, 3};
		callCentaurCompanyDiv2(a2, b2);

		System.out.println("exp2:");
		int[] a3 = {1,2,3,4,5,6,7,8,9};
		int[] b3 = {2,3,4,5,6,7,8,9,10};
		callCentaurCompanyDiv2(a3, b3);

		System.out.println("exp3:");
		int[] a4 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int[] b4 = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
		callCentaurCompanyDiv2(a4, b4);

		System.out.println("exp4:");
		int[] a5 = {10, 7, 2, 5, 6, 2, 4, 9, 7};
		int[] b5 = {8, 10, 10, 4, 1, 6, 2, 2, 3};
		callCentaurCompanyDiv2(a5, b5);
		

	}

	public static void callCentaurCompanyDiv2(int[] a, int[] b){
		CentaurCompanyDiv2 cc = new CentaurCompanyDiv2();
  		System.out.println(cc.count(a, b));
	}
}
