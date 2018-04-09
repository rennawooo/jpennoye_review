package main.java;

public class HeapSort extends SortAlgos{
	public static final String NAME = "Heap Sort";
	
	public String getName() {
		return NAME;
	}
	
	/**
     * sorts array by heap sort in a certain range
     * @param vec the array in which this happens
     */
    public void sort(Item[] vec) throws NullPointerException {
            if (vec == null) throw new NullPointerException();

            Item temp;
            int last;
            int n = vec.length;
        
            createHeap(vec);
            for (last = n-1; last > 0; last--) {
                    // exchange top component with 
                    // current last component of vec
                    temp = vec[0]; 
                    vec[0] = vec[last]; 
                    vec[last] = temp;
                    // call Heapify to to reestablish heap property
                    heapify(vec, 0, last-1);
            }//endfor
    }
    
	/**
     * establishes heap property in a certain range
     * @param vec the array in which this happens
     * @param top start of the range
     * @param bottom end of the range
     */
    private static void heapify(Item[] vec, int top, int bottom) {
            Item temp;
            int child;
        
            if (2*top+1 > bottom) return; // nothing to do 
        
            if (2*top+2 > bottom) { 
                    // vec[2*top+1] is only child of vec[top]
                    child = 2*top+1;
            } else {                  // 2 sons, determine bigger one
                    if (vec[2*top+1].key > vec[2*top+2].key) {
                            child = 2*top+1;
                    } else {
                            child = 2*top+2;
                    }
            }//endif
        
            // check if exchange is necessary
            if (vec[top].key < vec[child].key) {
                    temp = vec[top]; 
                    vec[top] = vec[child]; 
                    vec[child] = temp;
                    // recursive call for possible further exchanges
                    heapify(vec, child, bottom); 
            }//endif
    }

    /**
     * turns array into a heap
     * @param vec the array to which this happens
     */
    private static void createHeap(Item[] vec) {
            for (int i = vec.length/2 - 1; i >= 0; i--) {
                    heapify(vec, i, vec.length - 1);
            }
    }
}
