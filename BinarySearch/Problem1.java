public class Problem1{
	int[] array;

	public void init(int[] a){
		array = a;
	}

	public int search(int i){
		int N = array.length;
		return 	searchRecursive(i, 0, N-1);
	}

	public int searchRecursive(int key, int start, int end){
		int mid = (end + start) / 2;
		if(array[mid] == key)
			return mid;

		if(start == end){
			if(array[start] > key){
				return start - 1;			
			}	
			else{
				return start + 1;
			}
		}

		if(array[mid] > key){
			return searchRecursive(key, start, mid - 1);
		}

		if(array[mid] < key)
			return searchRecursive(key, mid + 1, end);
	
	return -1;
	}
}
