/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs6301.g18_2;

/**
 *
 * @author Gaojie Wang
 */

import java.util.LinkedList;

import cs6301.g18_2.Graph.Edge;
import cs6301.g18_2.Graph.Vertex;

public class Bfs {
    Graph graph;
    Vertex start;
    Vertex u;
    Vertex bfs(Graph g, Vertex v)
    {
        graph = g;
        start = v;
        int numV = graph.n;   //number of vertex in graph
        int startV = start.name; //name of start vertex
           
        boolean[] visited = new boolean[numV];  // build a boolean array, mark all the vertices as not visited(By default set as false) 

        LinkedList<Vertex> queue = new LinkedList<>();  // Create a vertex queue for BFS
    
        visited[startV] = true;   // Mark the current node as visited and enqueue it
        queue.add(start);
        
        while (!queue.isEmpty())    
        {
            u = queue.poll();          // Dequeue a vertex from queue. the last vertex dequeue from queue is the vertex we are looking for(maximum distance).
    
            for(Edge e : u)     //go through every edge of vertex u.
            {
                Vertex s = e.otherEnd(u);   //find other end of u.
              
                if(!visited[s.name]) 
                {
                    visited[s.name] = true;    //mark s as visited and add to queue.
                    queue.add(s);
                }
            }
        }
        return u;   //Bfs finally return the maximum distance vertex form start.
    }
}


