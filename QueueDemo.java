/**
 * QueueDemo.java
 * A class that performs breadth first search on a graph, given a starting
 * vertex.
 * @param Graph and int.
 * @author Frederik Roenn Stensaeth.
 * Created 05.21.14
 */
public class QueueDemo {
	public static void breadthFirstSearch(Graph graph, int targetNode) {
		// Gets the total number of vertices.
		int vertices = graph.numVerts();
		Queue<Integer> queue = new LinkedQueueImplementation<Integer>();
		List<Integer> numOfEdges = new MysteryListImplementation<Integer>();
		// Makes the value of all the vertices -1, meaning they have not been 
		// visited them.
		for (int i = 0; i < vertices; i++) {
			numOfEdges.add(-1);
		}
		// Marks the target node as visited, we start here.
		numOfEdges.replace(targetNode, 0);
		queue.enqueue(targetNode);
		System.out.println("Starting vertex: " + queue.peek());
		int current;
		Iterable<Integer> neighbors;
		// While there is something in the queue, 
		// it will get all of the neighbors of the first item.
		while (!queue.isEmpty()) {
			current = queue.dequeue();
			int count = 0;
			System.out.println("Neighbors of vertex " + current + ":");
			for (Integer neighbor : graph.getNeighbors(current)) {
				// Checks if the neighbor has been visited. Marks the vertex
				// as visited.
				if (numOfEdges.at(neighbor) == -1) {
					numOfEdges.replace(neighbor, numOfEdges.at(current) + 1);
					queue.enqueue(neighbor);
					System.out.printf("%d\n", neighbor);
				} else {
					System.out.printf("%d (already visited)\n", neighbor);
				}
				count++;
			}
			if(count == 0) {
				System.out.println("No neighbors.");
			}
		}
	}

	public static void main(String[] args) {
		// Creates five graphs to test breadth first search on.
		// Looks like a kite.
		System.out.print("\nTest1:\n");
		UnweightedGraph test;
		test = new MysteryUnweightedGraphImplementation(false, 9);
		test.addEdge(0, 1);
		test.addEdge(1, 2);
		test.addEdge(2, 3);
		test.addEdge(3, 0);
		test.addEdge(0, 5);
		test.addEdge(6, 7);
		test.addEdge(6, 4);
		test.addEdge(4, 8);
		breadthFirstSearch(test, 0);

		// Looks like a straight line.
		System.out.print("\nTest2:\n");
		UnweightedGraph test2;
		test2 = new MysteryUnweightedGraphImplementation(false, 9);
		test2.addEdge(0, 1);
		test2.addEdge(1, 2);
		test2.addEdge(2, 3);
		test2.addEdge(3, 4);
		test2.addEdge(4, 5);
		test2.addEdge(5, 6);
		test2.addEdge(6, 7);
		test2.addEdge(7, 8);
		breadthFirstSearch(test2, 0);

		// Looks like a smaller square within a bigger square.
		System.out.print("\nTest3:\n");
		UnweightedGraph test3;
		test3 = new MysteryUnweightedGraphImplementation(false, 8);
		test3.addEdge(0, 1);
		test3.addEdge(0, 2);
		test3.addEdge(0, 4);
		test3.addEdge(4, 6);
		test3.addEdge(5, 4);
		test3.addEdge(5, 2);
		test3.addEdge(2, 3);
		test3.addEdge(3, 7);
		test3.addEdge(3, 1);
		test3.addEdge(1, 6);
		test3.addEdge(6, 7);
		test3.addEdge(7, 5);
		breadthFirstSearch(test3, 0);

		// Looks like a binary tree.
		System.out.print("\nTest4:\n");
		UnweightedGraph test4;
		test4 = new MysteryUnweightedGraphImplementation(false, 15);
		test4.addEdge(0, 1);
		test4.addEdge(0, 2);
		test4.addEdge(1, 3);
		test4.addEdge(1, 4);
		test4.addEdge(2, 5);
		test4.addEdge(2, 6);
		test4.addEdge(3, 7);
		test4.addEdge(3, 8);
		test4.addEdge(4, 9);
		test4.addEdge(4, 10);
		test4.addEdge(5, 11);
		test4.addEdge(5, 12);
		test4.addEdge(6, 13);
		test4.addEdge(6, 14);
		breadthFirstSearch(test4, 0);

		// Looke like a bird's foot, with a lonely vertex.
		System.out.print("\nTest5:\n");
		UnweightedGraph test5;
		test5 = new MysteryUnweightedGraphImplementation(false, 5);
		test5.addEdge(0, 1);
		test5.addEdge(0, 2);
		test5.addEdge(0, 3);
		breadthFirstSearch(test5, 4);
	}
}