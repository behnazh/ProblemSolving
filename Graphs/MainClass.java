public class MainClass{
	public static void main(String[] args){
		ThreeTeleports_test();
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
}
