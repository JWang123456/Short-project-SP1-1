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
		HashMap<Vertex, Integer> distance = new HashMap<>();
		Vertex start = g.v[0];
		Queue<Vertex> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			Vertex cur = queue.poll();
			List<Edge> edges = cur.adj;
			for(Edge edge: edges) {
				distance.put(edge.to, distance.containsKey(edge.from) ? distance.get(edge.from) : 0 + edge.weight);
				queue.offer(edge.to);
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
		start = u;
		queue.offer(start);
		while(!queue.isEmpty()) {
			Vertex cur = queue.poll();
			List<Edge> edges = cur.adj;
			for(Edge edge: edges) {
				distance.put(edge.to, distance.containsKey(edge.from) ? distance.get(edge.from) : 0 + edge.weight);
				LinkedList<Graph.Vertex> list = null;
				if(path.containsKey(edge.from)) {
					list = path.get(edge.from);
				} else {
					list = new LinkedList<>();
				}
				list.add(edge.to);
				path.put(edge.to, list);
				queue.offer(edge.to);
			}
		}
		int umax = 0;
		Vertex p = null;
		for(Vertex ver: distance.keySet()) {
			max = Math.max(max, distance.get(ver));
			if(max == distance.get(ver)) {
				p = ver;
			}
		}
		return path.get(p);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("graph.in"));
	}
}
