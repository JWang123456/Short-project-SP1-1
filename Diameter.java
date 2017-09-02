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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import cs6301.g18_2.Graph.Vertex;

public class Diameter 
{
    static LinkedList<Graph.Vertex> diameter(Graph graph)  //Walk-around to use Signatures provide by professor
    {
        int V = graph.n;          //number of vertex.
        int i = (int)(Math.random()*V + 1);  //random chosse a vertex as start point.
        Vertex vertex = new Vertex(i);
        return diameter(graph, vertex);
    }
    
    static LinkedList<Vertex> diameter(Graph g, Vertex v)
    {
        Bfs b = new Bfs();   
        Vertex front = b.bfs(g,v);   //Do BFS from v, get 'front' vertex.
        Vertex end = b.bfs(g,front);  //Do BFS from front, get 'end' vertex.
        
        LinkedList<Vertex> longest = path(front,end); //path from front to end is the diameter path.
        // the longest path is from front to end.
        return longest;
    }
   
    static LinkedList<Vertex> path(Vertex front, Vertex end)  //the path form start to end
    {
        LinkedList<Vertex> L = new  LinkedList<>();  //build a LinkedList.
        L.add(front);      //THIS PART NEED HELP! how to find the path form front to end and store it in the LinkedList L?
        L.add(end);
        
        return L; 
    }
    
    // Driver method
    public static void main(String args[])
    {
        Scanner in;             //This part need help! 'input file' part need to be done.
        in = new Scanner(System.in);
        Graph g = Graph.readGraph(in);
        Diameter.diameter(g);
    }
}

