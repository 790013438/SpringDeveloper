package io.github.floyd.graph;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("you",     new LinkedList<>(Arrays.asList("alice",  "bob",  "claire")));
        graph.put("bob",     new LinkedList<>(Arrays.asList("anuj",   "peggy")));
        graph.put("alice",   new LinkedList<>(Collections.singletonList("peggy")));
        graph.put("claire",  new LinkedList<>(Arrays.asList("thom",   "jonny")));
        graph.put("anuj",    new LinkedList<>(Collections.emptyList()));
        graph.put("peggy",   new LinkedList<>(Collections.emptyList()));
        graph.put("thom",    new LinkedList<>(Collections.emptyList()));
        graph.put("jonny",   new LinkedList<>(Collections.emptyList()));

        Deque<String> searchQueue = new ArrayDeque<>(graph.get("you"));

        while(!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (person_is_seller(person)) {
                System.out.println(person + " is a mango seller!");
            } else {
                searchQueue.addAll(graph.get(person));
            }
        }
    }

    private static boolean search(String name) {
        Deque<String> searchQueue = new ArrayDeque<>(graph.get("you"));
        List<String> searched = new LinkedList<>();
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (person_is_seller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }

    private static boolean person_is_seller(String name) {
        return name != null && name.endsWith("m");
    }

}
