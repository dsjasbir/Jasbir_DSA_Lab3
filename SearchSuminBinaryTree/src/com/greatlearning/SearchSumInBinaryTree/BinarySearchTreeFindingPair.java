package com.greatlearning.SearchSumInBinaryTree;
import java.util.*;

public class BinarySearchTreeFindingPair {

	private static class Node{
		private int data;
		private Node left , right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
		public Node left() {
			return left;
		}
		
		public Node right() {
			return right;
		}
		
		public int data(){
			return data;
		}
	}
	
	
	
	private Node root;
	
	public BinarySearchTreeFindingPair(int rootdata) {
	super();
	this.root = new Node(rootdata);

	}
		
	public Node root() {
		return root;
	}
	
	
	public void insert (int data) {
		if (this.root == null) {
			this.root = new Node(data);
		}
		insert(this.root, data);
	}
	
	
	
	private Node insert(Node node, int data) {

		if(node == null)
			return new Node(data);
		
		if(data < node.data()) 
			node.left = insert(node.left(), data);
		else 
			node.right = insert(node.right(), data);

		return node;	
			
	}
	
	
	
	public Set<Integer> findSumPair (int sum){
		Set<Integer> values = new HashSet<>();
		Set<Integer> pair = new HashSet<>();
		traversePreOrder(this.root, sum, values, pair);
		return pair;
	}
	
	
	
	
	
	private boolean traversePreOrder(Node node, int sum, Set<Integer> collectedValues, Set<Integer> pair) {
		if (node == null) return false;
		int nodeData = node.data();
		if (collectedValues.contains(sum - nodeData)) {
			pair.add(sum - nodeData);
			pair.add(nodeData);
			return true;
		}
		collectedValues.add(nodeData);
			
		if (node.left() != null && traversePreOrder(node.left(), sum, collectedValues, pair))
		return true;
		if (node.right() != null && traversePreOrder(node.right(), sum, collectedValues, pair))
		return true;
		
		return false;
	}
	
	
	

	public static void main(String[] args) {

		BinarySearchTreeFindingPair bst = new BinarySearchTreeFindingPair(40);
		bst.insert (20);
		bst.insert (10);
		bst.insert (30);
		bst.insert (40);
		bst.insert (60);
		bst.insert (50);
		bst.insert (70);
		
		Set<Integer> pair = bst.findSumPair(130);
		if (pair.isEmpty()) {
			System.out.println("No Pair found!");
		}
		else {
			System.out.println("Pair is: " + pair);
		}
	}

}