public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * See of two objects are equal trees
	 * @return boolean whether two trees are equal
	 */
	@Override
	public boolean equals(Object o) {
		//To do
		BinaryTree<T> otherTree = (BinaryTree<T>) o; // a tree of o
		return this.getRoot().equals(otherTree.getRoot()); // check if roots are equal with equals method from BinaryTreeNode
	}

	/**
	 *  method that returns a deep copy of calling object.
	 *  in the deep copy, the nodes should have the same fields.
	 * @return : deep copy of the calling object
	 */
	public BinaryTree<T> deepCopy() {
		//To do
		BinaryTree<T> Copytree = new BinaryTree<T>(null);
		if (this.getRoot() == null) {
			return null;
		}
		Copytree.setRoot(this.getRoot().deepCopy());
		return Copytree;

	}

	/**
	 *  returns a new tree combining the calling tree (the "this" tree when writing the method)
	 *   and the parameter t as subtrees of a new BinaryTree with the parameter root as the root of the new tree.
	 * @param newRoot : root of the new tree
	 * @param t : tree to be combined with the calling tree
	 * @param left : determines the order in which to attach the subtrees
	 * @return a new tree combining the calling tree
	 */
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,
			boolean left) {
		//To do
		BinaryTreeNode<T> binaryTreeNode = newRoot.deepCopy(); // set new root
		BinaryTree<T> binaryTreet = t.deepCopy(); // deep  copy of binary tree t
		BinaryTree<T> thisTree = this.deepCopy(); // deep copy of the calling tree
		BinaryTree<T> newBinaryTree = new BinaryTree<T>(binaryTreeNode); // new binary tree to be returned

		if(left == true) { //  If the parameter left is true, make "this" tree the new left subtree and BinaryTree t the new right subtree
			newBinaryTree.root.setLeft(thisTree.root);
			newBinaryTree.root.setRight(binaryTreet.root);
		} 
		else { // If left is false, make BinaryTree t the new left subtree and this tree the new right subtree.
			newBinaryTree.root.setLeft(binaryTreet.root);
			newBinaryTree.root.setRight(thisTree.root);
		}

		return newBinaryTree;
	}

	/**
	 * method that returns the size of the tree
	 * @return : (an int) the number of nodes in the tree
	 */
	public int size(){
		//To do
		if (this.getRoot() == null) { // if no root, tree does not exist
			return 0;
		} 
		else {
			return this.getRoot().size(); // call the size() from BinaryTreeNode on the root
		}
	}

	/**
	 * method that returns the total height of the tree, which is the maximum height of all nodes in the tree.
	 * The root of the tree is at height 1, the children of the root are at height 2, etc.
	 * ** Note: this is slightly different than other sources definition, some will take the root to be at height 0. **
	 * @return int that represents the height of the total tree
	 */
	public int height(){
		//To do
		if (this.getRoot() != null) { // if root exists, return height 
			return this.getRoot().height();
		}
		return 0; // if root does not exist, return 0
	}

	/**
	 * method that returns true if the binary tree is full and complete and false otherwise.
	 * @return boolean if binary tree is a perfect binary tree
	 */
	public boolean full(){
		//To do
		if (this.getRoot() == null) { // if root exists, return height 
			return false;
		}
		return this.root.full(); // check from the root node
	}

	/**
	 * method that takes the binary tree and changes the tree to its mirror.
	 * this is changing the calling tree not returning a new one.
	 */
	public void mirror(){
		//To do
		this.root.mirror(); // mirror binary tree from the root
	}

	/**
	 * method that returns a string that represents the data held at each node starting with all
	 * the nodes of the left child followed by the root then finally all the nodes of the right child.
	 * @return every data entry enclosed in parentheses printed in order (left, root, right).
	 */
	public String inOrder(){
		//To do
		return this.root.inOrder(); // inOrder binary tree from the root
	}
}