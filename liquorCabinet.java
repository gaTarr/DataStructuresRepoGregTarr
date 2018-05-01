/**
 * 
 */

/**
 * @author Greg Tarr The liquorCabinet will store all the spirits in a binary
 *         tree. When a recipe is evaluated, it will search the tree for the
 *         spirits required in the recipe.
 *
 */
public class liquorCabinet {

	private Node root;

	/**
	 * constructor to create liquor cabinet
	 */
	public liquorCabinet() {
		root = null;
	}

	/**
	 * @param spirit
	 *        This Constructor takes a spirit
	 */
	public liquorCabinet(Spirits spirit) {
		add(spirit);
	}

	/**
	 * @param name
	 * @return true/false this method searches the tree for a particular spirit. It
	 *         returns true if it finds the spirit in the tree, and false if it does
	 *         not find it.
	 */
	public boolean search(Spirits spirit) {
		Node current = root;
		while (!current.spirit.getName().equalsIgnoreCase(spirit.getName())) // if places don't match
		{
			if (spirit.getName().compareToIgnoreCase(current.spirit.getName()) < 0) {

				current = current.LeftChild;
			} else {
				current = current.RightChild;
			}
			if (current == null) {
				System.out.println(spirit.getName() + " Not Found");
				return false; // didn't find match

			}
		}
		System.out.println(spirit.getName() + " Found!");
		return true; // found match
	}

	/**
	 * @param spirit
	 *            Spirits are inserted into the binary tree and are stored in the
	 *            tree based on their name.
	 */
	public void add(Spirits spirit) {

			Node newNode = new Node();
			newNode.spirit = spirit;

			if (root == null) { // if no node in root
				root = newNode; // put new node in root
			} else {
				Node current = root;// start at root
				Node parent;
				while (true) {
					parent = current;
					if (spirit.getName().compareToIgnoreCase(current.spirit.getName()) < 0) // check left
					{
						current = current.LeftChild; // if end of line
						if (current == null) {
							parent.LeftChild = newNode; // insert on left
							return;
						}
					} // end check left
					else // check right
					{
						current = current.RightChild;
						if (current == null) // if end of line
						{
							parent.RightChild = newNode;// insert on right
							return;
						}
					} // end check right
				}
			}
		

	}

	/**
	 * This Method finds a spirit, based on its name, to be deleted.
	 * 
	 * @param place
	 * @param spirit
	 * @return Three cases are considered, once the node has been found for
	 *         deletion: 1)if the node is a leaf. 2) if the node has one child. Or
	 *         3)if the node has 2 children.
	 */
	public boolean delete(Spirits spirit) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.spirit.getName() != spirit.getName()) // search for node
		{
			parent = current;
			if (spirit.getName().compareToIgnoreCase(current.spirit.getName()) < 0) // go left
			{
				isLeftChild = true;
				current = current.LeftChild;
			} else // go right
			{
				isLeftChild = false;
				current = current.RightChild;
			}
			if (current == null) { // end of line
				System.out.println(spirit.getName() + " Spirit not found.");
				return false; // didn’t find it
			}
		}
		// found node to delete
		// if no children, simply delete it
		if (current.LeftChild == null && current.RightChild == null) {
			if (current == root) {// if root,
				root = null; // tree is empty
			} else if (isLeftChild)
				parent.LeftChild = null;
			else
				parent.RightChild = null;
		}
		// if no right child, replace with left subtree
		else if (current.RightChild == null) {
			if (current == root) {
				root = current.LeftChild;
			} else if (isLeftChild) {
				parent.LeftChild = current.LeftChild;
			} else {
				parent.RightChild = current.LeftChild;
			}
		}
		// if no left child, replace with right subtree
		else if (current.LeftChild == null) {
			if (current == root) {
				root = current.RightChild;
			} else if (isLeftChild) {
				parent.LeftChild = current.RightChild;
			} else {
				parent.RightChild = current.RightChild;
			}
		} else // two children, so replace with successor
		{
			// get successor of node to delete (current)
			Node successor = getSuccessor(current);		// connect parent of current to successor instead
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.LeftChild = successor;
			else
				parent.RightChild = successor;			// connect successor to current’s left child
			successor.LeftChild = current.LeftChild;
		}
		System.out.println(spirit.getName() + " Spirit removed!");
		return true; // success
	}

	/**
	 * After a node with 2 children is deleted/removed, this method determines which
	 * child takes it's place
	 * 
	 * @param delNode
	 * @return
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.RightChild;
		while (current != null) // go right until no more left children
		{
			successorParent = successor;
			successor = current;
			current = current.LeftChild; // go to left child
		}
		if (successor != delNode.RightChild) // successor not right child,
		{
			successorParent.LeftChild = successor.RightChild;
			successor.RightChild = delNode.RightChild;
		}
		return successor;
	}
	/*  **CLEAR SEARCH TREE WITH THIS METHOD ***UNDER CONSTRUCTION
	public boolean reset() {
		root = null;
		return true;
	}*/

}
