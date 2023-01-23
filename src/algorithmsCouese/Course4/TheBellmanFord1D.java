package algorithmsCouese.Course4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import algorithmsCouese.Course4.Johnson_APSP.edge;

public class TheBellmanFord1D {
	
	public static Object[] main(ArrayList<edge> graph,HashSet<Integer> v2, int verticeSize) {
		// TODO Auto-generated method stub
		int ilen = verticeSize;
		int[] d = new int[ilen];
		int[] p = new int[ilen];
		boolean check = true;
		for(int i=1;i<ilen;i++) {
			d[i]= Integer.MAX_VALUE;
		}
		
		//Run BellmanFord
		for(int i=0;i<ilen;i++) {
//			System.out.println(" i:"+i);
			for ( edge edge : graph ) {
				int u = edge.start;
				int v = edge.end;
				int du = d[u];
				int dv = d[v];
				int Wuv = edge.cost;
//				System.out.println("u:"+u+" v:"+v+" du:"+du+" dv:"+dv+" Wuv:"+Wuv);
				if ( dv > (du+Wuv)){
					if (du==Integer.MAX_VALUE) {
						continue;
					}
					if (i==ilen-1) {
						System.out.println("change in final iteration negative Cycle exist");
						check = false;
					}
					d[v]=du+Wuv;
					p[v]=u;
				}
			}
			
		}
		Object[] bell = new Object[3];
		bell[0]=d;
		bell[1]=p;
		bell[2]=check;
		return bell;
	}
}
