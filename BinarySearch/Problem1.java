/*
As an exercise try to implement binary search, preferably on a sheet of paper or a whiteboard, in several forms. Start with the easy version, where you are given a sorted array of numbers A = [a1, a2, …, an] and you have to find the position of a number in the array. Then imagine that the number to look for may be any arbitrary number and if it’s not in the array it have to return the position after which it would be inserted.

Finally, imagine an array of zeroes and ones, where the zeroes come first and then come the ones. You have to find the position where the zeroes end and the ones start. Do you manage to handle all the cases? Try with a few examples to see if your programs work. What is the time and space complexity of your solutions?
*/

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
