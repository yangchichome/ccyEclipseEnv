package algorithmsCouese.Course4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import algorithmsCouese.Course4.Johnson_APSP.edge;

public class DijkstraCommon {

	public static HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
	public static HashMap<Integer, ArrayList<Integer>> prev = new HashMap<Integer, ArrayList<Integer>>();
//	public static File file = new File("src/algorithmsCouese/Course2/dijkstraData.txt");
//	public static ArrayList<Integer> vertices = new ArrayList<>();
	public static boolean[] explored;
	public static Boolean getminLen = false;

	public static void main(HashSet<Integer> v,ArrayList<edge> Graph) throws IOException {
		// TODO Auto-generated method stub
//		vertices = getvertices();
		explored = new boolean[v.size() + 1];
		explored[0] = true;
		dist.put(1,0);
		for (Integer node: v) {
			if (node != 1) {
				dist.put(node,Integer.MAX_VALUE);
				ArrayList<Integer> preInit = new ArrayList<>();
				prev.put(node,preInit);
			}
		}

		while (checkExp()) {
			Integer node = getminNode();
			HashMap<Integer, Integer> edges = getEdges(node,Graph);
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
//			Integer[] PA2 = new Integer[] {7,37,59,82,99,115,133,165,188,197};
//			boolean contains = Arrays.stream(PA2).anyMatch(set.getKey()::equals);
//			if (contains) {
				System.out.println("key : " + set.getKey()+"; dist : "+set.getValue()+"; path : "+prev.get(set.getKey()));
//			}
		}
		System.out.println("End : ");
	}

	private static HashMap<Integer, Integer> getEdges(Integer verIndex, ArrayList<edge> graph) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> edges = new HashMap<Integer, Integer>();
		for (edge edge0:graph) {
			int start = edge0.start;
			int end = edge0.end;
			int path = edge0.cost;
			if (start == verIndex) {
				//	System.out.println("Edge start : "+verIndex);
				edges.put(end, path);
			}
		}
		return edges;
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

	private static boolean checkExp() {
		// TODO Auto-generated method stub

		for (boolean index : explored) {

			if (!index) {
				return true;
			}
		}
		return false;
	}

}
