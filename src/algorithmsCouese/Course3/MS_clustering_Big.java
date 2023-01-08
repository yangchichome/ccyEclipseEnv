package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import algorithmsCouese.commonLib.UnionFind;

public class MS_clustering_Big {
	
	public static class edgeCost {
		public Integer cost;
		public Integer node1;
		public Integer node2;
		public edgeCost(Integer cost,Integer node1,Integer node2) {
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
	private static File file = new File("src/algorithmsCouese/Course3/clustering_big.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/input_completeRandom_30_1024.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/TS2.txt");
//	private static HashMap<Integer,BitSet> nodesCoordinate = new HashMap<Integer,BitSet>();
	private static HashMap<String,ArrayList<Integer>> nodesCoordinate = new HashMap<>();
//	private static ArrayList<ArrayList<String>> nodesNeighbor = new ArrayList<ArrayList<String>>();
//	private static ArrayList<Integer> nodes = new ArrayList<Integer>();
//	private static PriorityQueue<edgeCost> edgeCosts = new PriorityQueue<edgeCost>(500,new costComparator());
	private static Integer MSpace = Integer.MAX_VALUE;
//	private static UnionFind unionsAll;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Start Init Cluster");
		
		Integer nodeSize = initialCluster();
		
		UnionFind unionsAll = new UnionFind(nodeSize);
		
		for (Map.Entry<String, ArrayList<Integer>> coordinateInfo:nodesCoordinate.entrySet()) {
			
//			ArrayList<String> nodeNeighbor = new ArrayList<>();
			String corrdinate = coordinateInfo.getKey();
			System.out.print("lv1 ref : "+corrdinate+" nodes : ");
			for (Integer node1:coordinateInfo.getValue()) {
				System.out.print(node1);
				System.out.println("");
				for (int i=0;i<corrdinate.length();i++) {
					
					StringBuilder plainText = new StringBuilder(corrdinate);
					char bit = ' ';
					if (plainText.charAt(i)=='1') {
						bit = '0';
					}else {
						bit = '1';
					}
					plainText.setCharAt(i, bit);
					String neightbor1 = plainText.toString();
//					System.out.println("Lv1 new : "+neightbor1);
					if (nodesCoordinate.containsKey(neightbor1)) {
						ArrayList<Integer> nodes = nodesCoordinate.get(neightbor1);
						for(Integer node2:nodes) {
							unionsAll.union(node1, node2);
						}
					}
					
					for (int j=0;j<corrdinate.length();j++) {
						plainText = new StringBuilder(neightbor1);

						if (i==j)
							continue;
//						System.out.println("	lv2 ref : "+plainText);
						if (plainText.charAt(j)=='1') {
							bit = '0';
						}else {
							bit = '1';
						}
						plainText.setCharAt(j, bit);
						String neightbor2 = plainText.toString();
						if (nodesCoordinate.containsKey(neightbor2)) {
							ArrayList<Integer> nodes = nodesCoordinate.get(neightbor2);
							for(Integer node2:nodes) {
								unionsAll.union(node1, node2);
							}
						}
					}
				}
			}
		}
		
//		for(int i=0;i<nodesCoordinate.size();i++) {
//			Integer node = i;
//			BitSet nodeCor = nodesCoordinate.get(i);
//			ArrayList<BitSet> nodeTmp = new ArrayList<BitSet>(nodesCoordinate);
//			
//			
//		}
//		//do cluster
//		while(nodesCoordinate.size()>4) {
//			edgeCost minCost = edgeCosts.poll();
//			mergeCluster(minCost);
//			
//		}
//		//show final cluster
//		for (Map.Entry<String, Set<String>> entry:nodesCoordinate.entrySet()) {
//			System.out.print("Key = "+entry.getKey()+", Size = "+entry.getValue().size()+", nodes : ");
//			for (String node:entry.getValue()) {
//				System.out.print(node+" ");
//			}
//			System.out.println("");
//		}
//		//find Minimum Space
//		while(edgeCosts.size()>0) {
//			edgeCost minCost = edgeCosts.poll();
//			String parent1 = nodeParent.get(minCost.node1);
//			String parent2 = nodeParent.get(minCost.node2);
//			if (parent1.equals(parent2)) {
//				continue;
//			}else if (minCost.cost < MSpace){
//				MSpace = minCost.cost;
//			}
//		}
		System.out.println("MST = "+unionsAll.numOfComponents);
		System.out.println("End");
	}
//	private static void initialCost() {
//		// TODO Auto-generated method stub
//		for(Map.Entry<Integer, BitSet> entry : nodesCoordinate.entrySet()) {
//			for(Map.Entry<Integer, BitSet> entry2 : nodesCoordinate.entrySet()) {
//				if (entry.getKey() == entry2.getKey())
//					continue;
//				System.out.println("Key1 = "+entry.getKey()+" Key2 = "+entry2.getKey());
//				BitSet b1 = entry.getValue();
//				BitSet b2 = entry2.getValue();
//				System.out.println("b1:"+b1+" len : "+b1.cardinality());
//				System.out.println("b2:"+b2+" len : "+b2.cardinality());
//				b1.xor(b2);
//				System.out.println("b3:"+b1+" len : "+b1.cardinality());
//				edgeCost cost = new edgeCost(b1.cardinality(),entry.getKey(),entry2.getKey());
//				edgeCosts.add(cost);
//			}
//		}
//	}
	private static void mergeCluster(edgeCost minCost) {
		// merge and clean cluster
		System.out.println("merge node1: "+minCost.node1+" and node2: "+minCost.node2+" Cost : "+minCost.cost);
		
//		String node1 = nodeParent.get(minCost.node1);
//		String node2 = nodeParent.get(minCost.node2);
		
//		System.out.println("merge New node1: "+node1+" and New node2: "+node2);
//		Set<String> nodes1 = new HashSet<>();
//		nodes1 = nodesCoordinate.get(node1);
//		Set<String> nodes2 = new HashSet<>();
//		nodes2 = nodesCoordinate.get(node2);
//		nodes1.addAll(nodes2);
		
//		nodesCoordinate.remove(node2);
		
//		nodesCoordinate.put(node1, nodes1);
//		for(String node : nodes1) {
//			nodeParent.put(node,node1);
//		}
	}
	private static Integer initialCluster() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		Integer node = 0;
		try {
			// Read a line of text from the file
			String line = input.readLine();

			while (line != null) {
				// Split the line of text Longo a vector of Strings
//				String[] vertices = line.split(" ");
				String corrdinate = line.replaceAll("\\s+","");
				
				if (corrdinate.length()<24) {
					line = input.readLine();
					continue;
				}
				ArrayList<Integer> nodes = new ArrayList<>();
				if (nodesCoordinate.containsKey(corrdinate)) {
					nodes = nodesCoordinate.get(corrdinate);
				}
				nodes.add(node);
				
				//store nodesCoordinate
				nodesCoordinate.put(corrdinate, nodes);
				node ++;
				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally
		return node;
	}

}
