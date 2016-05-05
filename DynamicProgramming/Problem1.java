import java.util.*;

public class Problem1{
	public List<Integer> findLongestSubSequence(int[] seq){
		int n = seq.length;
		Set<List<Integer>> all_lists = new HashSet<List<Integer>>();
		List<Integer> initial_list = new ArrayList<Integer>();
		all_lists.add(initial_list);
		for(int i = 0; i < n; i++){			
			int max_length = -1;
			List<Integer> longest_subseq = null;
			for(List<Integer> list: all_lists){					
				int length = findLongestSubSubseq(list, seq[i]);
				if(length > max_length){
					max_length = length;
					longest_subseq = list;
				}
			}
			if(longest_subseq != null){
				Set<List<Integer>> new_lists = new HashSet<List<Integer>>();
				appendOrCreateNewList(longest_subseq, seq[i], new_lists);
				all_lists.addAll(new_lists);
			}
		}

		int max = 0;
		int index = 0;
		List<Integer> result = new ArrayList<Integer>();
		for(List<Integer> l: all_lists){
			if(l.size() > max){
				max = l.size();
				result = l;
			}			 
		}
		return result;
	} 

	private int findLongestSubSubseq(List<Integer> list, int number){
		int i = 0;
		for(i = 0; i < list.size(); i++){
			if(list.get(i) > number){
				break;
			}
		}
		return i;
	}

	private void appendOrCreateNewList(List<Integer> list, int number, Set<List<Integer>> new_lists){
		//test
		//print_array(list.toArray());
		int i;
		for(i = 0; i < list.size(); i++){
			if(list.get(i) > number){
				break;
			}
		}
		if(i == list.size()){
			list.add(new Integer(number));			
		}
		else{
			List<Integer> newlist = new ArrayList<Integer>();
			newlist.addAll(list.subList(0, i));
			newlist.add(new Integer(number));
			new_lists.add(newlist);			
		}
	}

	public void print_array(Object[] arr){
		if(arr.length == 0)
			return;
		for(int i = 0; i < arr.length - 1; i++){
			System.out.print(arr[i] + ",");
		}
		System.out.println(arr[arr.length - 1]);
	}
}
