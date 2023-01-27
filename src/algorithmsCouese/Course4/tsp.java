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
import java.util.stream.IntStream;

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
	
	private static File file = new File("src/algorithmsCouese/Course4/tsp.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/input_float_81_22.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/input_int_90_24.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/testCase1.txt");
	private static Double[][] A;
	//Cluster
	private static ArrayList<nodeXY> nodesOri = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		N = getSize();
		initialNodes();
		
		// split map 
		int[] group1 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
		ArrayList<nodeXY> nodes1 = new ArrayList<>();
		HashMap<Integer,Integer> bitMaps1 = new HashMap<>();
		int k = 1;
		for(int index=0;index<group1.length;index++) {
			int key = group1[index];
			bitMaps1.put(k, key);
			nodes1.add(nodesOri.get(key-1));
			k++;
		}
		ArrayList<Integer> tour1 = TSP(nodes1);
		ArrayList<Integer> tour1Reset = nodeName(tour1,bitMaps1);
		for (int node: tour1Reset) {
			System.out.print(" "+node);
		}
		double dis1 = getPath(tour1Reset.get(0),tour1Reset.get(tour1Reset.size()-1), nodesOri);
		for (int i=0;i<tour1Reset.size()-1;i++) {
			int node1 = tour1Reset.get(i);
			int node2 = tour1Reset.get(i+1);
			double dis = getPath(node1,node2,nodesOri);
			dis1 = dis1 + dis;
		}
		System.out.println("	dis_2: "+dis1);
		
		System.out.println("");
		int[] group2 = new int[]{12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		ArrayList<nodeXY> nodes2 = new ArrayList<>();
		HashMap<Integer,Integer> bitMaps2 = new HashMap<>();
		k = 1;
		for(int index=0;index<group2.length;index++) {
			int key = group2[index];;
			bitMaps2.put(k, key);
			nodes2.add(nodesOri.get(key-1));
			k++;
		}
		ArrayList<Integer> tour2 = TSP(nodes2);
		ArrayList<Integer> tour2Reset = nodeName(tour2,bitMaps2);
		for (int node: tour2Reset) {
			System.out.print(" "+node);
		}
		double dis2 = getPath(tour2Reset.get(0),tour2Reset.get(tour2Reset.size()-1), nodesOri);
		for (int i=0;i<tour2Reset.size()-1;i++) {
			int node1 = tour2Reset.get(i);
			int node2 = tour2Reset.get(i+1);
			double dis = getPath(node1,node2,nodesOri);
			dis2 = dis2 + dis;
		}
		System.out.println("	dis_2: "+dis2);
		
		double dulpicateDis = getPath(12,13,nodesOri);
		double finalDis = dis1+dis2-2*dulpicateDis;
		System.out.println("");

		System.out.println(" finalDis: "+finalDis);
		System.out.println(" End");
	}

	private static ArrayList<Integer> insertNode(int city, ArrayList<Integer> tourOriNew, ArrayList<nodeXY> nodes) {
		// TODO Auto-generated method stub
		int index1 = 0;
		int index2 = 0;
		double minDis = Double.MAX_VALUE;
		for (int i=0 ;i< tourOriNew.size();i++) {
			double dis = getPath(city,tourOriNew.get(i), nodes);
			if( minDis > dis) {
				minDis = dis;
				index1 = i;
				index2 = index1;
			}
		}
		if (index1 > index2) {
			tourOriNew.add(index2, city);
		}else {
			tourOriNew.add(index1, city);
		}
		return tourOriNew;
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
			PriorityQueue<Integer> bitMasks = new PriorityQueue<Integer>() ;
			PriorityQueue<Integer> bitMasksDebug = new PriorityQueue<Integer>() ;
			bitMasks = getSet(m,N);
			bitMasksDebug = getSet(m,N);
//			System.out.println("get SebSet of M = "+m);
//			System.out.println("subSet size "+bitMasks.size());
//			for (int i=0;i<bitMasks.size();i++) {
//				int sub = bitMasksDebug.poll();
//				System.out.println(""+Integer.toBinaryString(sub)+"	"+sub);
//			}
			//for each set 1...n , set.contain(j) ,j != 1
			while (!bitMasks.isEmpty()) {
				int S = bitMasks.poll();
				String Sstr = reverseString(Integer.toBinaryString(S));
//				System.out.println("S***"+Sstr+"***");
		        for (int i = 1; i < Sstr.length(); i++) {
		        	char str1 = '1';
		        	if (Sstr.charAt(i) == str1) {
		        		int j = i+1;
//		        		System.out.println("[j]= "+j);
		        		A[S][j] = setA2D(S,j, nodes);
//		        		if (N==4) {
//	        			System.out.println("A[S]["+j+"]"+A[S][j]);
//	        			System.out.println("");
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
//					if (N==4) {
//						System.out.println("J: "+j+" value "+value);
//					}
					if (minPath > value) {
						tmpJ = j;
						minPath = value;
					}
				}
			}
			int jvalue = 1 << tmpJ-1;
//			System.out.println("tmpS:"+Integer.toBinaryString(tmpS)+"="+tmpS);
//			System.out.println("tmpJ:"+Integer.toBinaryString(1 << tmpJ-1)+"="+jvalue);
			tmpS = tmpS - jvalue;
//			System.out.println("tmpS:"+Integer.toBinaryString(tmpS)+"="+tmpS);
			tmpk = tmpJ;
			tour.add(tmpJ);
		}		
		
		return tour;
	}
	
	private static Double setA2D(int S, int j, ArrayList<nodeXY> nodes) {
		// TODO Auto-generated method stub
		int S_j = S - (1 << j-1);
		int J = (1 << j-1);
		String SstrDebug = Integer.toBinaryString(S);
		String Jstr = Integer.toBinaryString(J);
//		String SJstr = Integer.toBinaryString(S_j);
//		System.out.println("S  : "+SstrDebug);
//		System.out.println("J  : "+Jstr);
//		System.out.println("S-J: "+SJstr);
		Double minValue = Double.MAX_VALUE;
		String Sstr = reverseString(Integer.toBinaryString(S));
        for (int i = 0; i < Sstr.length(); i++) {
        	char str1 = '1';
        	if (Sstr.charAt(i) == str1) {
        		int k = i+1;
        		if (k!=j) {
//        			String kstr = Integer.toBinaryString(1 << k-1);
//        			System.out.println("K  : "+kstr);
        			if (A[S_j][k] == Double.MAX_VALUE) continue;
        			Double value = A[S_j][k]+getPath(j,k, nodes);
//        			System.out.println(" value: "+value);
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

	private static PriorityQueue<Integer> getSet(int m, int n) {
		// TODO Auto-generated method stub
		int b = 1;
		int name = 0;
		PriorityQueue<Integer> bitMasks = new PriorityQueue<Integer>();
		
		bitMasks = generatebitMasks(1,b,m,name,bitMasks,n);
		
		return bitMasks;
	}
	private static PriorityQueue<Integer> generatebitMasks(int i, int b, int m, int name,PriorityQueue<Integer> bitMasks, int n) {
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
	
	private static void initialNodes() throws IOException {
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
	public static String reverseString(String str){  
	    StringBuilder sb=new StringBuilder(str);  
	    sb.reverse();  
	    return sb.toString();  
	}  
}
