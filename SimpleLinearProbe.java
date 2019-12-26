public class SimpleLinearProbe implements ProbeStrategy {

    public int probe(int arraySize, int originalHash, int attemptNum) {
        // FIXME to be written
        int result = ((originalHash + attemptNum) % arraySize);
        return result; // FIXME remove when ready
    }

}

