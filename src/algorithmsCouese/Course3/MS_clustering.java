package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class MS_clustering {
	
	public static class edgeCost {
		public Integer cost;
		public String node1;
		public String node2;
		public edgeCost(Integer cost,String node1,String node2) {
			this.cost=cost;
			this.node1=node1;
			this.node2=node2;
		}
	} 
	
	private static class costComparator implements Comparator<edgeCost>{
		
		public int compare (edgeCost node1,edgeCost node2) {
			if (node1.cost > node2.cost)
				return 1;
			else if (node1.cost < node2.cost)
				return -1;
			
			return 0;
		}
	}
	private static File file = new File("src/algorithmsCouese/Course3/clustering1.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/input_completeRandom_30_1024.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/TS2.txt");
	private static HashMap<String,Set<String>> clusters = new HashMap<String,Set<String>>();
	private static HashMap<String,String> nodeParent = new HashMap<String,String>();
	private static PriorityQueue<edgeCost> edgeCosts = new PriorityQueue<edgeCost>(500,new costComparator());
	private static Integer MSpace = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		initialCluster();
		
		//do cluster
		while(clusters.size()>4) {
			edgeCost minCost = edgeCosts.poll();
			mergeCluster(minCost);
			
		}
		//show final cluster
		for (Map.Entry<String, Set<String>> entry:clusters.entrySet()) {
			System.out.print("Key = "+entry.getKey()+", Size = "+entry.getValue().size()+", nodes : ");
			for (String node:entry.getValue()) {
				System.out.print(node+" ");
			}
			System.out.println("");
		}
		//find Minimum Space
		while(edgeCosts.size()>0) {
			edgeCost minCost = edgeCosts.poll();
			String parent1 = nodeParent.get(minCost.node1);
			String parent2 = nodeParent.get(minCost.node2);
			if (parent1.equals(parent2)) {
				continue;
			}else if (minCost.cost < MSpace){
				MSpace = minCost.cost;
			}
		}
		System.out.println("MST = "+MSpace);
		System.out.println("End");
	}
	private static void mergeCluster(edgeCost minCost) {
		// merge and clean cluster
		System.out.println("merge node1: "+minCost.node1+" and node2: "+minCost.node2+" Cost : "+minCost.cost);
		
		String node1 = nodeParent.get(minCost.node1);
		String node2 = nodeParent.get(minCost.node2);
		
		System.out.println("merge New node1: "+node1+" and New node2: "+node2);
		Set<String> nodes1 = new HashSet<>();
		nodes1 = clusters.get(node1);
		Set<String> nodes2 = new HashSet<>();
		nodes2 = clusters.get(node2);
		nodes1.addAll(nodes2);
		
		clusters.remove(node2);
		
		clusters.put(node1, nodes1);
		for(String node : nodes1) {
			nodeParent.put(node,node1);
		}
	}
	private static void initialCluster() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read a line of text from the file
			String line = input.readLine();
			while (line != null) {
				// Split the line of text Longo a vector of Strings
				String[] vertices = line.split(" ");
				
				if (vertices.length == 1) {
					line = input.readLine();
					continue;
				}else {
					// get edge
					String node1 = vertices[0];
					String node2 = vertices[1];
					Integer cost = Integer.parseInt(vertices[2]);
					
					if (!clusters.containsKey(node1)) {
						Set<String> clusterEdges = new HashSet<String>();
						clusterEdges.add(node1);
						clusters.put(node1, clusterEdges);
						nodeParent.put(node1, node1);
					}
					if (!clusters.containsKey(node2)) {
						Set<String> clusterEdges = new HashSet<String>();
						clusterEdges.add(node2);
						clusters.put(node2, clusterEdges);
						nodeParent.put(node2, node2);
					}
					edgeCost edgeCostSingle = new edgeCost(cost,node1,node2);
					edgeCosts.add(edgeCostSingle);
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
