package algorithmsCouese.Course4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TSPnn {
	public static class nodeXY {
		public double x;
		public double y;
		public nodeXY(int name,double x,double y) {
			this.x=x;
			this.y=y;
		}
	} 
	
	public static class neiCost {
		public double distance;
		public int index;
		public neiCost(double distance,int index) {
			this.distance=distance;
			this.index=index;
		}
	} 
	
	private static class costComparator implements Comparator<neiCost>{
		
		public int compare (neiCost nei1,neiCost nei2) {
			if (nei1.distance > nei2.distance)
				return 1;
			else if (nei1.distance < nei2.distance)
				return -1;
			else if (nei1.index > nei2.index)
				return 1;
			else if (nei1.index < nei2.index)
				return -1;
			return 0;
		}
	}
	private static File file = new File("src/algorithmsCouese/Course4/nn.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/input_simple_70_40000.txt");
	
	private static ArrayList<nodeXY> nodesOri = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		initialNodes();
		int N = nodesOri.size();
		boolean[] visited = new boolean[N];
		visited[0]=true;
		
		ArrayList<Integer> tour = new ArrayList<>();
		tour.add(0);
		double tsp = 0.0;
		int indexNow = 0;
		while (checkVis(visited)) {
			
//			System.out.println("indexNow = "+indexNow);
			PriorityQueue<neiCost> neighbors = new PriorityQueue<neiCost>(N,new costComparator());
			for (int i=1;i<N;i++) {
				if (!visited[i]) {
					double dis = getPath(indexNow,i,nodesOri);
					neiCost neiCo = new neiCost(dis,i);
					neighbors.add(neiCo);
				}
			}
			neiCost minPathNode = neighbors.poll();
			indexNow = minPathNode.index;
			visited[indexNow]=true;
			tour.add(indexNow);
			tsp = tsp + minPathNode.distance;
			if (!checkVis(visited)) {
				double finalDis = getPath(0,indexNow,nodesOri);
				tsp = tsp + finalDis;
			}
		}
		System.out.println("Path = ");
		for (int x : tour) {
			System.out.print(" "+x);
		}
		System.out.println("");
		System.out.println("Dis = "+tsp);
		System.out.println("End");
	}
	private static boolean checkVis(boolean[] visited) {
		// TODO Auto-generated method stub
		for (int i=0;i<visited.length;i++) {
			if (visited[i]==false) return true;
		}
		return false;
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
				String xcor = vertices[1];
				String ycor = vertices[2];
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
	private static Double getPath(int j, int k, ArrayList<nodeXY> nodes) {
		// TODO Auto-generated method stub
//		System.out.println("j "+j+" k "+k);
		
		nodeXY nj = nodes.get(j);
		nodeXY nk = nodes.get(k);
		
		double dis_X = (nj.x - nk.x)*(nj.x - nk.x);
		double dis_Y = (nj.y - nk.y)*(nj.y - nk.y);
		double cost = Math.sqrt(dis_X+dis_Y);
		
		return cost;
	}
}
