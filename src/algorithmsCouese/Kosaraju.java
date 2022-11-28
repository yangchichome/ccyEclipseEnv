package algorithmsCouese;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Kosaraju {
	public static int t =0;
	public static int s ;
	public static HashMap<Integer, ArrayList<Integer>> leader = new HashMap<Integer, ArrayList<Integer>>();
	public static HashMap<Integer, Integer> ftime = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ftime.clear();
		File file = new File("src/algorithmsCouese/graph0.txt");
		HashMap<Integer, ArrayList<Integer>> graphG = new HashMap<Integer, ArrayList<Integer>>();
		// Construct the initial graph
		construct(graphG,file);
		
		ArrayList<Integer> nodes = new ArrayList<>(graphG.keySet());
		Collections.sort(nodes, Collections.reverseOrder());  
		boolean[] explored = new boolean[Integer.MAX_VALUE-8];
		
		for (Integer i : nodes ) {
			if (explored[i] == false) {
				System.out.println("DFS1 :"+i);
				s = i;
				DFS(graphG,i,explored);
			}
		}
		showSCC();
		System.out.println("DFS G END");

		HashMap<Integer, ArrayList<Integer>> graphGrev = new HashMap<Integer, ArrayList<Integer>>();
		// Construct the graph Rev
		reconstruct(graphGrev,file);
		ArrayList<Integer> revnodes = new ArrayList<>(graphGrev.keySet());
		Collections.sort(revnodes, Collections.reverseOrder()); 
		boolean[] exploredrev = new boolean[Integer.MAX_VALUE-8];
		for (Integer i : nodes ) {
			if (exploredrev[i] == false) {
				System.out.println("DFS1 :"+i);
				s = i;
				DFS(graphGrev,i,exploredrev);
			}
		}
		showSCC();
		System.out.println("DFS G rev END");
		
	}
	private static void showSCC() {
		ArrayList<Integer> SCCs = new ArrayList<>();
		for (Integer name: leader.keySet()) {
//		    String key = name.toString();
//		    String value = leader.get(name).toString();
		    int len = leader.get(name).size();
		    SCCs.add(len);
//		    System.out.println(key + " " + value);
		}
		Collections.sort(SCCs, Collections.reverseOrder());
		for (int i=0;i< Math.min(5,SCCs.size());i++) {
			System.out.println("SCCs"+(i+1)+" :"+SCCs.get(i));
		}
		leader.clear();
	}
	
	private static void DFS(HashMap<Integer, ArrayList<Integer>> graphG, Integer i, boolean[] explored) {
		// TODO Auto-generated method stub
		explored[i] = true;
		setLeader(i,s);
		if(graphG.containsKey(i)){
			for (int j:graphG.get(i)) {
//				System.out.println("	DFS2 out :"+j);
				if (explored[j] == false) {
					System.out.println("	DFS2 in :"+j);
					DFS(graphG,j,explored);
				}
			}
		}
		t++;
		ftime.put(i, t);
	}
	
	private static void setLeader(Integer i, int s2) {
		// TODO Auto-generated method stub
		
    	ArrayList<Integer> leaderList = new ArrayList<Integer>();
    	if (leader.containsKey(s2)) {
    		leaderList = leader.get(s2);
    		if(!leaderList.contains(i)) {
        		leaderList.add(i);
				System.out.println("leader lens:"+leaderList.size());
        		leader.put(s2, leaderList);
    		}
    	}
    	else {
    		leaderList.add(i);
    		leader.put(s2, leaderList);
    	}
		
	}
	public static void construct(HashMap<Integer, ArrayList<Integer>> graph, File file) throws IOException
	{
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
		    	// Keep track of the key values
		    	
		    	//get node and edge
		    	int node = Integer.parseInt(vector[0]);
		    	int edge = Integer.parseInt(vector[1]);
		    	//initial edges
		    	ArrayList<Integer> edgelist = new ArrayList<Integer>();
		    	
		    	if (graph.containsKey(node)) {
		    		edgelist = graph.get(node);
		    		edgelist.add(edge);
			    	graph.put(node, edgelist);
		    	}
		    	else {
		    		edgelist.add(edge);
			    	graph.put(node, edgelist);
		    	}

		    	// Read a new line of text
		    	line = input.readLine();
		    } // while
		} // try
		finally
		{
			input.close();
		} // finally
	}
	private static void reconstruct(HashMap<Integer, ArrayList<Integer>> graph, File file) throws IOException {
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
		    	// Keep track of the key values
		    	
		    	//get node and edge
		    	int nodeold = Integer.parseInt(vector[1]);
		    	int node = ftime.get(nodeold);
		    	int edgeold = Integer.parseInt(vector[0]);
		    	int edge = ftime.get(edgeold);
		    	
		    	//initial edges
		    	ArrayList<Integer> edgelist = new ArrayList<Integer>();
		    	
		    	if (graph.containsKey(node)) {
		    		edgelist = graph.get(node);
		    		edgelist.add(edge);
			    	graph.put(node, edgelist);
		    	}
		    	else {
		    		edgelist.add(edge);
			    	graph.put(node, edgelist);
		    	}

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

