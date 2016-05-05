public class MinHeap{
	MaxHeap maxheap;
	public MinHeap(int def){
		maxheap = new MaxHeap(-1 * def);
	}
	public void print(){
		maxheap.print();
	}
	
	public void push(int i){
		maxheap.push(i * -1);
	}

	public int pop(){
		return -1 * maxheap.pop();
	}
	
	public int peek(){
		return -1 * maxheap.peek();
	}

	public boolean isEmpty(){
		return maxheap.isEmpty();
	}

	public int size(){
		return maxheap.size();
	}
}
