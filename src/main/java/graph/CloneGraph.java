package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        HashSet<UndirectedGraphNode> allNodes = new HashSet<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> newGraph = new HashMap<Integer, UndirectedGraphNode>();

        List<UndirectedGraphNode> cur;
        List<UndirectedGraphNode> next = new ArrayList<UndirectedGraphNode>();
        next.add(node);
        allNodes.add(node);
        newGraph.put(node.label, new UndirectedGraphNode(node.label));

        // 1. 遍历原图所有的节点，根据原图的节点创建新的节点放入到newGraph里
        while (!next.isEmpty()) {
            cur = new ArrayList<UndirectedGraphNode>(next);
            next.clear();
            for (UndirectedGraphNode curNode : cur) {
                for (UndirectedGraphNode neighborNode : curNode.neighbors) {
                    if (!allNodes.contains(neighborNode)) {
                        allNodes.add(neighborNode);
                        next.add(neighborNode);
                        newGraph.put(neighborNode.label, new UndirectedGraphNode(neighborNode.label));
                    }
                }
            }
        }

        // 2. 根据原图中的所有节点，把newGraph里的所有节点连接起来
        for (UndirectedGraphNode oldNode : allNodes) {
            UndirectedGraphNode newNode = newGraph.get(oldNode.label);
            for (UndirectedGraphNode neighbor : oldNode.neighbors) {
                newNode.neighbors.add(newGraph.get(neighbor.label));
            }
        }
        return newGraph.get(node.label);
    }
}
