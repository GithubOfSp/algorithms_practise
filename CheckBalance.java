
public class CheckBalance {
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
	static int depth(TreeNode tree)
	{
		if(tree==null) return 0;
		if(tree.left==null && tree.right==null) return 1;
		int leftDepth = depth(tree.left);
		int rightDepth = depth(tree.right);
		return (leftDepth>rightDepth?leftDepth:rightDepth)+1;
	}
	public static boolean isBalance(TreeNode tree)
	{
		if(tree==null) return true;
		if(Math.abs(depth(tree.left)-depth(tree.right))>1) return false;
		return isBalance(tree.left) && isBalance(tree.right);
	}
	public static void main(String[] args)
	{
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(0);
		tree.right = new TreeNode(2);
		tree.right.left = new TreeNode(3);
		tree.right.left.left = new TreeNode(3);
		System.out.println(isBalance(tree));
	}
}
