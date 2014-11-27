import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Dijkstra {
	static class Vertex
	{
		int val;
		HashMap<Vertex, Integer> edges;
		int label;
		Vertex(int val)
		{
			this.val = val;
			label = Integer.MAX_VALUE;
		}
		public void addEdge(Vertex neighbour, int right)
		{
			if(edges==null)
			{
				edges = new HashMap<Vertex, Integer>();
			}
			edges.put(neighbour, right);
		}
	}
	public static int minDistance(Vertex start, Vertex target)
	{
		Comparator<Vertex> compare = new Comparator<Vertex>()
		{
			public int compare(Vertex v1, Vertex v2)
			{
				return v1.label-v2.label;
			}
		};
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(11, compare);
		start.label = 0;
		queue.offer(start);
		while(!queue.isEmpty())
		{
			Vertex cur = queue.poll();
			System.out.println(cur.val);
			for(Vertex v:cur.edges.keySet())
			{
				int distance = cur.label+cur.edges.get(v);
				if(distance<v.label)
				{
					v.label = distance;
					queue.offer(v);
				}
			}
		}
		return target.label;
	}
	public static void main(String[] args)
	{
		Vertex v1 = new Vertex(11);
		Vertex v2 = new Vertex(12);
		Vertex v3 = new Vertex(13);
		Vertex v4 = new Vertex(14);
		Vertex v5 = new Vertex(15);
		Vertex v21 = new Vertex(21);
		Vertex v22 = new Vertex(22);
		Vertex v23 = new Vertex(23);
		Vertex v24 = new Vertex(24);
		v1.addEdge(v2, 10);
		v1.addEdge(v3, 3);
		v2.addEdge(v3, 1);
		v2.addEdge(v4, 2);
		v3.addEdge(v2, 4);
		v3.addEdge(v4, 8);
		v3.addEdge(v5, 2);
		v4.addEdge(v5, 7);
		v5.addEdge(v4, 9);
//		v21.addEdge(v22, 1);
//		v22.addEdge(v23, 1);
//		v23.addEdge(v24, 1);
//		v2.addEdge(v22, 1+2);
		System.out.println(minDistance(v1, v4));
	}
}
