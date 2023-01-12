package algorithmsCouese.Course2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Kosaraju_iterative_Pass {
	public static java.util.Stack<Integer> nodeOrder = new java.util.Stack<Integer>();
	public static java.util.Stack<Integer> edgesStacks = new java.util.Stack<Integer>();
	public static java.util.Stack<Integer> backStacks = new java.util.Stack<Integer>();
	public static int[] sccLens = new int[6];
	public static int count=0;
	public static HashMap<Integer, graphInfo> graphAll = new HashMap<Integer, graphInfo>();
	public static HashMap<Integer, Boolean> explored = new HashMap<Integer, Boolean>();
	
	public static class graphInfo {
		public ArrayList<Integer> edges;
		public ArrayList<Integer> edgesRev;
		
		public graphInfo() {
			this.edges = new ArrayList<>();
			this.edgesRev = new ArrayList<>();
		}	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/algorithmsCouese/Course2/graphR.txt");
		getGraphs(file);
		ArrayList<Integer> nodes = new ArrayList<Integer>(graphAll.keySet());
		setExp(nodes);
		
		//Loop G 
		while (!edgesStacks.empty()) {
			int k = edgesStacks.pop();
			if (explored.get(k) == false) {
				backStacks.push(k);
				explored.put(k, true);
				setnodeOrder();
				System.out.println("DFS1 :"+k);
				graphInfo graphTmp2 = new graphInfo();
				graphTmp2 = graphAll.getOrDefault(k, graphTmp2);
				int edgeSize = graphTmp2.edges.size();
				for (int i=0;i < edgeSize;i++ ) {
					int node = graphTmp2.edges.get(edgeSize-i-1);
					if (explored.get(node) == false) {
						edgesStacks.push(node);
					}
				}
			}
		}
		
		System.out.println("DFS G END");
		
		setExp(nodes);
//		//Loop G rev
		count = 0;
		edgesStacks.clear();
		while(!nodeOrder.empty()) {
			int k = nodeOrder.pop();
			ArrayList<Integer> SCCs = new ArrayList<Integer>();
			if (explored.get(k) == false) {
				explored.put(k, true);
				SCCs.add(k);
				System.out.println("DFS1 :"+k);
				edgesStacks.push(k);
				while (!edgesStacks.empty()) {
					int i = edgesStacks.pop();
					graphInfo graphTmp2 = new graphInfo();
					graphTmp2 = graphAll.getOrDefault(i, graphTmp2);
					int edgeSize = graphTmp2.edgesRev.size();
					for (int j=0;j < edgeSize;j++ ) {
						int node = graphTmp2.edgesRev.get(edgeSize -j -1);
						if (explored.get(node) == false) {
							edgesStacks.push(node);
							explored.put(node, true);
							SCCs.add(node);
						}
					}
				}
				int SSCsize = SCCs.size();
				addSCClen(SSCsize);
			}

		}
		System.out.println(Arrays.toString(sccLens));
		System.out.println("DFS G rev END");
		
	}
	private static void setExp(ArrayList<Integer> nodes) {
		// TODO Auto-generated method stub
		for (int i = 0; i< nodes.size() ;i++) {
			explored.put(nodes.get(i), false);
			edgesStacks.push(nodes.get(nodes.size()-i-1));
		}
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
		graphInfo graphTmp = new graphInfo();
		graphTmp = graphAll.getOrDefault(i, graphTmp);
		ArrayList<Boolean> expEdges = new ArrayList<Boolean>();
		
		//check nodes
		for (Integer j : graphTmp.edges ) {
			graphInfo graphT2 = new graphInfo();
			graphT2 = graphAll.getOrDefault(j, graphT2);
			expEdges.add(explored.get(j));
		}
		return expEdges;
	}
	
	private static void getGraphs(File file) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try 
		{
			// Read a line of text from the file
		    String line = input.readLine();
		    while (line != null) 
		    {
		    	// Split the line of text into a vector of Strings
		    	String[] vector = line.split(" ");
//		    	String[] vector = line.split("\t");
		    	
		    	//get node and edge
		    	int node = Integer.parseInt(vector[0]);
		    	int edge = Integer.parseInt(vector[1]);
		    	
    			graphInfo graphTmp = new graphInfo();
    			graphTmp = graphAll.getOrDefault(node, graphTmp);
    			ArrayList<Integer> edgeTmp = graphTmp.edges;
    			ArrayList<Integer> edgeRevTmp = graphTmp.edgesRev;
    			edgeTmp.add(edge);
    			graphTmp.edges = edgeTmp;
    			graphTmp.edgesRev = edgeRevTmp;
    			graphAll.put(node, graphTmp);
    			
    			graphInfo graph2Tmp = new graphInfo();
    			graph2Tmp = graphAll.getOrDefault(edge, graph2Tmp);
    			ArrayList<Integer> edgeTmp2 = graph2Tmp.edges;
    			ArrayList<Integer> edgeRevTmp2 = graph2Tmp.edgesRev;
    			edgeRevTmp2.add(node);
    			graph2Tmp.edges = edgeTmp2;
    			graph2Tmp.edgesRev = edgeRevTmp2;
    			graphAll.put(edge, graph2Tmp);
	    		
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
//https://www.youtube.com/watch?v=Qdh6-a_2MxE
//https://www.coursera.org/learn/algorithms-graphs-data-structures/discussions/weeks/1/threads/fxZJZZWTEeuAwA5JxuJq6Q