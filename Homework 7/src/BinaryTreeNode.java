
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode(){
		this(null,null,null);
	}

	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size(){
		int size = 0; //the size of the tree

		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 *  method that returns a deep copy of calling object.
	 *  in the deep copy, the nodes should have the same fields.
	 * @return deep copy of the calling object
	 */
	public BinaryTreeNode<T> deepCopy(){
		//To do
		BinaryTreeNode<T> treeNode = new BinaryTreeNode<T>(); // new deep copy tree
		treeNode.left = null; // condition of left child is null
		treeNode.right = null; // condition of right child is null
		treeNode.data = null; // condition of data is null

		if (this.getData() != null) { // set data if not null
			treeNode.data = this.getData();
		}
		if (this.getLeft() != null) { // set left child if not null
			treeNode.left = this.getLeft().deepCopy();
		}
		if (this.getRight() != null) { // set right child if not null
			treeNode.right = this.getRight().deepCopy();
		}
		return treeNode;
	}

	/**
	 * Two BinaryTreeNodes are equal if their data are equal and their subtrees are equal
	 * @return boolean whether two tree nodes are equal
	 */
	@Override
	public boolean equals(Object o){
		//To do
		if (o == null) { // check that object o is not null
			return false;
		}
		if(!(o instanceof BinaryTreeNode)) { // check that o is instance of BinaryTreeNode
			return false;
		}
		BinaryTreeNode<T> that = (BinaryTreeNode<T>) o; // create a dummy tree node
		if(this.data != that.data) { // check if data are equal before checking other conditions
			return false;
		}
		if (this.left == null && that.left == null) { // if node is a leaf node return true
			if (this.right == null && that.right == null) {
				return true;
			}
		}
		if (this.left != null && that.left != null) { // if there is left child with no right child, check left
			if (this.right == null && that.right == null) {
				return this.getLeft().equals(that.getLeft());
			}
		}
		if (this.left == null && that.left == null) { // if there is right child with no left child, check right
			if (this.right != null && that.right != null) {
				return this.getRight().equals(that.getRight());
			}
		}
		if (this.left != null && that.left != null) { // if there is both left and right check both
			if (this.right != null && that.right != null) {
				return this.getLeft().equals(that.getLeft()) && this.getRight().equals(that.getRight());
			}
		}
		return false;
	}

	/**
	 * the method that returns the height of the subtree
	 * @return the height of the subtree with this current node as the "root"
	 */
	public int height(){
		//To do
		if (this.left != null && this.right == null) { // if there is no right child count left
			return this.getLeft().height() + 1;
		} 
		else if (this.right != null && this.left == null) { // if there is no left child count right
			return this.getRight().height() + 1;
		} 
		else if (this.right != null && this.left != null) { // if both left and right child exits, find the max height of the two
			return Math.max(this.getRight().height(), this.getLeft().height()) + 1;
		}
		else if (this.right == null && this.left == null) { // the base case, root is height 1
			return 1;
		}
		else { // if tree does not exist return 0
			return 0;
		}
	}

	/**
	 * method that returns true if the binary tree is full and complete and false otherwise.
	 * a full and complete tree is one in which all nodes other than leafs have two children and all leafs have the same height.
	 * @return boolean whether tree is perfect binary tree
	 */
	public boolean full(){
		//To do
		if(this.left == null && this.right == null) { // check if all nodes other than leafs have two children
			return true;
		} 
		else if((this.left!=null) && (this.right!=null)) {
			if (right.height() == left.height()) { // check if all leafs have the same height
				return left.full() && right.full();
			}
		}
		return false;
	}

	/**
	 * method that takes the binary tree and changes the tree to its mirror.
	 * this is changing the calling tree not returning a new one.
	 */
	public void mirror(){
		//To do
		if (this.right != null && this.left == null) { // if there is no left child node, put right child node in place of left child node
			this.setLeft(this.getRight().deepCopy()); 
			this.setRight(null);
			this.left.mirror(); // continue to mirror on the subtree of the node you replaced
		} 
		else if (this.right == null && this.left != null) { // if there is no right child node, put left child node in place of right child node
			this.setRight(this.getLeft().deepCopy());
			this.setLeft(null);
			this.right.mirror(); // continue to mirror on the subtree of the node you replaced
		} 
		else if (this.right != null && this.left != null) { // if there is a right and left child node, swap the two
			BinaryTreeNode<T> mirrored = this.getLeft().deepCopy(); // copy left left side so when you swap, you will have stored data
			this.setLeft(this.getRight().deepCopy()); // replace left side with right side
			this.setRight(mirrored); // set right side with stored left side
			this.right.mirror(); // continue  to mirror the right side
			this.left.mirror(); // continue to mirror the left side
		}

	}

	/**
	 * method that returns a string that represents the data held at each node starting with all
	 * the nodes of the left child followed by the root then finally all the nodes of the right child.
	 * @return every data entry enclosed in parentheses printed in order (left, root, right).
	 */
	public String inOrder(){
		//To do
		String order = ""; // string to be returned 

		if (this.left != null){ // traverse through the left side first
			order += this.left.inOrder();
		}

		order += "(" + this.data + ")"; // add node to order if no more left child

		if (this.right != null){ // traverse through the right side last
			order += this.right.inOrder();
		}
		return order;
	}
}