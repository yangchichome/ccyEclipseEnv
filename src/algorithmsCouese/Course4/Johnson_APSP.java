package algorithmsCouese.Course4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


public class Johnson_APSP {
	
	public static class edge {
		public Integer start;
		public Integer end;
		public Integer cost;
		
		public edge (Integer start,Integer end,Integer cost) {
			
			this.start=start;
			this.end=end;
			this.cost=cost;
		}
	}
	public static class edgeTo {
		public Integer to;
		public Integer cost;
		
		public edgeTo (Integer to,Integer cost) {
			
			this.to=to;
			this.cost=cost;
		}
	}
	public static class nodeValue {
		public int node;
		public int cost;
		
		public nodeValue (int node,int cost) {
			
			this.node=node;
			this.cost=cost;
		}
	}
//	private static File file = new File("src/algorithmsCouese/Course4/large.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/input_random_10_8.txt");
	private static File file = new File("src/algorithmsCouese/Course4/g3.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/case4.txt");
	private static HashSet<Integer> V = new HashSet<>();
	
	private static int verticeSize ;
	private static ArrayList<edge> GraphPlus = new ArrayList<>();
	private static ArrayList<edge> Graph = new ArrayList<>();
	private static HashMap<Integer,ArrayList<edgeTo>> edgeTos = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setMap();
		
		// check negative cycle by TheBellmanFord
		Object[] bellAns = TheBellmanFord1D.main(GraphPlus,V,verticeSize);
		if(!(boolean) bellAns[2])return;
		int[] d = (int[]) bellAns[0];
		
