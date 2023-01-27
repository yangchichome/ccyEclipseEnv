package algorithmsCouese.Course4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
	public static class nodeNeighbor {
		public int previous;
		public int next;
		public nodeNeighbor(int previous,int next) {
			this.previous=previous;
			this.next=next;
		}
	} 
	
//	private static File file = new File("src/algorithmsCouese/Course4/tsp.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/input_float_20_6.txt");
	private static File file = new File("src/algorithmsCouese/Course4/input_int_20_6.txt");
	private static Double[][] A;
	//Cluster
	private static HashMap<Integer,Set<Integer>> clusters = new HashMap<Integer,Set<Integer>>();
	private static HashMap<Integer,Integer> nodeParent = new HashMap<Integer,Integer>();
	private static PriorityQueue<edgeCost> edgeCosts = new PriorityQueue<edgeCost>(500,new costComparator());
	private static ArrayList<nodeXY> nodesOri = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		N = getSize();
		initialCluster();
		
		//do cluster
		while(clusters.size()>21) {
			edgeCost minCost = edgeCosts.poll();
			mergeCluster(minCost);
		}
		//set map for bitMask
		ArrayList<nodeXY> nodes = new ArrayList<>();
		HashMap<Integer,Integer> bitMaps = new HashMap<>();
		int k = 1;
		for(Integer key:clusters.keySet()) {
			bitMaps.put(k, key);
			nodes.add(nodesOri.get(key-1));
			k++;
		}
		
		ArrayList<Integer> tourOri = TSP(nodes);
		ArrayList<Integer> tourOriNew = nodeName(tourOri,bitMaps);
		HashMap<Integer,nodeNeighbor> neiOri = setNeighbor(tourOriNew);
		
		ArrayList<Integer> tourFinal = new ArrayList<Integer>();
		
		for (int i=0; i<tourOriNew.size(); i++) {
			int city = tourOriNew.get(i);
			if (!clusters.containsKey(city)) continue;
			
			Set<Integer> childs = clusters.get(city);
			
			int N = childs.size();
			if (N==1) {
				tourFinal.add(city);
			}else {
//				for (Integer node : childs) {
//					tourFinal.add(node);
//				}
				
				ArrayList<Integer> keys = new ArrayList<>();
				int precity = neiOri.get(city).previous;
				int precity2nd = neiOri.get(precity).previous;
				int nextcity = neiOri.get(city).next;
				int nextcity2nd = neiOri.get(nextcity).next;
				keys.add(precity2nd);
				keys.add(precity);
//				keys.add(city);
				for(Integer key : childs) {
					keys.add(key);
				}
				keys.add(nextcity);
				keys.add(nextcity2nd);
				
				ArrayList<nodeXY> subnode = new ArrayList<>();
				HashMap<Integer,Integer> bitMaps2 = new HashMap<>();
				
				int kk = 1;
				for(Integer key : keys) {
					bitMaps2.put(kk, key);
					subnode.add(nodesOri.get(key-1));
					kk++;
				}
				
				ArrayList<Integer> tourS2nd = TSP(subnode);
				ArrayList<Integer> tourS2ndNew = nodeName(tourS2nd,bitMaps2);
				
				int preIndex = tourS2ndNew.indexOf(precity);
				int nextIndex = tourS2ndNew.indexOf(nextcity);
				
				if (preIndex > nextIndex) {
					Collections.reverse(tourS2ndNew);
					for (int node:tourS2ndNew) {
						if (childs.contains(node))
							tourFinal.add(node);
					}
				}else {
					for (int node:tourS2ndNew) {
						if (childs.contains(node))
							tourFinal.add(node);
					}
				}
			}
		}

		double disAll = getPath(tourFinal.get(0),tourFinal.get(tourFinal.size()-1), nodesOri);
		for (int i=0;i<tourFinal.size()-1;i++) {
			int node1 = tourFinal.get(i);
			int node2 = tourFinal.get(i+1);
			double dis = getPath(node1,node2,nodesOri);
			disAll = disAll + dis;
		}
		System.out.println("disAll: "+disAll);
		
		System.out.print("path : ");
		for (int node: tourFinal) {
			System.out.print(" "+node);
		}

		System.out.println(" End");
	}

	private static HashMap<Integer, nodeNeighbor> setNeighbor(ArrayList<Integer> tourOriNew) {
	// TODO Auto-generated method stub
		HashMap<Integer, nodeNeighbor> neighbors = new HashMap<>();
		for (int i=0;i<tourOriNew.size();i++) {
			if (i==tourOriNew.size()-1){
				int previous = tourOriNew.get(i-1);
				int next = tourOriNew.get(0);
				nodeNeighbor nei = new nodeNeighbor(previous,next);
				neighbors.put(tourOriNew.get(i), nei);
			}else if (i==0){
				int previous = tourOriNew.get(tourOriNew.size()-1);
				int next = tourOriNew.get(i+1);
				nodeNeighbor nei = new nodeNeighbor(previous,next);
				neighbors.put(tourOriNew.get(i), nei);
			}else {
				int previous = tourOriNew.get(i-1);
				int next = tourOriNew.get(i+1);
				nodeNeighbor nei = new nodeNeighbor(previous,next);
				neighbors.put(tourOriNew.get(i), nei);
			}
		}
	return neighbors;
}

	private static ArrayList<Integer> nodeName(ArrayList<Integer> tours1, HashMap<Integer, Integer> bitMaps2) {
		ArrayList<Integer> tourNew = new ArrayList<>();
		for (int i=0;i<tours1.size();i++) {
			int n = tours1.get(i);
			tourNew.add(bitMaps2.get(n));
		}
		// TODO Auto-generated method stub
		return tourNew;
	}

	private static ArrayList<Integer> TSP(ArrayList<nodeXY> nodes) {
		//after cluster 
		int N = nodes.size();
		A = new Double[1 << N][N+1];
		Arrays.stream(A).forEach(a -> Arrays.fill(a, Double.MAX_VALUE));
		A[1][1]=0.0;

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
		        		A[S][j] = setA2D(S,j, nodes);
//		        		if (N==4) {
//		        			System.out.println("J: "+j+"value: "+A[S][j]);
//		        		}
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
			for(int j=2;j<=N;j++) {
				if (!tour.contains(j)) {
					double value = A[tmpS][j]+getPath(j,tmpk, nodes);
//					System.out.println("J: "+j+" value "+value);
					if (N==4) {
						System.out.println("J: "+j+" value "+value);
					}
					if (minPath > value) {
						tmpJ = j;
						minPath = value;
					}
				}
			}
			int jvalue = 1 << tmpJ-1;
			if (N==4) {
				System.out.println("tmpS:"+Integer.toBinaryString(tmpS)+"="+tmpS);
				System.out.println("tmpJ:"+Integer.toBinaryString(1 << tmpJ-1)+"="+jvalue);
			}
//			System.out.println("tmpS:"+Integer.toBinaryString(tmpS));
//			System.out.println("tmpS:"+Integer.toBinaryString(1 << tmpJ-1));
			tmpS = tmpS - jvalue;
			if (N==4) {
				System.out.println("tmpS:"+Integer.toBinaryString(tmpS)+"="+tmpS);
			}
//			System.out.println("tmpS:"+Integer.toBinaryString(tmpS));
			tmpk = tmpJ;
			
			tour.add(tmpJ);
		}		
		
		return tour;
	}
	
	private static Double setA2D(int S, int j, ArrayList<nodeXY> nodes) {
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
        			Double value = A[S_j][k]+getPath(j,k, nodes);
        			if (minValue > value) {
        				minValue = value;
        			}
        		}
        	}
        }
		return minValue;
	}

	private static Double getPath(int j, int k, ArrayList<nodeXY> nodes) {
		// TODO Auto-generated method stub
//		System.out.println("j "+j+" k "+k);
		
		nodeXY nj = nodes.get(j-1);
		nodeXY nk = nodes.get(k-1);
		
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
		
		bitMasks = generatebitMasks(1,b,m,name,bitMasks,n);
		
		return bitMasks;
	}
	private static HashSet<Integer> generatebitMasks(int i, int b, int m, int name,HashSet<Integer> bitMasks, int n) {
		// TODO Auto-generated method stub
		int N = n;
		if (name <= m-1) {
			if (i==N) {
				if (name==m-1)
					bitMasks.add(b);
			}else {
				//b[i] = 1
				int b1 = b | 1<<i;
				bitMasks = generatebitMasks(i+1,b1,m,name+1,bitMasks,n);
				
				int b0 = b;
				bitMasks = generatebitMasks(i+1,b0,m,name,bitMasks,n);
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
				for (nodeXY no : nodesOri) {
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
				
				nodesOri.add(node);
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
