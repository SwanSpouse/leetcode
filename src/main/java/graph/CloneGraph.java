package graph;

// TODO
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        return newNode;
    }
}
