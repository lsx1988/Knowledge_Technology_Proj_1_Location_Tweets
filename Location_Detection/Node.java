//title			:Node.java
//description	:The Node object of a tree, contains a string, the distance to its root node and its leafs
//author		:Shixun Liu
//date			:2016/08/23
//usage			:Unimelb_KT_Assignment1_Approx String Matching
//=============================================================================

import java.util.ArrayList;
public class Node {

		public String str;
		public int distance;
		public ArrayList<Node> nodes;
		Node(){
			nodes = new ArrayList<Node>();
	}
}


