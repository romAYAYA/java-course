void main() {
    List<Integer> arr = List.of(654,23,54,21,34,76);

    List<Integer> sortedArr = sorting.SelectionSort.selectionSort(arr);

    System.out.println("Sorted array:" + sortedArr);

    System.out.println("\n\nCountdown:");
    recursion.Example.countdown(10);

    System.out.println("\n\nFactorial:" + recursion.Example.fact(3));
}
