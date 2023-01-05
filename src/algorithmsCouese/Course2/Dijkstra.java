package algorithmsCouese.Course2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

	public static HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
	public static HashMap<Integer, ArrayList<Integer>> prev = new HashMap<Integer, ArrayList<Integer>>();
	public static File file = new File("src/algorithmsCouese/Course2/dijkstraData.txt");
	public static ArrayList<Integer> vertices = new ArrayList<>();
	public static boolean[] explored;
	public static Boolean getminLen = false;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		vertices = getvertices();
		explored = new boolean[vertices.size() + 1];
		explored[0] = true;
		dist.put(1,0);
		for (Integer node: vertices) {
			if (node != 1) {
				dist.put(node,Integer.MAX_VALUE);
				ArrayList<Integer> preInit = new ArrayList<>();
				prev.put(node,preInit);
			}
		}

		while (checkExp()) {
			Integer node = getminNode();
			HashMap<Integer, Integer> edges = getEdges(node);
			for (Map.Entry<Integer, Integer> set : edges.entrySet()) {
				Integer edge = set.getKey();
				Integer oriLen = dist.get(set.getKey());
				Integer newLen = set.getValue()+dist.get(node);
				if (newLen < oriLen) {
					dist.put(edge, newLen);
					ArrayList<Integer> paths = new ArrayList<>();
					if (prev.get(node)==null || prev.get(node).isEmpty()) {
						paths.add(edge);
					} else {
						for (Integer x : prev.get(node)) {
							paths.add(x);
						}
						paths.add(edge);
					}
					prev.put(edge,paths);
				}
			}
		}
		System.out.println("End : ");

		for (Map.Entry<Integer, Integer> set : dist.entrySet()) {
			Integer[] PA2 = new Integer[] {7,37,59,82,99,115,133,165,188,197};
			boolean contains = Arrays.stream(PA2).anyMatch(set.getKey()::equals);
			if (contains) {
				System.out.println("key : " + set.getKey()+"; dist : "+set.getValue()+"; path : "+prev.get(set.getKey()));
			}
		}
		System.out.println("End : ");
	}

	private static Integer getminNode() {
		// TODO Auto-generated method stub
		Integer minnode = 0;
		Integer minnodeVal = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> set : dist.entrySet()) {
			if(minnodeVal > set.getValue() && !explored[set.getKey()]) {
				minnodeVal = set.getValue();
				minnode = set.getKey();
			}
		}
		explored[minnode] = true;
		return minnode;
	}

	private static HashMap<Integer, Integer> getEdges(Integer verIndex) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		HashMap<Integer, Integer> edges = new HashMap<Integer, Integer>();
		try {
			// Read a line of text from the file
			String line = input.readLine();
			while (line != null) {
				// Split the line of text into a vector of Strings
//		    	String[] vector = line.split(" ");
				String[] vector = line.split("\t");

				// get node and edge
				int tmpvertices = Integer.parseInt(vector[0]);

				if (tmpvertices == verIndex) {
//					System.out.println("Edge start : "+verIndex);
					for (int i = 1; i < vector.length; i++) {
						String[] pathLen = vector[i].split(",");
//						System.out.println(" get Edges : "+" Node : " + pathLen[0]+" distance : " + pathLen[1]);
						edges.put(Integer.valueOf(pathLen[0]), Integer.valueOf(pathLen[1]));
					}
				}
				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally

		return edges;
	}


	private static boolean checkExp() {
		// TODO Auto-generated method stub

		for (boolean index : explored) {

			if (!index) {
				return true;
			}
		}
		return false;
	}

	private static ArrayList<Integer> getvertices() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read a line of text from the file
			String line = input.readLine();
			while (line != null) {
				// Split the line of text into a vector of Strings
//		    	String[] vector = line.split(" ");
				String[] vector = line.split("\t");

				// get node and edge
				int tmpvertices = Integer.parseInt(vector[0]);

				vertices.add(tmpvertices);

				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally
		return vertices;
	}
}
