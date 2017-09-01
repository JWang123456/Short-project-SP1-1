package cs6301.g18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

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
		pathMap.get(end).add(0, start);
		return end;
	}
	
}
