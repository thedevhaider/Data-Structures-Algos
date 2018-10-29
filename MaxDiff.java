
public class MaxDiff {
	static class Tree{
		TreeNode node;
		int max = 0;
	    int maxDiff(TreeNode root)
	    {
	        //your code here
	        getMaxDiffUtil(root, root.data);
			return max;
	    }
	    public void getMaxDiffUtil(TreeNode node, int maxNodeData) {
				if(node == null) {
					return;
				}
				
				if(node.data > maxNodeData) {
					maxNodeData = node.data;
				}
				
				if(node.left == null && node.right == null) {
					
				}else if(node.left != null && node.right == null) {
					if(maxNodeData - node.left.data > max) {
						max = maxNodeData - node.left.data;
					}
				}else if(node.left == null && node.right != null) {
					if(maxNodeData - node.right.data > max) {
						max = maxNodeData - node.right.data;
					}
				}else {
					if(node.left.data > node.right.data && maxNodeData - node.right.data > max) {
						max = maxNodeData - node.right.data;
					}else if(node.right.data >= node.left.data && maxNodeData - node.left.data > max) {
						max = maxNodeData - node.left.data;
					}
					getMaxDiffUtil(node.left, maxNodeData);
					getMaxDiffUtil(node.right, maxNodeData);
				}
				
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.node = new TreeNode(50);
		tree.node.left = new TreeNode(40);
		tree.node.right = new TreeNode(10);
		tree.node.left.left = new TreeNode(5);
		System.out.println(tree.maxDiff(tree.node));
	}

}
