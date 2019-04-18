import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** set up for testing **/
public class HW7Test {
		// set of nodes for t1 and t5 and t7
		BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> two = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> six = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> seven = new BinaryTreeNode<Integer>(7);
		// set of nodes for t2
		BinaryTreeNode<Integer> uno = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> dos = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> tres = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> cuatro = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> cinco = new BinaryTreeNode<Integer>(5);
		// set of nodes for t3
		BinaryTreeNode<Integer> il = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> yi = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> sahm = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> sah = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> oh = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> yook = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> chill = new BinaryTreeNode<Integer>(7);
		// new root for combine method
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(100);
		// trees
		BinaryTree<Integer> t1 = new BinaryTree<Integer>(one);
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(uno);
		BinaryTree<Integer> t3 = new BinaryTree<Integer>(null);
		BinaryTree<Integer> t4 = new BinaryTree<Integer>(il);
		BinaryTree<Integer> t5 = new BinaryTree<Integer>(one);
		BinaryTree<Integer> t6 = new BinaryTree<Integer>(seven);
		
		
		@Before
		public void setUp() {
			//node one for t1 and t5
			one.setLeft(two);
			one.setRight(three);
			two.setLeft(four);
			two.setRight(five);
			three.setLeft(six);
			three.setRight(seven);	
			
			//node uno for t2
			uno.setLeft(dos);
			uno.setRight(tres);
			dos.setLeft(cuatro);
			dos.setRight(cinco);
			
			//node il for t4
			il.setLeft(yi);
			il.setRight(sahm);
			yi.setLeft(sah);
			yi.setRight(oh);
			sahm.setRight(chill);
			sahm.setLeft(yook);
		}
		
		public static void main(String arg[]) {
		}
		
		/** test for equals method for BinaryTree **/
		@Test
		public void testEquals() {
			assertTrue(t1.equals(t4)); // equal trees
			assertFalse(t1.equals(t2)); // different trees
			assertTrue(t1.equals(t5)); // equal trees
			assertEquals(t1, t4); // equal trees
		}
		
		/** test for equals method for BinaryTreeNode **/
		@Test
		public void testEqualsNode() {
			assertTrue(one.equals(il)); // same data in nodes
			assertEquals(two.equals(dos), true); // same data in nodes
		}
		
		/** test for deepCopy method for BinaryTree **/
		@Test
		public void testDeepCopy() {
			assertEquals(t1.deepCopy(), t1); // produces deep copy of tree
			assertEquals(t2.deepCopy(), t2); 
			assertTrue(t1.deepCopy().equals(t4)); 
			assertEquals(t6.deepCopy(), t6); 
		}
		
		/** test for deepCopy method for BinaryTreeNode **/
		@Test
		public void testDeepCopyNode() {
			assertEquals(two.deepCopy(), two); // produces deep copy of node
			assertTrue(three.deepCopy().equals(three));
		}

		/** test for combine method for BinaryTree **/
		@Test
		public void testCombine() {
			assertEquals(t1.combine(node, t2, true).getRoot().getRight(), uno); // combines two trees with new node. Right is t1
			assertEquals(t1.combine(node, t2, true).getRoot().getLeft(), one);
		}

		/** test for size method for BinaryTree **/
		@Test
		public void testSize() {
			assertTrue(t1.size() == 7); // returns correct number of nodes 
			assertEquals(t3.size(), 0);
		}
		
		/** test for size method for BinaryTreeNode**/
		@Test
		public void testSizeNode() {
			assertTrue(two.size() == 3); // returns correct number of nodes in subtree
			assertEquals(il.size(), 7);
		}
		
		
		/** test for height method for BinaryTree **/
		@Test
		public void testHeight() {
			assertEquals(t1.height(), 3); // returns correct height
			assertFalse(t3.height() == 1);
		}
		
		/** test for height method for BinaryTreeNode **/
		@Test
		public void testHeightNode() {
			assertTrue(one.height() == 3); // returns correct height of subtree
			assertTrue(four.height() == 1);
		}
		
		/** test for full method for BinaryTree **/
		@Test
		public void testFull() {
			assertTrue(t1.full()); // check if tree is full
			assertEquals(t2.full(), false);
		}
		
		/** test for full method for BinaryTreeNode **/
		@Test
		public void testFullNode() { // check is subtree is full
			assertTrue(three.full() == true);
			assertFalse(uno.full());
		}
		
		/** test for in order method for BinaryTree **/
		@Test
		public void testInOrder() {
			assertEquals(t1.inOrder(), "(4)(2)(5)(1)(6)(3)(7)"); // returns the nodes in order
			t2.mirror();
			assertEquals(t2.inOrder(), "(3)(1)(5)(2)(4)");
		}
		
		/** test for in order method for BinaryTreeNode **/
		@Test
		public void testInOrderNode() {
			assertEquals(two.inOrder(), "(4)(2)(5)"); // returns node of subtree in order
			assertEquals(tres.inOrder(), "(3)");
		}
		
		/** test for mirror method for BinaryTree **/
		@Test
		public void testMirror() {
			t2.mirror();
			assertTrue(3 == t2.getRoot().getLeft().getData()); // mirrors given tree
			assertTrue(4 == t2.getRoot().getRight().getRight().getData());
		}
		
		/** test for mirror method for BinaryTreeNode **/
		@Test
		public void testMirrorNode() {
			two.mirror();
			assertTrue(5 == two.getLeft().getData()); // mirrors given subtree
			assertTrue(4 == two.getRight().getData());
			
		}
	}