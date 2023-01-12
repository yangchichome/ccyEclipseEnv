package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PrimsMSTwithHeap {

	public static class edge {
		public Integer edge;
		public Integer cost;
		
		public edge (Integer edge,Integer cost) {
			
			this.edge=edge;
			this.cost=cost;
		}
	}
	
	public static class edgeComparator implements Comparator<edge>{
		
		public int compare (edge e1,edge e2) {
			if (e1.cost > e2.cost)
				return 1;
			else if (e1.cost < e2.cost)
				return -1;
			
			return 0;
		}
	}
	
	private static File file = new File("src/algorithmsCouese/Course3/edges.txt");
	private static HashSet<Integer> X = new HashSet<>();
	private static HashSet<Integer> V = new HashSet<>();
	private static HashMap<Integer,ArrayList<edge>> Graph = new HashMap<Integer,ArrayList<edge>>();
	private static PriorityQueue<edge> heapV = new PriorityQueue<edge>(2184,new edgeComparator()); //V-X
	private static boolean[] visited = new boolean[501] ;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		setSMTTree();
		Arrays.fill(visited, false);
		
		edge es = new edge(1, 0);
		heapV.add(es);
		
		Integer runTime =0;
		while (!V.isEmpty()) {
			
			edge cheapE = heapV.poll();
			Integer verV = cheapE.edge;
			Integer cost = cheapE.cost;
			
			if (V.contains(verV)) {
				System.out.println("Match Min Span : "+verV);
				
				X.add(verV);
				runTime += cost;
				V.remove(verV);
				
				ArrayList<edge> edgeList = Graph.get(verV);
				
				for (edge edge0 : edgeList) {
					if (X.contains(edge0.edge))
						continue;
					System.out.print("Update cout : ");
					System.out.print("	vertice = "+edge0.edge);
					System.out.println("	cost = "+edge0.cost);
					heapV.add(edge0);
				}
			}
		}
		System.out.println("Run time = "+runTime);
		System.out.println("End");
	}
	
	private static void setSMTTree() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read a line of text from the file
			String line = input.readLine();
			while (line != null) {
				// Split the line of text Longo a vector of Strings
				String[] vertices = line.split(" ");
				
				if (vertices.length == 2) {
					line = input.readLine();
					continue;
				}else {
					// get edge
					Integer e1 = Integer.parseInt(vertices[0]);
					Integer e2 = Integer.parseInt(vertices[1]);
					Integer cost = Integer.parseInt(vertices[2]);
					
					edge es1 = new edge(e2, cost);
					ArrayList<edge> eslList = new ArrayList<>();
					
					if (Graph.containsKey(e1))
						eslList = Graph.get(e1);
					eslList.add(es1);
					Graph.put(e1, eslList);
					
					edge es2 = new edge(e1, cost);
					ArrayList<edge> es2List = new ArrayList<>();
					
					if (Graph.containsKey(e2))
						es2List = Graph.get(e2);
					es2List.add(es2);
					Graph.put(e2, es2List);
					
					V.add(e1);
					V.add(e2);
					
				}

				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally
	}

}
