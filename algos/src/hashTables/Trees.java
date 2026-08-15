package hashTables;

import java.io.File;
import java.util.*;

public class Trees {
    void main() {
        List<String> friends = new ArrayList<>(List.of("Alice", "Bob", "John"));
        Map<String, List<String>> graph = new HashMap<>(Map.of("me", friends));
        graph.put("Alice", List.of("Andrey", "Valera"));
        graph.put("Bob", List.of("Homer", "Cat"));
        graph.put("John", List.of("Peggy"));
        graph.put("Peggy", List.of("Tom", "Jarry"));
        graph.put("Homer", List.of("Swan", "Man"));
        graph.put("Cat", List.of());
        graph.put("Andrey", List.of());
        graph.put("Valera", List.of());
        graph.put("Tom", List.of());
        graph.put("Jarry", List.of());
        graph.put("Swan", List.of());
        graph.put("Man", List.of());
        System.out.println(searchQueue(graph));

        printDirTree("algos");
    }

    public static String searchQueue(Map<String, List<String>> graph) {
        Deque<String> queue = new ArrayDeque<>(graph.get("me"));
        HashSet<String> searched = new HashSet<>();

        while (!queue.isEmpty()) {
            String person = queue.removeFirst();
            if (!searched.contains(person)) {
                if (isSeller(person)) {
                    return person;
                } else {
                    queue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return "xyu tam";
    }

    public static boolean isSeller(String person) {
        return person.toLowerCase().endsWith("m");
    }

    public static void printDirTree(String root) {
        Deque<String> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            String currDir = queue.removeFirst();
            File dir = new File(currDir);
            File[] files = dir.listFiles();

            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getPath());
                    } else {
                        queue.addLast(file.getPath());
                    }
                }
            }
        }
    }

    public static void printDirTreeRecursive(String root) {
        File dir = new File(root);
        File[] files = dir.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else {
                    printDirTreeRecursive(file.getPath());
                }
            }
        }
    }
}
