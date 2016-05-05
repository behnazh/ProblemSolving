/*
 Design a data structure, which allows the regular heap operations of push and pop but can also return the median of all inserted elements with constant time (O(1)).
*/


public class DataStructures1{

	MaxHeap small;
	MinHeap big;

	public DataStructures1(){
		small = new MaxHeap((int)Math.pow(2,31) - 1);
		big = new MinHeap(-1*((int)Math.pow(2,31)));
	}

	public void print(){
		System.out.println("small:");
		small.print();

		System.out.println("big:");
		big.print();
	}
	
	public void insert(int i){
		if(small.isEmpty() && big.isEmpty())
			small.push(i);
		else if(i <= small.peek()){
			if(small.size() - big.size() > 0){
				if(i < small.peek()){
					big.push(small.pop());
					small.push(i);	
				}
				else{
					small.push(i);
				}
			}
			else{
				small.push(i);
			}
		}
		else{
			if(big.size() - small.size() > 0){
				if(i > big.peek()){
					small.push(big.pop());
					big.push(i);
				}
				else{
					big.push(i);
				}
					
			}
			else{
				big.push(i);
			}
			
		}
		
	}

	public float median(){
		if(small.isEmpty() && big.isEmpty())
			return 0;
		if(small.size() == big.size()){	
			float s = (float)small.peek();
			float b = (float)big.peek();
			float res = (float)(s+b)/2;
			return res;
		}
		if(small.size() > big.size())
			return small.peek();
		else{
			return big.peek();
		}
		
	}

	
}

class Heap{
	int[] array;
	int top = 0;
	int default_value;

	public Heap(int def){
		default_value = def;
		array = new int[100];
	}

	public void print(){
		if(!isEmpty()){
			for(int i = top - 1; i >= 0; i--){
				System.out.print(array[i]);
			}
			System.out.println();
		}
	}

	public void push(int i){
		array[top] = i;	
		top ++;	
	}

	public int pop(){
		top --;
		return array[top];		
	}

	public int peek(){
		if(isEmpty())
			return default_value;
		return array[top - 1];		
	}

	public boolean isEmpty(){
		if (top <= 0)
			return true;
		return false;
	}
	
	public int size(){
		return top;	
	}

	public void sort_ascending(){
		int position = top - 1;
		for(int i = top -1 ; i > 0; i--){
			if(array[i] >= array[i - 1])
				return;
			if(array[i] < array[i - 1]){
				int temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
			}
			
		}
	}

	public void sort_decending(){
		int position = top - 1;
		for(int i = top -1 ; i > 0; i--){
			if(array[i] <= array[i - 1])
				return;
			if(array[i] > array[i - 1]){
				int temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
			}
			
		}
	}
}
