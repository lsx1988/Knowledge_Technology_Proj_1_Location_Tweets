//title			:Tree.java
//description	:Add each location into a tree structure based on its levenshtein distance with root node
//author		:Shixun Liu
//date			:2016/08/23
//usage			:Unimelb_KT_Assignment1_Approx String Matching
//=============================================================================\

import java.util.ArrayList;

public class Tree {
	
	public ArrayList<String> searchResult = new ArrayList<String>();
	
	public Node getNewNode(int distance, String str){
		Node newNode = new Node();
		newNode.distance = distance;
		newNode.str = str;
		return newNode;
	}
	
	public Node insert(Node root, int distance, String str){
		if(root == null){
			root = getNewNode(distance,str);
			return root;
		}
		if(root.nodes.size()==0){
			root.nodes.add(insert(null,distance,str));
			return root;
		}else{
			for(Node node:root.nodes){
				if(node.distance == distance){
					node.nodes.add(insert(null, distance, str));
					return root;
				}
			}
			root.nodes.add(insert(null,distance,str));
			return root;
		}	
	}
	
	public void search(Node root, int ged){
		
	    for(Node node:root.nodes){
			if(node.distance == ged){
				searchResult.add(node.str);
				search(node, ged);
			}
		}
	}
}
