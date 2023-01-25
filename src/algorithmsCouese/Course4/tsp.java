package algorithmsCouese.Course4;

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
import java.util.Set;

public class tsp {
	
	public static class edgeCost {
		public double cost;
		public int node1;
		public int node2;
		public edgeCost(double cost,int name,int name2) {
			this.cost=cost;
			this.node1=name;
			this.node2=name2;
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
	
	public static class nodeXY {
		public int name;
		public double x;
		public double y;
		public nodeXY(int name,double x,double y) {
			this.name=name;
			this.x=x;
			this.y=y;
		}
	} 
	
	private static File file = new File("src/algorithmsCouese/Course4/tsp.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/input_float_10_4.txt");
//	private static HashSet<Integer> bitMasks = new HashSet<Integer>();
	private static HashMap<Integer,Integer> bitMaps = new HashMap<>();
	private static Double[][] A;
	//Cluster
	private static HashMap<Integer,Set<Integer>> clusters = new HashMap<Integer,Set<Integer>>();
	private static HashMap<Integer,Integer> nodeParent = new HashMap<Integer,Integer>();
	private static PriorityQueue<edgeCost> edgeCosts = new PriorityQueue<edgeCost>(500,new costComparator());
	private static ArrayList<nodeXY> nodes = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		N = getSize();
		initialCluster();
		
		//do cluster
		while(clusters.size()>22) {
			edgeCost minCost = edgeCosts.poll();
			mergeCluster(minCost);
		}
		
		//after cluster 
		int N = clusters.size();
		A = new Double[1 << N][N];
		Arrays.stream(A).forEach(a -> Arrays.fill(a, Double.MAX_VALUE));
		A[1][1]=0.0;
		//set map for bitMask
		int k = 1;
		for(Integer key:clusters.keySet()) {
			bitMaps.put(k, key);
			k++;
		}
		
		//for loop for subproblem
		int minPath = Integer.MAX_VALUE;
		for (int m=2;m<=N;m++) {
			//get S include 1,with size m
			HashSet<Integer> bitMasks = new HashSet<Integer>() ;
			bitMasks = getSet(m,N);
			System.out.println("get SebSet of M"+m);
			System.out.println("subSet size "+bitMasks.size());
//			for (int sub : bitMasks) {
//				System.out.println(" "+Integer.toBinaryString(sub));
//			}
			//for each set 1...n , set.contain(j) ,j != 1
			for (int S : bitMasks) {
				String setStr = Integer.toBinaryString(S);
				System.out.println("sub: "+setStr);
		        for (int i = 1; i < setStr.length(); i++) {
		        	char str1 = '1';
		        	if (setStr.charAt(i) == str1) {
		        		System.out.println(" "+i);
		        		int j = i;
//		        		A[S,j] = min k,j A[S-{j},k]+ckj];
		        		minPath = setA2D(S,j);
		        	}
		        }
			}
			System.out.println("SebSet End");
//			bitMasks.clear();
		}
		
		System.out.println("End");
	}

	private static int setA2D(int S, int j) {
		// TODO Auto-generated method stub
		String setStr = Integer.toBinaryString(S);
//		int jNew = bitMaps.get(j);
		int J = 1 << j;
		int subS_j = S - (1 << j);
		String setStr2 = Integer.toBinaryString(J);
		String setStr3 = Integer.toBinaryString(subS_j);
		System.out.println(setStr);
		System.out.println(setStr2);
		System.out.println(setStr3);
		
        for (int i = 0; i < setStr.length(); i++) {
        	char str1 = '1';
        	if (setStr.charAt(i) == str1) {
//        		System.out.print(" "+i);
        		
        		int k = i+1;
        		if (k!=j) {
        			
//        			int minPath = setA2D(A,S,j);
        		}
        	}
        }
		return 0;
	}

//	private static void setbitMaskMap() {
//		// TODO Auto-generated method stub
//		int index =0;
//		//get SubSet
//		System.out.println("get subset");
//		for (int m=2;m<N;m++) {
//			int b = 1;
//			int name = 0;
//			generatebitMasks(0,b,m,name);
//			
//			System.out.println("m = "+m);
//			System.out.println("final Size "+bitMasks.size());
//		}
//		System.out.println("set subset to Hash");
//		for (int S : bitMasks) {
////			String setStr = Integer.toBinaryString(S);
////			System.out.println("sub: "+setStr);
//			if (index <= 9000000) {
//				bitMask9M1.put(S, index++);
//			}else {
//				bitMask9M2.put(S, index++);
//			}
////			bitMask9M1.put(S, index++);
////			System.out.println(" index "+index);
//		}
//	}

