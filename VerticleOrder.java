import java.util.*;
import java.util.Map.Entry;

public class VerticleOrder {
	static class Tree{
		TreeNode root;
		public void verticleOrder() {
			TreeMap<Integer, Vector<Integer>> nodes = new TreeMap<>();
			addNodes(nodes, root, 0);
			Iterator ite = nodes.entrySet().iterator();
			while(ite.hasNext()) {
				Entry<Integer, Vector<Integer>> entry = (Entry<Integer, Vector<Integer>>) ite.next();
				Vector<Integer> arr = entry.getValue();
				System.out.print(arr.toString().replace(",", "").replace("[", "").replace("]", "") + " ");
				
			}
		}
		
		private void addNodes(TreeMap<Integer, Vector<Integer>> nodes, TreeNode node, int hd) {
			if(node == null) {
				return;
			}
			addNodes(nodes, node.left, hd - 1);
			if(nodes.get(hd) != null) {
				Vector<Integer> arr = nodes.get(hd);
				arr.add(node.data);
				nodes.put(hd, arr);
			}else {
				Vector<Integer> arr = new Vector<>();
				arr.add(node.data);
				nodes.put(hd, arr);
			}
			addNodes(nodes, node.right, hd + 1);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.right.left = new TreeNode(5);
		tree.verticleOrder();
		
	}

}
