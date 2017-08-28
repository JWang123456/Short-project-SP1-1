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
				if(!visited.containsKey(edge.to) || !visited.get(edge.to)) {
					distance.put(edge.to, distance.containsKey(edge.from) ? distance.get(edge.from) : 0 + edge.weight);
					queue.offer(edge.to);
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
			List<Edge> edges = g.directed ? cur.revAdj : cur.adj;
			for(Edge edge: edges) {
				if(!visited.containsKey(edge.from) || !visited.get(edge.from)) {
					distance.put(edge.from, distance.containsKey(edge.to) ? distance.get(edge.to) : 0 + edge.weight);
					LinkedList<Graph.Vertex> list = null;
					if(path.containsKey(edge.to)) {
						list = path.get(edge.to);
					} else {
						list = new LinkedList<>();
					}
					list.add(edge.from);
					path.put(edge.from, list);
					queue.offer(edge.from);
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
		path.get(p).add(0, u);
		return path.get(p);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("graph.in"));
		Graph g = Graph.readDirectedGraph(in);
		LinkedList<Graph.Vertex> path = diameter(g);
		System.out.println("In directed graph, the longest path is: " + path);
		
		Scanner uin = new Scanner(new File("ugraph.in"));
		Graph ug = Graph.readGraph(uin);
		LinkedList<Graph.Vertex> upath = diameter(ug);
		System.out.println("In unirected graph, the longest path is: " + upath);
	}
}
