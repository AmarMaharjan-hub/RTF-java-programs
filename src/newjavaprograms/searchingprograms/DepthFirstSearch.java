package newjavaprograms.searchingprograms;

import netscape.javascript.JSUtil;

import java.util.*;

public class DepthFirstSearch {

    int nodes;

    LinkedList<Integer> adjacentNodeList[];

    public DepthFirstSearch(int nodes) {
        this.nodes = nodes;
        adjacentNodeList = new LinkedList[nodes];
        for(int i=0; i<nodes; i++){
            adjacentNodeList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        adjacentNodeList[source].add(destination);
        adjacentNodeList[destination].add(source);
    }

    public List<Integer> traverse(int root){

        boolean visited[] = new boolean[nodes];

        List<Integer> path = new ArrayList<>();

        Stack<Integer> stack = new Stack();

        visited[root] = true;
        path.add(root);

        Iterator<Integer> rootAdjacent = adjacentNodeList[root].listIterator();
        while(rootAdjacent.hasNext()){
            int neighbor = rootAdjacent.next();
            if(!visited[neighbor]){
                stack.push(neighbor);
                visited[neighbor] = true;
//                path.add(neighbor);
            }
        }
//        System.out.println("stack:"+stack.size());

        while(!stack.isEmpty()){
            int stackTop = stack.pop();
//            System.out.println(stackTop);
            path.add(stackTop);
            Iterator<Integer> adjacentNode = adjacentNodeList[stackTop].listIterator();
            while(adjacentNode.hasNext()){
                int neighbor = adjacentNode.next();
                if(!visited[neighbor]){
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }

        }
//        System.out.println(path);
//        System.out.println(Arrays.toString(adjacentNodeList));

        return path;

    }

    public static void main(String[] args) {
        DepthFirstSearch graph1 = new DepthFirstSearch(7);

//        Defining the edge relations of the nodes.
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(1,3);
        graph1.addEdge(1,4);
        graph1.addEdge(2,5);
        graph1.addEdge(2,6);

//        graph1.traverse(0);
        System.out.println(graph1.traverse(0));

        System.out.println();

        DepthFirstSearch graph2 = new DepthFirstSearch(5);
        graph2.addEdge(0,1);
        graph2.addEdge(0,2);
        graph2.addEdge(1,2);
        graph2.addEdge(1,3);
        graph2.addEdge(2,4);
        graph2.addEdge(4,3);

//        graph2.traverse(2);
        System.out.println(graph2.traverse(2));

        System.out.println();

        DepthFirstSearch g = new DepthFirstSearch(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

//        g.traverse(2);
        System.out.println(g.traverse(0));

    }

}
