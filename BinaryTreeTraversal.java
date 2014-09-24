import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeTraversal {
	static class TreeNode
	{
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode(int value)
		{
			this.value = value;
		}
	}
	public static void levelOrderTraversal(TreeNode tree)
	{
		if(tree==null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(tree);
		while(!q.isEmpty())
		{
			Queue<TreeNode> newQ = new LinkedList<TreeNode>();
			while(!q.isEmpty())
			{
				TreeNode node = q.poll();
				if(node.left!=null) newQ.offer(node.left);
				if(node.right!=null) newQ.offer(node.right);
				System.out.print(node.value);
			}
			System.out.println();
			q = newQ;
		}
	}
	public static void preOrderTraversal(TreeNode tree)
	{
		if(tree==null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(tree);
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			System.out.println(node.value);
			if(node.right!=null) stack.push(node.right);
			if(node.left!=null) stack.push(node.left);
		}
	}
	public static void inOrderTraversal(TreeNode tree)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = tree;
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
				System.out.println(node.value);
				node = node.right;
			}
		}
	}
	public static void postOrderTraversalWithPrevious(TreeNode tree)
	{
		if(tree==null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(tree);
		TreeNode pre = null;
		while(!stack.isEmpty())
		{
			TreeNode node = stack.peek();
			if(pre==null || pre.left==node || pre.right==node)
			{
				if(node.left!=null) stack.push(node.left);
				else if(node.right!=null) stack.push(node.right);
			}
			else if(node.left==pre)
			{
				if(node.right!=null) stack.push(node.right);
			}
			else
			{
				System.out.println(node.value);
				stack.pop();
			}
			pre = node;
		}
	}
//	void postOrderTraversalIterative(BinaryTree *root) {
//		  if (!root) return;
//		  stack<BinaryTree*> s;
//		  s.push(root);
//		  BinaryTree *prev = NULL;
//		  while (!s.empty()) {
//		    BinaryTree *curr = s.top();
//		    if (!prev || prev->left == curr || prev->right == curr) {
//		      if (curr->left)
//		        s.push(curr->left);
//		      else if (curr->right)
//		        s.push(curr->right);
//		    } else if (curr->left == prev) {
//		      if (curr->right)
//		        s.push(curr->right);
//		    } else {
//		      cout << curr->data << " ";
//		      s.pop();
//		    }
//		    prev = curr;
//		  }
//		}
	public static void postOrderTraversalWithTwoStack(TreeNode tree)
	{
		if(tree==null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		stack.push(tree);
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			output.push(node);
			if(node.left!=null) stack.push(node.left);
			if(node.right!=null) stack.push(node.right);
		}
		while(!output.isEmpty())
		{
			System.out.println(output.pop().value);
		}
	}
	public static void main(String[] args)
	{
		TreeNode tree = new TreeNode(0);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(3);
		tree.right.left = new TreeNode(4);
		tree.right.right = new TreeNode(5);
		tree.right.right.left = new TreeNode(6);
		postOrderTraversalWithPrevious(tree);
	}
}