	private static HashSet<Integer> getSet(int m, int n) {
		// TODO Auto-generated method stub
//		HashSet<Integer> bitMasks = new HashSet<Integer>();
		int b = 1;
		int name = 0;
		HashSet<Integer> bitMasks = new HashSet<Integer>();
		
		bitMasks = generatebitMasks(1,b,m,name,bitMasks);
		
		return bitMasks;
	}
	private static HashSet<Integer> generatebitMasks(int i, int b, int m, int name,HashSet<Integer> bitMasks) {
		// TODO Auto-generated method stub
		int N = clusters.size();
		if (name <= m-1) {
			if (i==N) {
				if (name==m-1)
					bitMasks.add(b);
			}else {
				//b[i] = 1
				int b1 = b | 1<<i;
				bitMasks = generatebitMasks(i+1,b1,m,name+1,bitMasks);
				
				int b0 = b;
				bitMasks = generatebitMasks(i+1,b0,m,name,bitMasks);
			}
		}
		return bitMasks;
	}
//	private static Object[] setDisMap() throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new FileReader(file));
//		Double[][] distance;
//		ArrayList<Integer> coorSet = new ArrayList<>(); 
//		
//		try {
//			// Read a line of text from the file
//			String line = input.readLine();
//			int size = Integer.valueOf(line);
//			distance = new Double[size][size];
//			Double[][] coor = new Double[size][2];
//			line = input.readLine();
//			int i =0;
//			while (line != null) {
//				// Split the line of text Longo a vector of Strings
//				String[] coordinate = line.split(" ");
//				
//				coor[i][0]= Double.valueOf(coordinate[0]);
//				coor[i][1]= Double.valueOf(coordinate[1]);
//				// Read a new line of text
//				coorSet.add(i);
//				i++;
//				line = input.readLine();
//			} // while
//			for (int s=0;s<distance.length;s++) {
//				for(int e=0;e<distance[0].length;e++) {
//					double disX = coor[s][0]-coor[e][0];
//					double disY = coor[s][1]-coor[e][1];
//					double disFinal = Math.sqrt(disX*disX+disY*disY);
//					distance[s][e]=disFinal;
//				}
//			}
//			
//		} // try
//		finally {
//			input.close();
//		} // finally
//		Object[] dis = new Object[2];
//		dis[0] = distance;
//		dis[1] = coorSet;
//		return dis;
//	}
//	private static int getSize() throws IOException {
//	// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new FileReader(file));
//		int size = 0;
//		try {
//			// Read a line of text from the file
//			String line = input.readLine();
//			size = Integer.valueOf(line);
//			
//			while (line != null) {
//				// Split the line of text Longo a vector of Strings
//				line = input.readLine();
//			} // while
//		} // try
//		finally {
//			input.close();
//		} // finally
//		return size;
//	}
	private static void mergeCluster(edgeCost minCost) {
		// merge and clean cluster
		System.out.println("merge node1: "+minCost.node1+" and node2: "+minCost.node2+" Cost : "+minCost.cost);
		
		int node1 = nodeParent.get(minCost.node1);
		int node2 = nodeParent.get(minCost.node2);
		
		System.out.println("merge New node1: "+node1+" and New node2: "+node2);
		Set<Integer> nodes1 = new HashSet<>();
		nodes1 = clusters.get(node1);
		Set<Integer> nodes2 = new HashSet<>();
		nodes2 = clusters.get(node2);
		nodes1.addAll(nodes2);
		
		clusters.remove(node2);
		
		clusters.put(node1, nodes1);
		for(int node : nodes1) {
			nodeParent.put(node,node1);
		}
	}
	
	private static void initialCluster() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read a line of text from the file
			String line = input.readLine();
			line = input.readLine();
			int name = 1;
			while (line != null) {
				// Split the line of text Longo a vector of Strings
				String[] vertices = line.split(" ");
				
				// get edge
				String xcor = vertices[0];
				String ycor = vertices[1];
				double x = Double.valueOf(xcor);
				double y = Double.valueOf(ycor);
				
//				edgeCosts
				for (nodeXY no : nodes) {
//					System.out.println("n1: "+no.name+" n2: "+name);
					double dis_X = (no.x - x)*(no.x - x);
					double dis_Y = (no.y - y)*(no.y - y);
					double cost = Math.sqrt(dis_X+dis_Y);
					edgeCost edge0 = new edgeCost(cost,no.name,name);
					edgeCosts.add(edge0);
					
					int node1 = no.name;
					int node2 = name;
					if (!clusters.containsKey(node1)) {
						Set<Integer> clusterEdges = new HashSet<Integer>();
						clusterEdges.add(node1);
						clusters.put(node1, clusterEdges);
						nodeParent.put(node1, node1);
					}
					if (!clusters.containsKey(node2)) {
						Set<Integer> clusterEdges = new HashSet<Integer>();
						clusterEdges.add(node2);
						clusters.put(node2, clusterEdges);
						nodeParent.put(node2, node2);
					}
				}
				
				nodeXY node = new nodeXY(name,x,y);
				
				nodes.add(node);
				name++;
				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally
	
	}
}
