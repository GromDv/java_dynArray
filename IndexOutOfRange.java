public class IndexOutOfRange extends Exception {

    public IndexOutOfRange(String message) {
        super(String.format("Index in %s is out of range", message));
    }

}
