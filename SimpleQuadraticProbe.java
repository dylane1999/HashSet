public class SimpleQuadraticProbe implements ProbeStrategy {

    public int probe(int arraySize, int originalHash, int attemptNum) {
        // FIXME to be written
        int result = (int) ((originalHash +  Math.pow(attemptNum, attemptNum)) % arraySize);
        return result; // FIXME remove when ready
    }

}
