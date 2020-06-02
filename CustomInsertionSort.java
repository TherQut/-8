public abstract class CustomInsertionSort{

    public static void sort(Comparable[] a, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = i; j > start && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void sort(Comparable[] a) {
        int start = 0;
        int end = a.length;
        for (int i = start; i < end; i++) {
            for (int j = i; j > start && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
