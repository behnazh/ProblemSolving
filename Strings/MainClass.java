public class MainClass{
	public static void main(String[] args){
		WolfDelaymaster_test();
	}

	public static void WolfDelaymaster_test(){
		WolfDelaymaster w = new WolfDelaymaster();

		System.out.println("exp0:");
		String a1 = "wolf";
		System.out.println(a1);		
		w.init("wolf");
		System.out.println(w.check(a1));

		System.out.println("exp1:");
		a1 = "wwolfolf";
		System.out.println(a1);		
		w.init("wolf");
		System.out.println(w.check(a1));

		System.out.println("exp2:");
		a1 = "wolfwwoollffwwwooolllfffwwwwoooollllffff";
		System.out.println(a1);		
		w.init("wolf");
		System.out.println(w.check(a1));

		System.out.println("exp3:");
		a1 = "flowolf";
		System.out.println(a1);		
		w.init("wolf");
		System.out.println(w.check(a1));
	}

}
