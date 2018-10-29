import java.util.*;
import java.util.Map.Entry;

class Node{
	int data;
	Node left, right;
	Node(int d){
		this.data = d;
		left = right = null;
	}
}
public class TreeTraversals {
	static class Tree{
		Node root;
		int maxLvl = 0;
		public void leftView() {
			System.out.print("Left View : ");
			leftViewUtil(root, 1);
			maxLvl = 0;
			System.out.println();
		}
		private void leftViewUtil(Node root, int level) {
			if(root == null) return;
			if(level > maxLvl) {
				System.out.print(root.data + " ");
				maxLvl = level;
			}
			leftViewUtil(root.left, level + 1);
			leftViewUtil(root.right, level + 1);
			
		}
		public void rightView() {
			System.out.print("Right View : ");
			rightViewUtil(root, 1);
			maxLvl = 0;
			System.out.println();
		}
		private void rightViewUtil(Node root, int lvl) {
			if(root == null) return;
			if(lvl > maxLvl) {
				System.out.print(root.data + " ");
				maxLvl = lvl;
			}
			rightViewUtil(root.right, lvl + 1);
			rightViewUtil(root.left, lvl + 1);
		}
		public void topView() {
			System.out.print("Top View : ");
			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
			topViewUtil(root, map, 1, 0);
			Iterator ite = map.entrySet().iterator();
			while(ite.hasNext()) {
				Map.Entry<Integer, ArrayList<Integer>> set = (Entry<Integer, ArrayList<Integer>>) ite.next();
				System.out.print(set.getValue().get(0) + " ");
			}
			
			System.out.println();
			
		}
		public void topViewUtil(Node root, TreeMap<Integer, ArrayList<Integer>> map, int lvl, int hd) {
			if(root == null) return;
			if(map.get(hd) == null) {
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(root.data);
				arr.add(lvl);
				map.put(hd, arr);
			}else {
				
				if(map.get(hd).get(1) < lvl) {
					map.remove(hd);
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(root.data);
					arr.add(lvl);
					map.put(hd, arr);
				}
			}
			
			topViewUtil(root.left, map, lvl + 1, hd - 1);
			topViewUtil(root.right, map, lvl + 1, hd + 1);
		}
		public void bottomView() {
			System.out.print("Bottom View : ");
			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
			topViewUtil(root, map, 1, 0);
			Iterator ite = map.entrySet().iterator();
			while(ite.hasNext()) {
				Map.Entry<Integer, ArrayList<Integer>> set = (Entry<Integer, ArrayList<Integer>>) ite.next();
				System.out.print(set.getValue().get(0) + " ");
			}
			
			System.out.println();
			
		}
		public void bottomViewUtil(Node root, TreeMap<Integer, ArrayList<Integer>> map, int lvl, int hd) {
			if(root == null) return;
			if(map.get(hd) == null) {
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(root.data);
				arr.add(lvl);
				map.put(hd, arr);
			}else {
				
				if(map.get(hd).get(1) > lvl) {
					map.remove(hd);
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(root.data);
					arr.add(lvl);
					map.put(hd, arr);
				}
			}
			
			bottomViewUtil(root.left, map, lvl + 1, hd - 1);
			bottomViewUtil(root.right, map, lvl + 1, hd + 1);
		}

		public LinkedList getLinkedList(){
			LinkedList list = new LinkedList();
			getNodes(list, root);
			return list;
		}
		private void getNodes(LinkedList list, Node root) {
			if(root == null) return;
			getNodes(list, root.left);
			list.append(root.data);
			getNodes(list, root.right);
		}
	}
	
	static class LinkNode{
		int data;
		LinkNode next, prev;
		LinkNode(int data){
			this.data = data;
			next = prev = null;
		}
	}
	static class LinkedList{
		LinkNode head;
		public void append(int data) {
			if(head == null) {
				LinkNode node = new LinkNode(data);
				head = node;
			}else {
				LinkNode node = new LinkNode(data);
				LinkNode ptr = head;
				while(ptr.next != null) {
					ptr = ptr.next;
				}
				ptr.next = node;
				node.prev = ptr;
			}
		}
		
		public void printList() {
			LinkNode node = head;
			while(node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree ob = new Tree();
		ob.root = new Node(10);
		ob.root.left = new Node(20);
		ob.root.right = new Node(133);
		ob.root.right.left = new Node(34);
		ob.root.left.left = new Node(30);
		ob.leftView();
		ob.rightView();
		ob.topView();
		ob.bottomView();
		LinkedList list = ob.getLinkedList();
		System.out.print("Linkedlist : ");
		list.printList();
	}

}
