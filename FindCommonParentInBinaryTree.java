
public class FindCommonParentInBinaryTree {
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val)
		{
			this.val = val;
		}
	}
	
	static boolean checkExist(TreeNode tree, TreeNode node)
	{
		if(tree==node) return true;
		if(tree==null || node==null) return false;
		return checkExist(tree.left, node)||checkExist(tree.right, node);
	}
	//for two nodes
	static TreeNode getCommonParentRecursively(TreeNode tree, TreeNode node1, TreeNode node2)
	{
		if(tree==null || tree==node1 || tree==node2) return tree;
		TreeNode left = getCommonParentRecursively(tree.left, node1, node2);
		TreeNode right = getCommonParentRecursively(tree.right, node1, node2);
		if(left==null && right==null) return null;
		if(left==null) return right;
		if(right==null) return left;
		return tree;
	}
	public static TreeNode commonParent(TreeNode tree, TreeNode node1, TreeNode node2)
	{
		if(tree==null || node1==null || node2==null) return null;
		if(!checkExist(tree, node1) || !checkExist(tree, node2)) return null;
		if(node1==node2) return node1;
		return getCommonParentRecursively(tree, node1, node2);
	}
	//for multiple nodes
	static TreeNode getCommonParentRecursively(TreeNode tree, TreeNode... nodes)
	{
		if(tree==null)return tree;
		//can be optimized by sort and search
		for(TreeNode node:nodes)
		{
			if(tree==node) return tree;
		}
		TreeNode left = getCommonParentRecursively(tree.left, nodes);
		TreeNode right = getCommonParentRecursively(tree.right, nodes);
		if(left==null && right==null) return null;
		if(left==null) return right;
		if(right==null) return left;
		return tree;
	}
	public static TreeNode commonParent(TreeNode tree, TreeNode... nodes)
	{
		System.out.println("test");
		if(tree==null) return null;
		for(TreeNode node:nodes)
		{
			if(tree==null) return null;
			if(!checkExist(tree, node)) return null;
		}
		return getCommonParentRecursively(tree, nodes);	
	}
	
	//another method, record the path of the two nodes by stacks, backspace the deeper node to the same level as the other node, backspace together until meet each other.
	
	public static void main(String[] args)
	{
		TreeNode tree = new TreeNode(0);
		tree.left = new TreeNode(-1);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(-3);
		tree.right.left = new TreeNode(1);
		tree.right.right = new TreeNode(5);
		tree.right.right.left = new TreeNode(4);
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(0);
		tree.right.left.left = node1;
		tree.right.right.right = node2;
		System.out.println(commonParent(tree, node1, node2).val);
	}
}
