package main.java;

public class InsertionSort extends SortAlgos{
	public static final String NAME = "Insertion Sort";
	
	public String getName() {
		return NAME;
	}
	
	/**
     * Sorts with insertion sort algorithm
     * @param vec the array to be sorted
     * @exception NullPointerException if <code>vec</code> 
     * is not initialized
     */
    public void sort(Item vec[]) throws NullPointerException {
            if (vec == null) throw new NullPointerException();
            int n = vec.length;
            int currentPos, insPos; 
            for (currentPos = 1; currentPos < n; currentPos++) {
                    insPos = findInsPosition(vec, currentPos - 1, 
                                    vec[currentPos].key);
                    insertAtPosition(vec, insPos, currentPos);
            }   
    }
    
    /**
     * Finds insertion position with binary search
     * @param vec the array to be sorted
     * @param range upper bound for insertion position
     * @param x the value determining the position 
     * @return the insertion position 
     */
    private static int findInsPosition(Item[] vec, int range, int x) {
            int index;   // variable to hold the position
            int i,j,k;
            i = 0; j = range; // initialize lower index i and upper index j
            do { 
                    k = (i + j) / 2;  // choose k halfway between i and j
                    if (x >= vec[k].key) { 
                            i = k + 1;   // update lower index i
                    } else {                 
                            j = k - 1;   // update upper index j
                    }
            } while (i <= j);
            if (x >= vec[k].key) {
                    index = k + 1;
            } else  {                   
                    index = k;
            }
            return index;
    }
    
    /**
     * Inserts array component into a sorted range below the component
     * such that the result is again sorted
     * @param vec the array in which this happens
     * @param insPos the insertion position
     * @param fromPos the position whose value 
     * has to be inserted at <code>insPos</code>
     */
    private static void insertAtPosition(Item[] vec, int insPos, 
                                                     int fromPos ) {
            if (insPos == fromPos) return;
            Item temp = vec[fromPos];
            for (int i = fromPos; i > insPos; i--) vec[i] = vec[i-1];
            vec[insPos] = temp;
    }
}
