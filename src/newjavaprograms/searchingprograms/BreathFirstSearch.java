package newjavaprograms.searchingprograms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BreathFirstSearch {

    int nodes;

    LinkedList<Integer> adjacentNodeList[];

    public BreathFirstSearch(int nodes) {
        this.nodes = nodes;
        adjacentNodeList = new LinkedList[nodes];
        for(int i=0; i<nodes; i++){
            adjacentNodeList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destinaiton){
        adjacentNodeList[source].add(destinaiton);
        adjacentNodeList[destinaiton].add(source);
    }

    public List traverse(int rootNode){

        boolean visited[] = new boolean[nodes];

        LinkedList<Integer> queue = new LinkedList<>();

        List<Integer> path = new ArrayList();

        queue.add(rootNode);
        visited[rootNode] = true;

        while(queue.size() != 0){
            int queueHead = queue.poll();
//            System.out.println(queueHead + " ");
            path.add(queueHead);
            Iterator<Integer> adjacentNode = adjacentNodeList[queueHead].listIterator();
            while(adjacentNode.hasNext()){
                int neighbour = adjacentNode.next();
//                System.out.println(visited[neighbour]);
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return path;
        //returns list not print
    }

    public static void main(String[] args) {
        System.out.println("Graph1:");
//        Defining the graph with no of nodes.
        BreathFirstSearch graph1 = new BreathFirstSearch(5);

//        Defining the edge relations of the nodes.
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(1,2);
        graph1.addEdge(1,3);
        graph1.addEdge(2,4);
        graph1.addEdge(4,3);

//        Traversing the graph with the root node
//        graph1.traverse(3);
        System.out.println(graph1.traverse(3).toString());

        System.out.println("\nGraph2:");
        //        Defining the graph with no of nodes.
        BreathFirstSearch graph2 = new BreathFirstSearch(7);

//        Defining the edge relations of the nodes.
        graph2.addEdge(0,1);
        graph2.addEdge(0,2);
        graph2.addEdge(1,3);
        graph2.addEdge(1,4);
        graph2.addEdge(2,5);
        graph2.addEdge(2,6);

//        Traversing the graph with the root node
//        graph2.traverse(0);
        System.out.println(graph2.traverse(0).toString());

    }
}
