package algorithmsCouese.Course4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class twosat {
	public static HashMap<Integer, graphInfo> graphAll = new HashMap<Integer, graphInfo>();
	public static HashMap<Integer, Boolean> explored = new HashMap<Integer, Boolean>();
	
	public static class graphInfo {
		public ArrayList<Integer> edges;
		public ArrayList<Integer> edgesRev;
		
		public graphInfo(ArrayList<Integer> edges,ArrayList<Integer> edgesRev) {
			this.edges = edges;
			this.edgesRev = edgesRev;
		}	
	}
	public static Stack<Integer> nodeOrder = new java.util.Stack<Integer>();
	public static Stack<Integer> edgesStacks = new java.util.Stack<Integer>();
	public static Stack<Integer> backStacks = new java.util.Stack<Integer>();
	public static int[] sccLens = new int[6];
	public static int count;
//	private static File file = new File("src/algorithmsCouese/Course4/input_beaunus_32_10000.txt");
	private static File file = new File("src/algorithmsCouese/Course4/2sat6.txt");
//	public static int main(File file) throws IOException {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 
		// Reduction SCC "Course2 " Kosaraju_iterative_Pass
		getGraphs(file);
		ArrayList<Integer> nodes = new ArrayList<Integer>(graphAll.keySet());
		setExp(nodes);
		
		//Loop G 
		// edgesStacks started with 1 node, and keep add node until no path can go.
		while (!edgesStacks.empty()) {
			int k = edgesStacks.pop();
			if (explored.get(k) == false) {
				
				//push to explored and backStack for go back
				backStacks.push(k);
				explored.put(k, true);
				//check if meet with Loop
				setnodeOrder();
				
//				System.out.println("DFS1 :"+k);
				if (!graphAll.containsKey(k)) continue;
				ArrayList<Integer> edges = graphAll.get(k).edges;
				int edgeSize = edges.size();
				for (int i=0;i < edgeSize;i++ ) {
					int node = edges.get(edgeSize-i-1);
					if (explored.get(node) == false) {
						edgesStacks.push(node);
					}
				}
			}
		}
		System.out.println("DFS G END");
		
		setExp(nodes);
//		//Loop G rev
		boolean SAT = true;
		count = 0;
		edgesStacks.clear();
		while(!nodeOrder.empty()) {
			int k = nodeOrder.pop();
			ArrayList<Integer> SCCs = new ArrayList<Integer>();
			if (explored.get(k) == false) {
				explored.put(k, true);
				SCCs.add(k);
//				System.out.println("DFS1 :"+k);
				edgesStacks.push(k);
				while (!edgesStacks.empty()) {
					int i = edgesStacks.pop();
					if (!graphAll.containsKey(i)) continue;
					ArrayList<Integer> edgesRev = graphAll.get(i).edgesRev;
					int edgeSize = edgesRev.size();
					for (int j=0;j < edgeSize;j++ ) {
						int node = edgesRev.get(edgeSize -j -1);
						if (explored.get(node) == false) {
							edgesStacks.push(node);
							explored.put(node, true);
							SCCs.add(node);
						}
					}
				}
				if (checkSAT(SCCs)) {
					SAT = false;
					System.out.println("SAT is "+SAT);
				}
				int SSCsize = SCCs.size();
				addSCClen(SSCsize);
			}

		}
		System.out.println(Arrays.toString(sccLens));
		System.out.println("SAT is "+SAT);
		System.out.println("DFS G rev END");		
	}
	private static boolean checkSAT(ArrayList<Integer> sCCs) {
	// TODO Auto-generated method stub
		for (int x : sCCs) {
			for (int y : sCCs) {
//				System.out.println("x "+x+" y "+y);
				if (x+y == 0) {
					return true;
				}
			}
		}
	return false;
}
	private static void addSCClen(int s) {
		// TODO Auto-generated method stub
		if (sccLens[0] < s) {
			sccLens[0]=s;
		}
		Arrays.sort(sccLens);
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
		ArrayList<Integer> edges1 = new ArrayList<>();
		if (graphAll.containsKey(i)) {
			edges1 = graphAll.get(i).edges;
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
			edgesStacks.push(nodes.get(nodes.size()-i-1));
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
		    	
		    	ArrayList<Integer> edge_X = new ArrayList<>();
		    	ArrayList<Integer> edge_Xrev = new ArrayList<>();
		    	if (graphAll.containsKey(-x)) {
		    		edge_X = graphAll.get(-x).edges;
		    		edge_Xrev = graphAll.get(-x).edgesRev;
		    	}
		    	edge_X.add(y);
		    	graphInfo graphX = new graphInfo(edge_X,edge_Xrev);
    			graphAll.put(-x, graphX);
    			
		    	ArrayList<Integer> edge_Y = new ArrayList<>();
		    	ArrayList<Integer> edge_Yrev = new ArrayList<>();
		    	if (graphAll.containsKey(-y)) {
		    		edge_Y = graphAll.get(-y).edges;
		    		edge_Yrev = graphAll.get(-y).edgesRev;
		    	}
		    	edge_Y.add(x);
		    	graphInfo graphY = new graphInfo(edge_Y,edge_Yrev);
    			graphAll.put(-y, graphY);
    			
		    	ArrayList<Integer> edge_Xn = new ArrayList<>();
		    	ArrayList<Integer> edge_Xrevn = new ArrayList<>();
		    	if (graphAll.containsKey(x)) {
		    		edge_Xn = graphAll.get(x).edges;
		    		edge_Xrevn = graphAll.get(x).edgesRev;
		    	}
		    	edge_Xrevn.add(-y);
		    	graphInfo graphXn = new graphInfo(edge_Xn,edge_Xrevn);
    			graphAll.put(x, graphXn);
    			
		    	ArrayList<Integer> edge_Yn = new ArrayList<>();
		    	ArrayList<Integer> edge_Yrevn = new ArrayList<>();
		    	if (graphAll.containsKey(y)) {
		    		edge_Yn = graphAll.get(y).edges;
		    		edge_Yrevn = graphAll.get(y).edgesRev;
		    	}
		    	edge_Yrevn.add(-x);
		    	graphInfo graphYn = new graphInfo(edge_Yn,edge_Yrevn);
    			graphAll.put(y, graphYn);
    			
//    			graphInfo graphTmp = new graphInfo();
//    			graphTmp = graphAll.getOrDefault(node, graphTmp);
//    			ArrayList<Integer> edgeTmp = graphTmp.edges;
//    			ArrayList<Integer> edgeRevTmp = graphTmp.edgesRev;
//    			edgeTmp.add(edge);
//    			graphTmp.edges = edgeTmp;
//    			graphTmp.edgesRev = edgeRevTmp;
//    			graphAll.put(node, graphTmp);
//    			
//    			graphInfo graph2Tmp = new graphInfo();
//    			graph2Tmp = graphAll.getOrDefault(edge, graph2Tmp);
//    			ArrayList<Integer> edgeTmp2 = graph2Tmp.edges;
//    			ArrayList<Integer> edgeRevTmp2 = graph2Tmp.edgesRev;
//    			edgeRevTmp2.add(node);
//    			graph2Tmp.edges = edgeTmp2;
//    			graph2Tmp.edgesRev = edgeRevTmp2;
//    			graphAll.put(edge, graph2Tmp);
    			
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
