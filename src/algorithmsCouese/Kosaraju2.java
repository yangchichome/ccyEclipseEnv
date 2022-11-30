package algorithmsCouese;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Kosaraju2 {
	public static class graphInfo {
		public boolean exp;
		public ArrayList<Integer> edges;
		public ArrayList<Integer> edgesRev;
		public graphInfo() {
			this.exp = false;
			this.edges = new ArrayList<>();
			this.edgesRev = new ArrayList<>();
		}	
		public void setexpTrue () {
			exp = true;
		}
		public void setexpFalse () {
			exp = false;
		}
	}
	public static java.util.Stack<Integer> nodeOrder = new java.util.Stack<Integer>();
	public static ArrayList<Integer> scc = new ArrayList<Integer>();
//	public static ArrayList<ArrayList<Integer>> sccs = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer> sccLens = new ArrayList<Integer>();
	public static HashMap<Integer, graphInfo> graphAll = new HashMap<Integer, graphInfo>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/algorithmsCouese/graph0.txt");
		getGraphs(file);
		ArrayList<Integer> nodes = new ArrayList<Integer>(graphAll.keySet());
		//Loop G 
		for (Integer i : nodes ) {
			graphInfo graphTmp = new graphInfo();
			graphTmp = graphAll.getOrDefault(i, graphTmp);
			if (graphTmp.exp == false) {
				graphTmp.setexpTrue();
				graphAll.put(i, graphTmp);
				System.out.println("DFS1 :"+i);
				DFS(i);
			}
		}
		System.out.println("DFS G END");
		
		resetExp(nodes);
		
		//Loop G rev
		while(!nodeOrder.empty()) {
			int i = nodeOrder.pop();
			graphInfo graphTmp = new graphInfo();
			graphTmp = graphAll.getOrDefault(i, graphTmp);
			if (graphTmp.exp == false) {
				graphTmp.setexpTrue();
				graphAll.put(i, graphTmp);
				System.out.println("DFS1 rev :"+i);
				DFSRev(i);
			}
			sccLens.add(scc.size());
			scc.removeAll(scc);
		}
		Collections.sort(sccLens,Collections.reverseOrder());
		showSCC();
		System.out.println("DFS G rev END");
		
	}
	private static void DFSRev(int i) {
		// TODO Auto-generated method stub
		scc.add(i);
		graphInfo graphTmp = new graphInfo();
		graphTmp = graphAll.getOrDefault(i, graphTmp);
		for (Integer j : graphTmp.edgesRev ) {
			graphInfo graphT2 = new graphInfo();
			graphT2 = graphAll.getOrDefault(j, graphT2);
//				System.out.println("	DFS2 out :"+j);
			if (graphT2.exp == false) {
				graphT2.setexpTrue();
				graphAll.put(j, graphT2);
				System.out.println("	DFS2 in :"+j);
				DFSRev(j);
			}
		}
	}
	private static void resetExp(ArrayList<Integer> nodes) {
		// TODO Auto-generated method stub
		for (Integer i : nodes ) {
			graphInfo graphTmp = new graphInfo();
			graphTmp = graphAll.getOrDefault(i, graphTmp);
			graphTmp.setexpFalse();
			graphAll.put(i, graphTmp);
		}
		
	}
	private static void DFS(Integer i) {
		// TODO Auto-generated method stub
		graphInfo graphTmp = new graphInfo();
		graphTmp = graphAll.getOrDefault(i, graphTmp);
		for (Integer j : graphTmp.edges ) {
			graphInfo graphT2 = new graphInfo();
			graphT2 = graphAll.getOrDefault(j, graphT2);
//				System.out.println("	DFS2 out :"+j);
			if (graphT2.exp == false) {
				graphT2.setexpTrue();
				graphAll.put(j, graphT2);
//				System.out.println("	DFS2 in :"+j);
				DFS(j);
			}
		}
		nodeOrder.push(i);		
		
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
    			graphTmp.exp = false;
    			graphTmp.edges = edgeTmp;
    			graphTmp.edgesRev = edgeRevTmp;
    			graphAll.put(node, graphTmp);
    			
    			graphInfo graph2Tmp = new graphInfo();
    			graph2Tmp = graphAll.getOrDefault(edge, graph2Tmp);
    			ArrayList<Integer> edgeTmp2 = graph2Tmp.edges;
    			ArrayList<Integer> edgeRevTmp2 = graph2Tmp.edgesRev;
    			edgeRevTmp2.add(node);
    			graph2Tmp.exp = false;
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
	private static void showSCC() {
		Collections.sort(sccLens,Collections.reverseOrder());
		for (int i=0;i< Math.min(5,sccLens.size());i++) {
			System.out.println("SCCs"+(i+1)+" :"+sccLens.get(i));
		}
	}
//	private static void DFSRev(File file, int i, boolean[] exploredRev) throws IOException {
//		exploredRev[i] = true;
//		scc.add(i);
//		for (Integer j : getGRev(file,i) ) {
//			if (exploredRev[j] == false) {
//				System.out.println("	DFS2 rev in :"+j);
//				DFSRev(file,j,exploredRev);
//			}
//		}
//	}
//	private static void DFS(File file, Integer i, boolean[] explored) throws IOException {
//		// TODO Auto-generated method stub
//		explored[i] = true;
//		for (Integer j : getG(file,i) ) {
////				System.out.println("	DFS2 out :"+j);
//			if (explored[j] == false) {
//				System.out.println("	DFS2 in :"+j);
//				DFS(file,j,explored);
//			}
//		}
//		nodeOrder.push(i);
//	}
//	
//	private static ArrayList<Integer> getG(File file, Integer i) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new FileReader(file));
//    	ArrayList<Integer> edges = new ArrayList<Integer>();
//		try 
//		{
//			// Read a line of text from the file
//		    String line = input.readLine();
//		    while (line != null) 
//		    {
//		    	// Split the line of text into a vector of Strings
//		    	String[] vector = line.split(" ");
////		    	String[] vector = line.split("\t");
//		    	
//		    	//get node and edge
//		    	int node = Integer.parseInt(vector[0]);
//		    	int edge = Integer.parseInt(vector[1]);
//		    	//initial edges
//
//	    		if(node == i) {
//	    			edges.add(edge);
////					System.out.println("nodes lens:"+nodes.size());
//	    		}
//		    	// Read a new line of text
//		    	line = input.readLine();
//		    } // while
//		} // try
//		finally
//		{
//			input.close();
//		} // finally
//		Collections.sort(edges);
//		return edges;
//	}
//	private static ArrayList<Integer> getNodes(File file) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new FileReader(file));
//    	ArrayList<Integer> nodes = new ArrayList<Integer>();
//		try 
//		{
//			// Read a line of text from the file
//		    String line = input.readLine();
//		    while (line != null) 
//		    {
//		    	// Split the line of text into a vector of Strings
//		    	String[] vector = line.split(" ");
////		    	String[] vector = line.split("\t");
//		    	// Keep track of the key values
//		    	
//		    	//get node and edge
//		    	int node = Integer.parseInt(vector[0]);
//		    	int edge = Integer.parseInt(vector[1]);
//
//	    		if(!nodes.contains(node)) {
//	    			nodes.add(node);
////					System.out.println("nodes lens:"+nodes.size());
//	    		}
//	    		if(!nodes.contains(edge)) {
//	    			nodes.add(edge);
////					System.out.println("nodes lens:"+nodes.size());
//	    		}
//		    	
//		    	// Read a new line of text
//		    	line = input.readLine();
//		    } // while
//		} // try
//		finally
//		{
//			input.close();
//		} // finally
//		Collections.sort(nodes);
//		return nodes;
//	}
//	private static ArrayList<Integer> getGRev(File file, int i) throws IOException {
//		// TODO Auto-generated method stub
//		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new FileReader(file));
//    	ArrayList<Integer> edges = new ArrayList<Integer>();
//		try 
//		{
//			// Read a line of text from the file
//		    String line = input.readLine();
//		    while (line != null) 
//		    {
//		    	// Split the line of text into a vector of Strings
//		    	String[] vector = line.split(" ");
////		    	String[] vector = line.split("\t");
//		    	
//		    	//get node and edge
//		    	int node = Integer.parseInt(vector[1]);
//		    	int edge = Integer.parseInt(vector[0]);
//		    	//initial edges
//
//	    		if(node == i) {
//	    			edges.add(edge);
////					System.out.println("nodes lens:"+nodes.size());
//	    		}
//		    	// Read a new line of text
//		    	line = input.readLine();
//		    } // while
//		} // try
//		finally
//		{
//			input.close();
//		} // finally
//		Collections.sort(edges);
//		return edges;
//	}
}
//https://www.youtube.com/watch?v=Qdh6-a_2MxE
