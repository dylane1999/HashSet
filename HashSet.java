
public class HashSet {

    private ProbeStrategy ProbeStrategy;
    private int ratio;
    private int[] values;
    public int size;
    public int attemptNumber = 0;
    private Object SimpleLinearProbe;
    // FIXME more member variables here

    public HashSet(int initArrayLength, int ratio, ProbeStrategy strategy) {
        this.values = new int[initArrayLength];
        for (int i = 0; i < values.length; i++) {
            values[i] = -1;
        }
        this.ratio = ratio;
        this.ProbeStrategy = strategy;
       // this.ProbeStrategy = new SimpleLinearProbe();

    }
    public int size(){
        return size;
    }

    public boolean add(int value) {
        attemptNumber = 0;
        //int index = value % values.length;
        if (values.length < (ratio * size)){
            size = 0;
            int [] temporary = values;
            values = new int[(2 * temporary.length + 1)];
            for (int i = 0; i < values.length; i++) {
                values[i] = -1;
            }
            for (int i = 0; i < temporary.length; i++) {
                if (temporary[i] != -1){
                    add(temporary[i]);
                }
            }
        }
        if (this.contains(value)) {
            return false;
        }
        int test = value % values.length;
        int index = this.ProbeStrategy.probe(values.length, test, 0);
        if (values[index] == -1){
            values[index] = value;
            size++;
            return true;
        }
        else{
            for (int i = 0; i < values.length; i++) {
                int index2 = this.ProbeStrategy.probe(values.length, index, i);
                if (values[index2] == -1) {
                    values[index2] = value;
                    size++;
                    return true;
                }
            }
        }
       // while (values[index] != -1 ){
      //      index = this.ProbeStrategy.probe(values.length, index, attemptNumber);
       //     attemptNumber++;
      //  }

        return false;
    }




    public boolean contains(int value) {
        int test = value % values.length;
        int index = this.ProbeStrategy.probe(values.length, test, 0);
     //   int index = value % values.length;
        if (values[index] == value){
            return true;
        }
       else {
            for (int i = 0; i < values.length; i++) {
                int index2 = this.ProbeStrategy.probe(values.length, index, i);
                if (values[index2] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(int value)     {
        //int index = value % values.length;
        int test = value % values.length;
        int index = this.ProbeStrategy.probe(values.length, test, 0);
        if (values[index] == value){
            values[index] = -1;
            size--;
            return true;
        }
        else {
            for (int i = 0; i < values.length; i++) {
                int index2 = this.ProbeStrategy.probe(values.length, index, i);
                if (values[index2] == value) {
                    values[index2] = -1;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }




    public int[] toArray() {
        int[] result = new int[this.values.length];
        for (int i = 0; i < this.values.length; i++) {
            result[i] = this.values[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProbeStrategy linear = new SimpleLinearProbe();
        HashSet set = new HashSet(7, 3, linear);
        System.out.println(set.ProbeStrategy);
        System.out.println(set.contains(4));

        int[] numbers = {1273, 404, 1335, 786, 1331, 897, 859, 1526, 1366, 737, 274, 1314, 393, 568, 601, 440, 1502, 311, 796, 1133, 580, 287, 1097, 1111, 814};
        for (int i = 0; i < numbers.length; i++) {
            // add the number
            set.add(numbers[i]);

            // print out the array
            int[] array = set.toArray();
            for (int j = 0; j < array.length; j++) {
   //             System.out.print(array[j] + ", ");
            }
   //         System.out.println();

        }

        int[] array = set.toArray();
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + ", ");
        }
        System.out.println();
        System.out.println(set.contains(814));
        System.out.println(set.size());

    }
}
