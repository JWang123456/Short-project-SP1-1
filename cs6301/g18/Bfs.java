package cs6301.g18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import cs6301.g18.Graph.Edge;
import cs6301.g18.Graph.Vertex;

public class Bfs {
	
	Graph g;
	HashMap<Vertex, Boolean> visited = new HashMap<>();
	HashMap<Vertex, LinkedList<Graph.Vertex>> pathMap = new HashMap<>();
	Queue<Vertex> queue = new LinkedList<>();

	public Bfs(Graph g) {
		this.g = g;
		this.visited = new HashMap<>();
		this.pathMap = new HashMap<>();
		this.queue = new LinkedList<>();
	}
	
	public Vertex bfs(Vertex start) {
		Vertex end = null;
		Vertex cur = null;
		queue.offer(start);
		while(!queue.isEmpty()) {
			cur = queue.poll();
			visited.put(cur, true);
			List<Edge> edges = cur.adj;
			for(Edge edge: edges) {
				if(!visited.containsKey(edge.otherEnd(cur)) || !visited.get(edge.otherEnd(cur))) {
					visited.put(edge.otherEnd(cur), true);
					//Use pathMap to record path from starting point to current point (starting point not included)
					LinkedList<Graph.Vertex> list = null;
					if(pathMap.containsKey(cur)) {
						list = new LinkedList<>(pathMap.get(cur));
					} else {
						list = new LinkedList<>();
					}
					list.add(edge.otherEnd(cur));
					pathMap.put(edge.otherEnd(cur), list);
					queue.offer(edge.otherEnd(cur));
				}	
			}
			
		}
		end = cur;
		//Add starting point to path
		pathMap.get(end).add(0, start);
		return end;
	}
	
}
