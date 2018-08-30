package io.github.floyd.graph;

public class DijkstrasAlgorithm {
    // the graph
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    private static String findLowestCostNode(Map<String, Double> consts) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        // Go through each node
        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();
            // If it's the lowest cost so far and hasn't been processed yet...
            if (cost < lowestCost && !processed.contains(node.getKey())) {
                // ... set it as the new lowest-cost node.
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }

        return lowestCostNode;
    }

    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.put("a".put("fin", 1.0));

        graph.put("b", new HashMap<>());
        graph.put("b").put("a", 3.0);
        graph.put("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());

        // The costs table
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);

        // the parent table
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = findLowestCostNode(costs);
        while (node != null) {
            Double cost = costs.get(node);
            // Go through all the neighbors of this node

            Map<String, Double> neighbors = graph.get(node);

            for (String n : neighbors.keySet()) {
                double newCost = 
            }
            // Mark the node as processed
            processed.add(node);

            // Find the next node to process, and loop
            node = findLowestCostNode(costs);
        }

        System.out.println("Cost from the start to each node:");
        System.out.println(costs); // { a: 5, b: 2, fin: 6 }
    }
}
