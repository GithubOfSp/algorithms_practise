import java.util.Stack;

public class CheckBinarySearchTree {
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
	
	public static boolean isSearchTree(TreeNode tree)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = tree;
		int val = Integer.MIN_VALUE;
		while(!stack.isEmpty() || node!=null)
		{
			if(node!=null)
			{
				stack.push(node);
				node = node.left;
			}
			else
			{
				node = stack.pop();
				if(node.val<val) return false;
				val = node.val;
				node = node.right;
			}
		}
		return true;
	}
	
	public static boolean isSearchTree(TreeNode tree, int min, int max)
	{
		if(tree==null) return true;
		if(tree.val<min || tree.val>max) return false;
		return isSearchTree(tree.left, min, tree.val) && isSearchTree(tree.right, tree.val, max);
	}
	public static void main(String[] args)
	{
		TreeNode tree = new TreeNode(0);
		tree.left = new TreeNode(-1);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(-3);
		tree.right.left = new TreeNode(1);
		tree.right.right = new TreeNode(5);
		tree.right.right.left = new TreeNode(4);
		System.out.println(isSearchTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
