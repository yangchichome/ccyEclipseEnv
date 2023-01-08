package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import algorithmsCouese.commonLib.UnionFind;

public class MS_clustering_Big {
	
	private static File file = new File("src/algorithmsCouese/Course3/clustering_big.txt");
	private static HashMap<String,ArrayList<Integer>> nodesCoordinate = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Start Init Cluster");
		
		Integer nodeSize = initialCluster();
		
		UnionFind unionsAll = new UnionFind(nodeSize);
		
		for (Map.Entry<String, ArrayList<Integer>> coordinateInfo:nodesCoordinate.entrySet()) {
			
			String corrdinate = coordinateInfo.getKey();
			
			for (Integer node1:coordinateInfo.getValue()) {
				
				//get nodes with distance = 1
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
					if (nodesCoordinate.containsKey(neightbor1)) {
						ArrayList<Integer> nodes = nodesCoordinate.get(neightbor1);
						for(Integer node2:nodes) {
							if (unionsAll.find(node1) != unionsAll.find(node2)) {
								unionsAll.union(node1, node2);
							}
						}
					}
					//get nodes with distance = 2
					for (int j=0;j<corrdinate.length();j++) {
						plainText = new StringBuilder(neightbor1);
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
								if (unionsAll.find(node1) != unionsAll.find(node2))
									unionsAll.union(node1, node2);
									System.out.println("K = "+unionsAll.numOfComponents);
							}
						}
					}
				}
			}
		}
		//print final result
		System.out.println("K = "+unionsAll.numOfComponents);
		System.out.println("End");
	}
	private static Integer initialCluster() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		Integer node = 0;
		try {
			// Read a line of text from the file
			String line = input.readLine();

			while (line != null) {
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