		//For each e = (u,v) ,define Ce' = Ce + Pu - Pv
		for (edge edge0: Graph) {
			int u = edge0.start;
			int v = edge0.end;
			int puv = edge0.cost;
			int puvNew = puv + d[u] - d[v];
//			System.out.println(" u:"+u+" v:"+v+" puv:"+puv+" pu:"+p[u]+" pv"+p[v]+" puvNew:"+puvNew);
			// set edgeTo data
			ArrayList<edgeTo> edgeTo0s = new ArrayList<>();
			if (edgeTos.containsKey(u)) {
				edgeTo0s = edgeTos.get(u);
			}
			edgeTo edgeTo0 = new edgeTo(v,puvNew);
			edgeTo0s.add(edgeTo0);
			edgeTos.put(u, edgeTo0s);
		}
		//recall Dijkstra
		V.remove(0);
		int pathMinAll = Integer.MAX_VALUE;
		ArrayList<Integer> pathEnd = new ArrayList<>();
		for (int start:V) {
			Object[] results = dijkstra(edgeTos, verticeSize,start );
			Object[] ans = findShortestPath(results,start,d);
			int pathMin = (int) ans[0];
			@SuppressWarnings("unchecked")
			ArrayList<Integer> path = (ArrayList<Integer>) ans[1];
			if (pathMinAll > pathMin) {
				pathMinAll = pathMin;
				pathEnd.clear();
				for (int i=0;i<path.size();i++) {
					pathEnd.add(path.get(i));
				}
			}
		}
		System.out.println(" SSSP = "+pathMinAll);
		System.out.println(" path Size: "+pathEnd.size());
		System.out.println(" path : ");
		for (int i=0;i<pathEnd.size();i++) {
			System.out.print(" "+pathEnd.get(i));
		}
		System.out.println(" End");
	}
	private static int getPath(int u) {
		// TODO Auto-generated method stub
		return 0;
	}
	private static void setMap() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read a line of text from the file
			String line = input.readLine();
			V.add(0);
			while (line != null) {
				// Split the line of text Longo a vector of Strings
				String[] vertices = line.split(" ");
				if (vertices.length == 2) {
					Integer nodes = Integer.parseInt(vertices[0]);
//					Integer v = Integer.parseInt(vertices[1]);
					verticeSize = nodes+1;
					for (int i=1;i<=nodes;i++) {
						edge esNew = new edge(0,i,0);
						GraphPlus.add(esNew);
					}
					line = input.readLine();
					continue;
				}else {
					// get edge
					Integer e1 = Integer.parseInt(vertices[0]);
					Integer e2 = Integer.parseInt(vertices[1]);
					Integer cost = Integer.parseInt(vertices[2]);
					
					edge es = new edge(e1,e2, cost);
					GraphPlus.add(es);
					Graph.add(es);
					
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
	public static Object[] dijkstra(HashMap<Integer,ArrayList<edgeTo>> g,int n,int s) {
		boolean[] vis = new boolean[n+1];
		int[] prev = new int[n];
		int[] dist = new int[n];
		for (int i=0;i<dist.length;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[s]=0;
		PriorityQueue<nodeValue> nodeValues = new PriorityQueue<nodeValue>(4000,new nodeCompare());		
		nodeValue node0 = new nodeValue(s,0);
		nodeValues.add(node0);
		while (nodeValues.size()!=0) {
			nodeValue nodeV = nodeValues.poll();
			int index = nodeV.node;
			int minvalue = nodeV.cost;
			vis[index] = true;
			if (dist[index] < minvalue) continue;
			if (!g.containsKey(index)) continue;
			for (edgeTo edge:g.get(index)) {
				if (vis[edge.to]) continue;
				int newDist = dist[index] + edge.cost;
				if (newDist < dist[edge.to]) {
					prev[edge.to]=index;
					dist[edge.to]=newDist;
					nodeValue nodeE = new nodeValue(edge.to,newDist);
					nodeValues.add(nodeE);
				}
			}
		} 
		Object[] result = new Object[2];
		result[0] = dist;
		result[1] = prev;
		
		return result;
	}
	public static class nodeCompare implements Comparator<nodeValue>{
		public int compare (nodeValue s1,nodeValue s2) {
			if (s1.cost > s2.cost) {
				return 1;
			}
			else if (s1.cost < s2.cost) {
				return -1;
			}
			return 0;
		}
	}
	public static Object[] findShortestPath(Object[] result, int s, int[] p) {
		int[] dist = (int[]) result[0];
		int[] prev = (int[]) result[1];
		int Index = 0;
		int length = 0;
		int pathMin = Integer.MAX_VALUE;
		ArrayList<Integer> path = new ArrayList<>();
		ArrayList<Integer> pathEnd = new ArrayList<>();
//		System.out.println("from:"+s);
		for (int to : V) {
			path.clear();
			if (to==s) continue;
			
			if (dist[to]==Integer.MAX_VALUE) {
				length = Integer.MAX_VALUE;
			}else {
				length = dist[to]-p[s]+p[to];
			}
			
//			System.out.println(" length = "+length);
//			System.out.println(s+"-"+to+"= "+length+" p_u "+p[s]+" p_v "+p[to]);
			Index = prev[to];
//			System.out.print(" to:"+to+" path:"+Index);
			if (Index==0) {
//				System.out.println("");
				continue;
			}
			while (Index!=s) {
				path.add(Index);
				Index = prev[Index];
//				System.out.print(" "+Index);
			}

			if (pathMin>length) {
				pathMin=length;
//				System.out.println(s+"-"+to+"="+length+"p_u"+p[s]+"p_v"+p[to]);
				pathEnd.clear();
				pathEnd.add(s);
				for (int i=path.size()-1;i>=0;i--) {
					pathEnd.add(path.get(i));
				}
				pathEnd.add(to);
			}
		}
		Object[] ans = new Object[2];
		ans[0] = pathMin;
		ans[1] = pathEnd;
		return ans;
	}
}
//Bellmanford 	: 	https://www.youtube.com/watch?v=pSqmAO-m7Lk
//John 			:	https://www.youtube.com/watch?v=hl3cgWwJS7I
