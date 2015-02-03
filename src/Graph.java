import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.LinkedList;

// -------------------------------------------------------------------------
/**
 *  Class used to represent an undirected graph
 *
 *  @author Mack Hasz (mrh17)
 *  @version Jul 29, 2014
 */
public class Graph
{
    // linked list representing the  vertices and edges
    private LinkedList<Integer> nodes[];
    private LinkedList<Integer> left;
    private LinkedList<Integer> right;
    private String[] vertexNames;

    // ----------------------------------------------------------
    /**
     * Create a new Graph object.
     * @param n linked list representing the  vertices and edges
     * @param names the names of the vertices
     */
    public Graph(LinkedList<Integer>[] n, String[] names) {
        nodes = n;
        left = new LinkedList<Integer>();
        right = new LinkedList<Integer>();
        vertexNames = names;
    }

    // ----------------------------------------------------------
    /**
     * Checks the graph to see if it bipartite or not.
     * @return true if bipartite false if not
     */
    public boolean testBipartite () {

        // clear left and right
        left.clear();
        right.clear();

        LinkedList<Integer> path = buildPath();

        // buildpath in bredth first order
        int[] pathArray = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            pathArray[i] = path.get(i);
        }

        // traverse all verticies and check its neighbors
        for (int i : pathArray) {
            Iterator<Integer> iterator = nodes[i].iterator();

            System.out.println("At vertex " + vertexNames[i]);
            if (left.contains(i)) {
                System.out.println(vertexNames[i] + " is in the left set");
                while (iterator.hasNext()) {
                    Integer temp = iterator.next();

                    System.out.println("Checking neighbor " + vertexNames[temp]  +
                                        " for contradiction");

                    if (left.contains(temp)) {
                        System.out.println("Contradiction found!");
                        return false;
                    } else if (right.contains(temp)) {
                        System.out.println(vertexNames[temp] + " is in the right set as it should be");
                    } else {
                        System.out.println(vertexNames[temp] + " does not belong to a set yet, " +
                            "adding it to the right");
                        right.add(temp);
                    }
                }
            } else if (right.contains(i)) {
                System.out.println(vertexNames[i] + " is in the right set");
                while (iterator.hasNext()) {
                    Integer temp = iterator.next();

                    System.out.println("Checking neighbor " + vertexNames[temp]  +
                        " for contradiction");

                    if (right.contains(temp)) {
                        System.out.println("Contradiction found!");
                        return false;
                    } else if (left.contains(temp)) {
                        System.out.println(vertexNames[temp] + " is in the left set as it should be");
                    } else {
                        System.out.println(vertexNames[temp] + " does not belong to a set yet, " +
                                                "adding it to the left");
                        left.add(temp);
                    }
                }
            } else {
                System.out.println(vertexNames[i] + " has not yet been added to a set");
                boolean flagL = false;
                boolean flagR = false;
                while (iterator.hasNext()) {
                    Integer temp = iterator.next();


                    if (left.contains(temp)) {
                        flagL = true;
                    }
                    if (right.contains(temp)) {
                        flagR = true;
                    }
                }

                iterator = nodes[i].iterator();

                if (flagL && flagR) {
                    return false;
                } else if (flagL) {
                    while (iterator.hasNext()) {
                        Integer temp = iterator.next();

                        if (!left.contains(temp)) {
                            left.add(temp);
                        }
                    }
                    right.add(i);
                    System.out.println(vertexNames[i] + " has been added to the right set " +
                        "and its neighbors to the left");
                } else if (flagR) {
                    while (iterator.hasNext()) {
                        Integer temp = iterator.next();

                        if (!right.contains(temp)) {
                            right.add(temp);
                        }
                    }
                    left.add(i);
                    System.out.println(vertexNames[i] + " has been added to the left set " +
                        "and its neighbors to the right");
                } else {
                    while (iterator.hasNext()) {
                        Integer temp = iterator.next();
                        right.add(temp);
                    }
                    left.add(i);
                    System.out.println(vertexNames[i] + " has been added to the left set " +
                        "and its neighbors to the right");
                }
            }
        }
        System.out.println("All vertices visited, final mapping:");

        System.out.print("Left:  [ ");
        for (Iterator<Integer> Liter = left.iterator() ; Liter.hasNext();) {
            System.out.print( vertexNames[Liter.next()] + " ");
        }
        System.out.println("]");

        System.out.print("Right: [ ");
        for (Iterator<Integer> Riter = right.iterator() ; Riter.hasNext();) {
            System.out.print( vertexNames[Riter.next()] + " ");
        }
        System.out.println("]");

        return true;
    }

    private LinkedList<Integer> buildPath() {
        LinkedList<Integer> path = new LinkedList<Integer>();
        PriorityQueue<Integer> line = new PriorityQueue<Integer>();

        path.add(0);
        line.add(0);

        while (path.size() != nodes.length) {
            // happens when the graph is comprised of
            // unconnected componetes like in G
            // so we find the first vertex that is not already in the path
            if (line.isEmpty()) {
                findFirst:
                for (int i = 0;i < nodes.length;i ++) {
                    Iterator<Integer> iter = nodes[i].iterator();

                    while (iter.hasNext()) {
                        Integer temp = iter.next();

                        if (!path.contains(temp)) {
                            path.add(temp);
                            line.add(temp);
                            break findFirst;
                        }
                    }
                }
                // still empty so we have vertices with no connections
                // so exit. Happens in graph G at vertex H
                if (line.isEmpty()) {
                    return path;
                }
            }

            Iterator<Integer> iterator = nodes[line.remove()].iterator();

            while (iterator.hasNext()) {
                Integer temp = iterator.next();

                if (!path.contains(temp)) {
                    path.add(temp);
                    line.add(temp);
                }
            }
        }
        return path;
    }
}
