public class MainClass{
	public static void main(String[] args){
		DS1_test();
		//MaxHeapTest_test();
	}

	public static void DS1_test(){
		DataStructures1 ds1 = new DataStructures1();
		ds1.insert(3);
		ds1.insert(4);
		
		ds1.insert(2);
		ds1.insert(5);
		ds1.insert(10);
		ds1.insert(8);
		ds1.insert(9);
		ds1.insert(6);
		ds1.insert(7);
		ds1.insert(36);
		ds1.insert(37);
		ds1.insert(11);
		ds1.insert(30);
		ds1.insert(1);


		System.out.println("median:" + ds1.median());
		ds1.print();
	}

/*	public static void MaxHeapTest_test(){
		MaxHeapTest test = new MaxHeapTest((int)Math.pow(2,31) - 1);
		test.push(1);
		test.push(8);		
		test.push(9);
		test.push(2);
		test.push(3);
		test.push(5);
		test.print();
		test.heapify();
		System.out.println("after heapify");
		test.print();

		test.pop();
		

		System.out.println("after remove");
		test.print();
	}
*/
}
