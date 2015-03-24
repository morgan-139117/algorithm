package search;

import java.util.ArrayList;

class BNode {
	private BNode left;
	private BNode right;
	private int value;

	public BNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	public BNode floor(Node n) {
		return null;
	}

	public BNode ceiling(Node n) {
		return null;
	}

	public void SetLeft(BNode n) {
		left = n;
	}

	public void SetRight(BNode n) {
		right = n;
	}

	public void SetValue(int v) {
		value = v;
	}

	public BNode Left() {
		return left;
	}

	public BNode Right() {
		return right;
	}

	public int Value() {
		return value;
	}

}

public class BinarySearchTree {

	private BNode head;

	private int depth;

	public int size() {
		return this.size(head);
	}

	private int size(BNode n) {
		if (n == null)
			return 0;
		// Awesome
		return 1 + size(n.Left()) + size(n.Right());
	}

	public int depth() {
		return depth;
	}

	public boolean add(int value) {
		if (head == null) {
			head = new BNode(value);
			return true;
		}
		return add(head, value);
	}

	private boolean add(BNode n, int value) {

		if (value == n.Value()) {
			return false;
		} else if (value < n.Value()) {
			if (n.Left() == null)
				n.SetLeft(new BNode(value));
			else
				this.add(n.Left(), value);
		} else {
			if (n.Right() == null)
				n.SetRight(new BNode(value));
			else
				this.add(n.Right(), value);
		}
		return true;
	}

	private BNode min(BNode n) {
		if (n.Left() == null) {
			return n;
		}
		return min(n.Left());
	}
	
	private BNode delmin(BNode n){
		
		if(n.Left() == null) return n.Right();
		n.SetLeft(delmin(n.Left()));
		return n;
	}

	private BNode lift(BNode n) {
		if (n.Left() == null && n.Right() == null)
			return null;
		if (n.Left() != null && n.Right() != null) {
			BNode temp = min(n.Right());
			temp.SetRight(delmin(n.Right()));
			temp.SetLeft(n.Left());
			return temp;
		}

		if (n.Left() != null)
			return n.Left();
		if (n.Right() != null)
			return n.Right();
		return null;
	}

	public void remove(int value) {
		if (head == null)
			return ;
		if (head.Value() == value) {
			head = lift(head);
			return;
		}
		remove(head, value);
	}

	private boolean remove(BNode n, int value) {
		if (n == null)
			return false;
		if (n.Value() == value) {
			return true;
		}
		if (value < n.Value()) {//do be careful, java is pass by value,
			//modifications of left/right child are easier done at the parent
			//level after returns, as we know which child it is there but not
			//within the next level, and also the changes will last
			if (remove(n.Left(), value) == true) {
				n.SetLeft(lift(n.Left()));
			}
		} else {
			if (remove(n.Right(), value) == true) {
				n.SetRight(lift(n.Right()));
			}
		}
		return false;
	}

	public void bfirsttraverse() {
		ArrayList<BNode> upper = new ArrayList<BNode>();
		ArrayList<BNode> bottom = new ArrayList<BNode>();
		if (head == null)
			return;
		upper.add(head);
		do {
			bottom = new ArrayList<BNode>();
			for (BNode b : upper) {

				System.out.print(b.Value() + " ");
				if (b.Left() != null) {
					bottom.add(b.Left());
				}
				if (b.Right() != null)
					bottom.add(b.Right());
			}
			System.out.println();
			upper = bottom;
		} while (upper.size() != 0);
	}

	public void pretravese() {

	}

	public void intravese() {

	}

	public void posttravese() {

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.add(4);
		bst.add(1);
		bst.add(12);
		bst.add(3);
		bst.add(14);
		bst.add(5);
		bst.add(16);
		bst.add(7);
		bst.add(18);

		bst.bfirsttraverse();
		// System.out.println(bst.size());

		bst.remove(4);
		bst.bfirsttraverse();
		// System.out.println(bst.size());

	}
}
