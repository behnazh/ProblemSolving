/*
This problem was used for: Single Round Match 570 Round 1 - Division II, Level Three, TopCoder

The Centaur company has N servers, numbered 1 through N. These servers are currently connected into a network. The topology of the network is a tree. In other words, there are exactly N-1 bidirectional cables, each connecting some two servers in such a way that the entire network is connected. The Centaur company is about to split into two new companies: the Human company and the Horse company. When this happens, the companies will divide the servers somehow. Once they divide their servers, they will cut each cable that connects a server of the Horse company and a server of the Human company.

While the Horse company has a lot of cables, the Human company does not have any. Therefore, when dividing the servers, the Human company must get a set of servers that will remain connected after the cables are cut. You are given two int[]s a and b, each containing N-1 elements. These two arrays describe the original cables: for each i, there is a cable that connects the servers a[i] and b[i].
Compute and return the number of different ways in which the two companies may divide the servers. (It is possible that one of the companies will get no servers at all.)
*/


import java.util.*;

public class CentaurCompanyDiv2{
	long final_count = 0;
	Map<Integer, List<Integer>> tree;
	public long count(int[] a, int[] b){
		int N = a.length + 1;
		int root = a[0];
		makeTree(a, b, root);
		long root_count =  countRecursive(a, b, root);
		//in case no node is selected
		final_count += 1;
		return final_count;
	}

	private long countRecursive(int[] a, int[] b, int root){
		List<Integer> root_child = findChildren(a, b, root);
		long count_root = 1;
		if(root_child.isEmpty()){
			final_count += count_root;
			return count_root;
		}

		for(int  child: root_child){
			long count_child = countRecursive(a, b, child);
			count_root *= (count_child + 1);
		}

		final_count += count_root; 
		return count_root;
	}

	public void makeTree(int[] a, int[] b, int node){
		int N = a.length;
		if(tree == null)
			tree = new HashMap<Integer, List<Integer>>();
		if(tree.containsKey(node))
			return;
		List<Integer> child = new ArrayList<Integer>();
		tree.put(node, child);
		for(int j = 0; j < N; j++){
			if(a[j] == node){
				if(!tree.containsKey(b[j])){
					child.add(new Integer(b[j]));
					makeTree(a, b, b[j]);
				}
				else if(tree.containsKey(b[j])){
					if(!tree.get(b[j]).contains(a[j])){
						child.add(new Integer(b[j]));
						makeTree(a, b, b[j]);
					}
				}
				
			}
			else if(b[j] == node){
				if(!tree.containsKey(a[j])){
					child.add(new Integer(a[j]));
					makeTree(a, b, a[j]);
				}
				else if(tree.containsKey(a[j])){
					if(!tree.get(a[j]).contains(b[j])){
						child.add(new Integer(a[j]));
						makeTree(a, b, a[j]);
					}
				}
			}
		}
			//test
		//System.out.print(node + ":");
		//for(int i: child){
		//	System.out.print(i + ",");
		//}
		//System.out.println();

	}

	public List<Integer> findChildren(int[] a, int[] b, int node){
		return tree.get(node);
	}

}


