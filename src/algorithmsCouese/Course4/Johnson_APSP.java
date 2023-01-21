package algorithmsCouese.Course4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	private static File file = new File("src/algorithmsCouese/Course4/input_random_1_2.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/g3.txt");
//	private static File file = new File("src/algorithmsCouese/Course4/case2.txt");
	private static HashSet<Integer> V = new HashSet<>();
	private static int verticeSize ;
	private static ArrayList<edge> Graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setMap();
		boolean SSSP = TheBellmanFord1D.main(Graph,V,verticeSize);
		
		System.out.println("SSSP: "+SSSP);
		System.out.println("End");
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
						Graph.add(esNew);
					}
					line = input.readLine();
					continue;
				}else {
					// get edge
					Integer e1 = Integer.parseInt(vertices[0]);
					Integer e2 = Integer.parseInt(vertices[1]);
					Integer cost = Integer.parseInt(vertices[2]);
					
					edge es = new edge(e1,e2, cost);
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
}
