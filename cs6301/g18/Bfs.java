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
	
	static LinkedList<Graph.Vertex> diameter(Graph g) {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		HashMap<Vertex, Integer> distance = new HashMap<>();
		Vertex start = g.v[0];
		Queue<Vertex> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			Vertex cur = queue.poll();
			visited.put(cur, true);
			List<Edge> edges = cur.adj;
			for(Edge edge: edges) {
				if(!visited.containsKey(edge.otherEnd(cur)) || !visited.get(edge.otherEnd(cur))) {
					visited.put(edge.otherEnd(cur), true);
					distance.put(edge.otherEnd(cur), (distance.containsKey(cur) ? distance.get(cur) : 0) + edge.weight);
					queue.offer(edge.otherEnd(cur));
				}
				
			}
		}
		int max = 0;
		Vertex u = null;
		for(Vertex ver: distance.keySet()) {
			max = Math.max(max, distance.get(ver));
			if(max == distance.get(ver)) {
				u = ver;
			}
		}
		HashMap<Vertex, LinkedList<Graph.Vertex>> path = new HashMap<>();
		distance = new HashMap<>();
		visited = new HashMap<>();
		start = u;
		queue.offer(start);
		while(!queue.isEmpty()) {
			Vertex cur = queue.poll();
			visited.put(cur, true);
			List<Edge> edges = cur.adj;
			for(Edge edge: edges) {
				if(!visited.containsKey(edge.otherEnd(cur)) || !visited.get(edge.otherEnd(cur))) {
					visited.put(edge.otherEnd(cur), true);
					distance.put(edge.otherEnd(cur), (distance.containsKey(cur) ? distance.get(cur) : 0) + edge.weight);
					
					LinkedList<Graph.Vertex> list = null;
					if(path.containsKey(cur)) {
						list = new LinkedList<>(path.get(cur));
					} else {
						list = new LinkedList<>();
					}
					list.add(edge.otherEnd(cur));
					path.put(edge.otherEnd(cur), list);
					
					queue.offer(edge.otherEnd(cur));
				}
				
			}
		}
		int umax = 0;
		Vertex p = null;
		for(Vertex ver: distance.keySet()) {
			umax = Math.max(umax, distance.get(ver));
			if(umax == distance.get(ver)) {
				p = ver;
			}
		}
		path.get(p).add(0, start);
		return path.get(p);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner uin = new Scanner(new File("ugraph.in"));
		Graph ug = Graph.readGraph(uin);
		LinkedList<Graph.Vertex> upath = diameter(ug);
		System.out.println("In the graph, the longest path is: " + upath);
		
	}
}
