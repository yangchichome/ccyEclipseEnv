package algorithmsCouese.Course4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class twosat {

	public static Stack<Integer> nodeOrder = new java.util.Stack<Integer>();
//	public static Stack<Integer> edgesStacks = new java.util.Stack<Integer>();
	public static Stack<Integer> backStacks = new java.util.Stack<Integer>();
//	public static int[] sccLens = new int[6];
//	public static int count=0;
	public static HashMap<Integer, Set<Integer>> graphAll = new HashMap<Integer, Set<Integer>>();
	public static HashMap<Integer, Boolean> explored = new HashMap<Integer, Boolean>();
//	private static File file = new File("src/algorithmsCouese/Course4/input_beaunus_10_20.txt");
	public static int main(File file) throws IOException {
		// TODO Auto-generated method stub 
		// Reduction SCC "Course2 " Kosaraju_iterative_Pass
		getGraphs(file);
		ArrayList<Integer> nodes = new ArrayList<Integer>(graphAll.keySet());
		setExp(nodes);
		
		//Loop G 
		// edgesStacks started with 1 node, and keep add node until no path can go.
		for (int node : nodes) {
//			System.out.println("");
			ArrayList<Integer> path = new ArrayList<>();
			Stack<Integer> edgesStacks = new Stack<Integer>();
			if (explored.get(node) == false) {
				edgesStacks.add(node);
//				System.out.println("Node: "+node);
			}else {
//				System.out.println("Node: "+node+" : explored");
			}
			while (!edgesStacks.empty()) {
				int k = edgesStacks.pop();
				if (explored.get(k) == false) {
					//push to explored and backStack for go back
					backStacks.push(k);
					explored.put(k, true);
					//check if meet with Loop
					setnodeOrder();
					
//					System.out.print(" "+k);
					Set<Integer> edges = new HashSet<Integer>();
					if (graphAll.containsKey(k)) {
						edges = graphAll.get(k);
					}
					for (int i :edges) {
						if (explored.get(i) == false) {
							edgesStacks.push(i);
							path.add(i);
						}
					}
				}
			}
//			System.out.println("");
			if (path.contains(-node)) {
//				System.out.println("false");
				return 0;
			}
		}
		return 1;
	}
	private static void setnodeOrder() {
		// TODO Auto-generated method stub
		while (!backStacks.isEmpty()) {
			int i = backStacks.pop();
			if (!getedgesExp(i).contains(false)) {
				nodeOrder.push(i);
			}
			else {
				backStacks.push(i);
				break;
			}
		}
	}
	private static ArrayList<Boolean> getedgesExp(Integer i) {
		// TODO Auto-generated method stub
		Set<Integer> edges1 = new HashSet<>();
		if (graphAll.containsKey(i)) {
			edges1 = graphAll.get(i);
		}
		ArrayList<Boolean> expEdges = new ArrayList<Boolean>();
		
		//check nodes
		for (Integer j : edges1 ) {
//			ArrayList<Integer> edges2 = new ArrayList<>();
//			if (graphAll.containsKey(j)) {
//				edges2 = graphAll.get(j);
//			}
//			graphInfo graphT2 = new graphInfo();
//			graphT2 = graphAll.getOrDefault(j, graphT2);
			expEdges.add(explored.get(j));
		}
		return expEdges;
	}
	private static void setExp(ArrayList<Integer> nodes) {
		// TODO Auto-generated method stub
		for (int i = 0; i< nodes.size() ;i++) {
			explored.put(nodes.get(i), false);
//			edgesStacks.push(nodes.get(nodes.size()-i-1));
		}
	}
	private static void getGraphs(File file) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try 
		{
			// Read a line of text from the file
		    String line = input.readLine();
		    line = input.readLine();
		    while (line != null) 
		    {
		    	// Split the line of text into a vector of Strings
		    	String[] vector = line.split(" ");
//		    	String[] vector = line.split("\t");
		    	
		    	//get node and edge
		    	int x = Integer.parseInt(vector[0]);
		    	int y = Integer.parseInt(vector[1]);
		    	
		    	Set<Integer> edge_X = new HashSet<>();
		    	if (graphAll.containsKey(-x)) {
		    		edge_X = graphAll.get(-x);
		    	}
		    	edge_X.add(y);
    			graphAll.put(-x, edge_X);
    			
		    	Set<Integer> edge_Y = new HashSet<>();
		    	if (graphAll.containsKey(-y)) {
		    		edge_Y = graphAll.get(-y);
		    	}
		    	edge_Y.add(x);
    			graphAll.put(-y, edge_Y);
    			
    			if (!explored.containsKey(-x)) explored.put(-x, false);
    			if (!explored.containsKey(-y)) explored.put(-y, false);
    			if (!explored.containsKey(x)) explored.put(x, false);
    			if (!explored.containsKey(y)) explored.put(y, false);
    			
		    	// Read a new line of text
		    	line = input.readLine();
		    } // while
		} // try
		finally
		{
			input.close();
		} // finally
		
	}
}
