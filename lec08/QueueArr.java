public class QueueArr{
    private int arr[];
    private int lastElemIdx; //marks the index of the last element
    private int firstElemIdx; //marks the index of the first element

    public QueueArr() {
        arr = new int[200];
        lastElemIdx = -1;
        firstElemIdx = 0;
    }

    public boolean isEmpty() {
        return lastElemIdx != -1;
    }

    public int first() {
        if (isEmpty()) {
            return -1;
        }
        return arr[firstElemIdx];
    }

    public void enqueue(int e) {
        //TODO 1: enqueue
        //assume queue is not full 
        lastElemIdx += 1;
        arr[lastElemIdx] = e;
        //what if is full?
        if (lastElemIdx == arr.length-1) {
            //expand
            //throw an exception
        }
    }

    public int dequeue() {
        //FIFO

        if (isEmpty()) {
            return -1;
        }
        
        //remove the first element
        //TODO 2: what to do here?
        int poppedElem = arr[firstElemIdx];  

        /*
        for (int i=0; i<=lastElemIdx; i++) {
            arr[i] = arr[i+1];
        }
        */

        firstElemIdx += 1;

        //TODO 3: how can we improve this? 
        //TODO 4: fix isEmpty and first...
        return poppedElem;
    }
}
