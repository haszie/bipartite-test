# bipartite-test
Java program that determines whether a given graph is bipartite or not

The algorithm uses techniques similar to the ones we learned in class to test whether a graph is bipartite or not. The algorithm starts with any vertex and attempts to place this vertex and its neighbors into two distinct sets (Left and Right). It then jumps to this vertex’s neighbors using breadth first selection. It then checks to make sure this vertex does not conflict with its neighbors and that it can be added to either the left set or the right set with no problems. In other words this algorithm attempts to 2-color a given graph. It goes until a contradiction is found (not bipartite) or until there are no vertices left to color (bipartite).  The complexity of this algorithm is O(V^2). 

Graphical repesentations of the graphs tested can be found in the project description pdf
