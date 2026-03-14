package DataStructures;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DataStructuresExamples {

    public static void main(String[] args) {
        arrayExample();
        arrayListExample();
        linkedListAsDequeExample();
        hashSetExample();
        linkedHashSetExample();
        treeSetExample();
        hashMapExample();
        linkedHashMapLruExample();
        treeMapExample();
        concurrentHashMapExample();
        arrayDequeAsStackExample();
        arrayDequeAsQueueExample();
        priorityQueueExample();
    }

    // ── Array ──────────────────────────────────────────────────────────

    static void arrayExample() {
        System.out.println("=== Array ===");

        int[] scores = {95, 82, 74, 91, 68};

        // O(1) доступ по индексу
        System.out.println("Третий элемент: " + scores[2]);

        // Сортировка на месте — O(n log n), dual-pivot quicksort
        Arrays.sort(scores);
        System.out.println("Отсортировано: " + Arrays.toString(scores));

        // Бинарный поиск — O(log n), массив должен быть отсортирован
        int idx = Arrays.binarySearch(scores, 82);
        System.out.println("Индекс 82: " + idx);
        System.out.println();
    }

    // ── ArrayList ──────────────────────────────────────────────────────

    static void arrayListExample() {
        System.out.println("=== ArrayList ===");

        List<String> languages = new ArrayList<>(List.of("Java", "Kotlin", "Scala"));

        languages.add("Groovy");             // O(1) амортизированно
        languages.add(1, "TypeScript");      // O(n) — сдвиг элементов вправо
        languages.remove("Scala");           // O(n) — поиск + сдвиг

        // Итерация с индексом
        for (int i = 0; i < languages.size(); i++) {
            System.out.println(i + ": " + languages.get(i));
        }

        // Сортировка
        languages.sort(Comparator.comparingInt(String::length));
        System.out.println("По длине: " + languages);

        // Безопасная неизменяемая копия
        List<String> snapshot = List.copyOf(languages);
        System.out.println();
    }

    // ── LinkedList как Deque ───────────────────────────────────────────

    static void linkedListAsDequeExample() {
        System.out.println("=== LinkedList as Deque ===");

        // Единственный нормальный кейс для LinkedList — двусторонняя очередь
        Deque<String> history = new LinkedList<>();

        history.addFirst("page-1");   // O(1)
        history.addFirst("page-2");   // O(1)
        history.addLast("page-0");    // O(1)

        System.out.println("Последняя посещённая: " + history.peekFirst());
        System.out.println("Самая старая: " + history.peekLast());

        history.pollFirst(); // удалить с начала — O(1)
        System.out.println("После назад: " + history);
        System.out.println();
    }

    // ── HashSet ────────────────────────────────────────────────────────

    static void hashSetExample() {
        System.out.println("=== HashSet ===");

        // Удаление дубликатов из списка
        List<String> withDupes = List.of("java", "kotlin", "java", "go", "kotlin", "rust");
        Set<String> unique = new HashSet<>(withDupes);
        System.out.println("Уникальные: " + unique);

        // O(1) проверка наличия — главное преимущество
        System.out.println("Содержит rust: " + unique.contains("rust"));

        // Пересечение двух множеств
        Set<String> backend = Set.of("java", "go", "rust", "python");
        Set<String> intersection = new HashSet<>(unique);
        intersection.retainAll(backend);
        System.out.println("Пересечение: " + intersection);
        System.out.println();
    }

    // ── LinkedHashSet ──────────────────────────────────────────────────

    static void linkedHashSetExample() {
        System.out.println("=== LinkedHashSet ===");

        // Уникальность + сохранение порядка вставки
        Set<String> visitOrder = new LinkedHashSet<>();
        visitOrder.add("Астана");
        visitOrder.add("Алматы");
        visitOrder.add("Астана");  // дубликат — не добавится
        visitOrder.add("Шымкент");

        // Порядок гарантированно такой же, как порядок первой вставки
        System.out.println("Маршрут: " + visitOrder);
        System.out.println();
    }

    // ── TreeSet ────────────────────────────────────────────────────────

    static void treeSetExample() {
        System.out.println("=== TreeSet ===");

        TreeSet<Integer> prices = new TreeSet<>(List.of(150, 320, 89, 450, 210, 75));

        System.out.println("Мин: " + prices.first());           // O(log n)
        System.out.println("Макс: " + prices.last());           // O(log n)
        System.out.println("Ближайший >= 200: " + prices.ceiling(200));
        System.out.println("Ближайший <= 200: " + prices.floor(200));

        // Диапазон [100, 300) — O(log n + k), где k — размер подмножества
        System.out.println("От 100 до 300: " + prices.subSet(100, 300));

        // Все ниже 200
        System.out.println("Дешевле 200: " + prices.headSet(200));
        System.out.println();
    }

    // ── HashMap ────────────────────────────────────────────────────────

    static void hashMapExample() {
        System.out.println("=== HashMap ===");

        // Подсчёт частоты слов — классический кейс
        String text = "java is great and java is fast and java is everywhere";
        Map<String, Integer> freq = new HashMap<>();

        for (String word : text.split(" ")) {
            freq.merge(word, 1, Integer::sum); // лаконичнее чем getOrDefault + put
        }
        System.out.println("Частоты: " + freq);

        // computeIfAbsent — ленивая инициализация вложенных структур
        Map<String, List<String>> grouped = new HashMap<>();
        List.of("apple", "avocado", "banana", "blueberry", "cherry").forEach(fruit ->
                grouped.computeIfAbsent(fruit.substring(0, 1), k -> new ArrayList<>()).add(fruit)
        );
        System.out.println("По первой букве: " + grouped);
        System.out.println();
    }

    // ── LinkedHashMap как LRU-кэш ──────────────────────────────────────

    static void linkedHashMapLruExample() {
        System.out.println("=== LinkedHashMap (LRU Cache) ===");

        final int MAX_SIZE = 3;

        // accessOrder=true — при get() элемент перемещается в конец
        Map<String, String> cache = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_SIZE;
            }
        };

        cache.put("user:1", "Roma");
        cache.put("user:2", "Alex");
        cache.put("user:3", "Max");
        System.out.println("Кэш: " + cache);

        cache.get("user:1"); // user:1 теперь "свежий"
        cache.put("user:4", "Denis"); // вытесняет user:2 (самый старый по доступу)
        System.out.println("После вытеснения: " + cache);
        System.out.println();
    }

    // ── TreeMap ─────────────────────────────────────────────────────────

    static void treeMapExample() {
        System.out.println("=== TreeMap ===");

        TreeMap<String, Double> rates = new TreeMap<>();
        rates.put("2024-01-15", 450.5);
        rates.put("2024-02-01", 455.2);
        rates.put("2024-02-15", 448.0);
        rates.put("2024-03-01", 460.1);
        rates.put("2024-03-15", 462.3);

        // Ближайшая дата <= заданной
        System.out.println("Курс на 2024-02-10: " + rates.floorEntry("2024-02-10"));

        // Все записи за февраль
        System.out.println("Февраль: " + rates.subMap("2024-02-01", true, "2024-02-28", true));
        System.out.println();
    }

    // ── ConcurrentHashMap ──────────────────────────────────────────────

    static void concurrentHashMapExample() {
        System.out.println("=== ConcurrentHashMap ===");

        ConcurrentHashMap<String, Long> metrics = new ConcurrentHashMap<>();

        // Атомарные операции — безопасно из нескольких потоков
        metrics.merge("requests", 1L, Long::sum);
        metrics.merge("requests", 1L, Long::sum);
        metrics.merge("errors", 1L, Long::sum);

        // compute — атомарное обновление
        metrics.compute("requests", (key, val) -> val == null ? 1 : val + 1);

        System.out.println("Метрики: " + metrics);

        // Параллельные bulk-операции (порог = 1 → всегда параллельно)
        long total = metrics.reduceValues(1, Long::sum);
        System.out.println("Всего событий: " + total);
        System.out.println();
    }

    // ── ArrayDeque как Stack ───────────────────────────────────────────

    static void arrayDequeAsStackExample() {
        System.out.println("=== ArrayDeque as Stack ===");

        // НИКОГДА не используй java.util.Stack — это легаси мусор
        Deque<Character> stack = new ArrayDeque<>();

        // Проверка скобок — классическая задача на стек
        String expr = "{[()]}";
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        boolean valid = true;

        for (char c : expr.toCharArray()) {
            if ("([{".indexOf(c) >= 0) {
                stack.push(c);                          // O(1)
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(c))) {
                    valid = false;
                    break;
                }
            }
        }
        valid = valid && stack.isEmpty();
        System.out.println("\"" + expr + "\" валидно: " + valid);
        System.out.println();
    }

    // ── ArrayDeque как Queue (FIFO) ────────────────────────────────────

    static void arrayDequeAsQueueExample() {
        System.out.println("=== ArrayDeque as Queue (FIFO) ===");

        Queue<String> taskQueue = new ArrayDeque<>();

        taskQueue.offer("отправить email");    // O(1) — в конец
        taskQueue.offer("обновить кэш");
        taskQueue.offer("записать лог");

        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();              // O(1) — с начала
            System.out.println("Выполняю: " + task);
        }
        System.out.println();
    }

    // ── PriorityQueue ──────────────────────────────────────────────────

    static void priorityQueueExample() {
        System.out.println("=== PriorityQueue ===");

        // Min-heap по приоритету (меньше число = выше приоритет)
        record Task(String name, int priority) {}

        Queue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(Task::priority));

        pq.offer(new Task("фикс бага", 1));
        pq.offer(new Task("рефакторинг", 5));
        pq.offer(new Task("код ревью", 2));
        pq.offer(new Task("документация", 4));

        while (!pq.isEmpty()) {
            Task task = pq.poll(); // всегда достаёт с минимальным priority
            System.out.println("[P" + task.priority() + "] " + task.name());
        }

        // Top-K задача: найти 3 самых длинных слова
        String[] words = {"java", "concurrency", "map", "stream", "collections", "a"};
        Queue<String> topK = new PriorityQueue<>(Comparator.comparingInt(String::length));

        for (String w : words) {
            topK.offer(w);
            if (topK.size() > 3) topK.poll(); // выкидываем самый короткий
        }
        System.out.println("Top-3 по длине: " + topK);
    }
}
