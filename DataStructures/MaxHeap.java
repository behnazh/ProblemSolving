import java.util.*;

public class MaxHeap{
	Node root;
	int default_value; 
	Queue<Node> queue;
	int size = 0;

	public MaxHeap(int def){
		default_value = def;		
	}

	public void print(){
		queue = new LinkedList<Node>();
		queue.add(root);
		if(root != null){
			System.out.println("Root is: " + root.data);
		}
		while(!queue.isEmpty()){
			Node node = queue.remove();
			if(node == null){
				System.out.println();
				return;
			}	
			queue.add(node.left);
			queue.add(node.right);
			System.out.print(node.data + ",");
		}
		System.out.println();
	}

	public void push(int i){
		if(root == null){
			root = new Node(null, null, i);
			size ++;
			return;		
		}

		queue = new LinkedList<Node>();
		queue.add(root);
		insert(i);
		heapify(root);
		size ++;
		
	}

	private void insert(int i){
		while(!queue.isEmpty()){
			Node node = queue.remove();
			if(node == null){
				node = new Node(null, null, i);
				return;
			}
			if(node.left == null){
				node.left = new Node(null, null, i);
				node.left.parent = node;
				return;
			}
			if(node.right == null){
				node.right = new Node(null, null, i);
				node.right.parent = node;
				return;
			}	
			queue.add(node.left);
			queue.add(node.right);
		}		
	}

	public void heapify(Node root){
		if(root == null)
			return;
		heapify(root.left);
		heapify(root.right);
		Node maxChild = findMaxChild(root);
		if(maxChild == null)
			return;
		if(root.data < maxChild.data){
			int temp = root.data;
			root.data = maxChild.data;
			maxChild.data = temp;
		}
		moveDown(maxChild);	
			
	}

	private void moveDown(Node node){
		
		while(!node.isLeaf()){
			Node maxChild = findMaxChild(node);
			if(maxChild == null)
				return;
			if(node.data < maxChild.data){
				int temp = node.data;
				node.data = maxChild.data;
				maxChild.data = temp;
				node = maxChild;
			}
			else{
				return;
			}
		}

	}

	private Node findMaxChild(Node root){
		if(root.left == null)
			return null;
		if(root.right == null)
			return root.left;
		if(root.left.data > root.right.data)
			return root.left;
		else
			return root.right;
	}

	public int pop(){
		if(root == null){
			return default_value;
		}

		int result = root.data;
		queue = new LinkedList<Node>();
		queue.add(root);
		int last = removeLast();
		root.data = last;
		moveDown(root);		
		size --;
		return result;
	}


	private int removeLast(){
		int result = default_value;
		Node parent = null;
		while(!queue.isEmpty()){
			Node node = queue.remove();
			if(node == null)
				continue;
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			if(queue.isEmpty()){
				result = node.data;
				if(node.parent.left.equals(node))
					node.parent.left = null;
				else if(node.parent.right.equals(node))
					node.parent.right = null;				
				node = null;
			}
			parent = node;
		}
		return result;
	}


	public int peek(){
		if(isEmpty())
			return default_value;
		return root.data;	
	}

	public boolean isEmpty(){
		if (root == null)
			return true;
		return false;
	}
	
	public int size(){
		return size;	
	}
	
}

class Node{
	int data;
	Node left;
	Node right;
	Node parent;

	public Node(Node left, Node right, int t){
		data = t;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf(){
		if(left == null && right == null)
			return true;
		return false;
	}
}
