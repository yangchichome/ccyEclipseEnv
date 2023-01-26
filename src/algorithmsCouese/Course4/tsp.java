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
		while(clusters.size()>21) {
			edgeCost minCost = edgeCosts.poll();
			mergeCluster(minCost);
		}
		
		//after cluster 
		int N = clusters.size();
		A = new Double[1 << N][N+1];
		Arrays.stream(A).forEach(a -> Arrays.fill(a, Double.MAX_VALUE));
		A[1][1]=0.0;
		//set map for bitMask
		int k = 1;
		for(Integer key:clusters.keySet()) {
			bitMaps.put(k, key);
			k++;
		}
		
		//for loop for subproblem
		for (int m=2;m<=N;m++) {
			//get S include 1,with size m
			HashSet<Integer> bitMasks = new HashSet<Integer>() ;
			bitMasks = getSet(m,N);
//			System.out.println("get SebSet of M"+m);
//			System.out.println("subSet size "+bitMasks.size());
//			for (int sub : bitMasks) {
//				System.out.println(" "+Integer.toBinaryString(sub));
//			}
			//for each set 1...n , set.contain(j) ,j != 1
			for (int S : bitMasks) {
				String Sstr = Integer.toBinaryString(S);
//				System.out.println("sub: "+Sstr);
		        for (int i = 1; i < Sstr.length(); i++) {
		        	char str1 = '1';
		        	if (Sstr.charAt(i) == str1) {
		        		int j = i+1;
		        		A[S][j] = setA2D(S,j);
//		        		System.out.println("J: "+j+"value: "+A[S][j]);
		        	}
		        }
			}
//			System.out.println("SebSet End");
		}
		//Return min
		ArrayList<Integer> tour = new ArrayList<Integer>();
		int FullS = 1;
		for (int i=1;i<N;i++) {
			FullS = FullS | 1<<i;
		}
		tour.add(1);
		int tmpJ = 0;
		int tmpk = 1;
		int tmpS = FullS;
		while (tour.size()<N) {
			double minPath = Double.MAX_VALUE;
			int nodeT = bitMaps.get(tmpk);
			System.out.print("tmp J: "+nodeT+" child:");
			for (int child:clusters.get(nodeT)) {
				System.out.print(" "+child);
			}
			System.out.println("");
			for(int j=2;j<=N;j++) {
				if (!tour.contains(j)) {
					double value = A[tmpS][j]+getPath(j,tmpk);
//					System.out.println("J: "+j+" value "+value);
					if (minPath > value) {
						tmpJ = j;
						minPath = value;
					}
				}
			}

//			System.out.println("tmpS:"+Integer.toBinaryString(tmpS));
//			System.out.println("tmpS:"+Integer.toBinaryString(1 << tmpJ-1));
			tmpS = FullS - (1 << tmpJ-1);
//			System.out.println("tmpS:"+Integer.toBinaryString(tmpS));
			tmpk = tmpJ;
			
			tour.add(tmpJ);
		}
//		int Jreal = bitMaps.get(finalJ);
//		System.out.println("Final J: "+Jreal);
//		System.out.println("minPath: "+minPath);
		System.out.println("End");
	}

	private static Double setA2D(int S, int j) {
		// TODO Auto-generated method stub
		int S_j = S - (1 << j-1);
		String Sstr = Integer.toBinaryString(S);
//		String SJstr = Integer.toBinaryString(S_j);
//		System.out.println(Sstr);
//		System.out.println(SJstr);
		Double minValue = Double.MAX_VALUE;
        for (int i = 0; i < Sstr.length(); i++) {
        	char str1 = '1';
        	if (Sstr.charAt(i) == str1) {
        		int k = i+1;
        		if (k!=j) {
        			if (A[S_j][k] == Double.MAX_VALUE) continue;
        			Double value = A[S_j][k]+getPath(j,k);
        			if (minValue > value) {
        				minValue = value;
        			}
        		}
        	}
        }
		return minValue;
	}

	private static Double getPath(int j, int k) {
		// TODO Auto-generated method stub
		int jNew = bitMaps.get(j);
		int kNew = bitMaps.get(k);
		nodeXY nj = nodes.get(jNew-1);
		nodeXY nk = nodes.get(kNew-1);
		
		double dis_X = (nj.x - nk.x)*(nj.x - nk.x);
		double dis_Y = (nj.y - nk.y)*(nj.y - nk.y);
		double cost = Math.sqrt(dis_X+dis_Y);
		
		return cost;
	}

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
		if (node1<node2) {
			clusters.remove(node2);
			clusters.put(node1, nodes1);
			for(int node : nodes1) {
				nodeParent.put(node,node1);
			}
		}else {
			clusters.remove(node1);
			clusters.put(node2, nodes1);
			for(int node : nodes1) {
				nodeParent.put(node,node2);
			}
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
