
public class Client {
    public static void main(String[] args) {
        AbcStringPrinter printer = new AbcStringPrinter();
        printer.print("абвг");
        System.out.println("Results count = " + printer.getPrintsAmount());
    }
}
