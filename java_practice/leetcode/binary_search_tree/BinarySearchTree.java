// class TreeNode {
// 	int val;
// 	TreeNode left;
// 	TreeNode right;

// 	public TreeNode(int x) {
// 		val = x;
// 		left = null;
// 		right = null;
// 	}
// }

class BinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	
	TreeNode root = null;

	public void insert(int x) {
		TreeNode p = root;
		TreeNode t = new TreeNode(x);
		if(root == null) {
			root = t;
		} else {
			TreeNode temp = root;
			while(temp != null) {
				p = temp;
				if(temp.val >= x) {
					temp =temp.left;
				} else {
					temp = temp.right;
				}
			}
			if(p.val >= x)
				p.left = t;
			else
				p.right = t;
		}
	}

	// public void printBST(TreeNode root) {
	// 	TreeNode temp = root;





	// }
}