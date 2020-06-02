import BST;

public class AbcStringPrinter {
    private Integer[] charIndexArray;
    private int printsAmount;

    public void print(String s) {
        printsAmount = 0;
        char[] charArray = s.toCharArray();
        charIndexArray = new Integer[charArray.length];
        convertCharToInt(charArray, charIndexArray);
        CustomInsertionSort.sort(charIndexArray);
        nextStep(charIndexArray.clone(), 0);
    }

    public int getPrintsAmount() {
        return printsAmount;
    }

    private void nextStep(Integer[] a, int indexNow) {
        if (a.length == 1) {
            charIndexArray[indexNow] = a[0];
            printCharIndexArray(charIndexArray);
            return;
        }

        BST<Integer, Integer> bst = new BST<>();

        for (int i = 0; i < a.length; i++) {
            if(bst.get(a[i]) != null)
                continue;
            charIndexArray[indexNow] = a[i];
            nextStep(copyArray(a, a[i]), indexNow+1);
            bst.put(a[i], 1);
        }
    }

    private void printCharIndexArray(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            int unicode = a[i];
            System.out.print((char) unicode);
        }
        System.out.println();
        printsAmount++;
    }

    private void convertCharToInt(char[] charArray, Integer[] intArray) {
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = (int) charArray[i];
        }
    }

    private Integer[] copyArray(Integer[] a, int without) {
        Integer[] result = new Integer[a.length-1];
        int i = 0;
        boolean alreadySkipped = false;
        for (Integer num: a) {
            if (without == num && !alreadySkipped) {
                alreadySkipped = true;
                continue;
            }

            result[i++] = num;
        }
        return result;
    }
}
