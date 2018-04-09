package main.java;

public class QuickSort extends SortAlgos{
	public static final String NAME = "Quick Sort";
	
	public String getName() {
		return NAME;
	}
	
	/**
     * Sorts with quick sort algorithm
     * @param vec the array to be sorted
     * @exception NullPointerException if <code>vec</code> 
     * is not initialized
     */
    public void sort(Item[] vec) throws NullPointerException {
            if (vec == null) throw new NullPointerException();
            quickSort(vec, 0, vec.length - 1);
    }
    
    /**
     * sorts array by quick sort in a certain range
     * @param vec the array in which this happens
     * @param loBound start of the range
     * @param hiBound end of the range
     */
    private static void quickSort(Item[] vec, int loBound, int hiBound) {
            int loSwap, hiSwap;
            int pivotKey, pivotIndex;
            Item temp, pivotItem;
    
            if (hiBound - loBound == 1) {         // Two items to sort
                    if (vec[loBound].key > vec[hiBound].key) {
                            temp = vec[loBound];
                            vec[loBound] = vec[hiBound];
                            vec[hiBound] = temp;
                    }
                    return;
            }
            pivotIndex = (loBound + hiBound) / 2; // 3 or more items to sort
            pivotItem = vec[pivotIndex];       
            vec[pivotIndex] = vec[loBound];
            vec[loBound] = pivotItem;    
            pivotKey = pivotItem.key; 
            loSwap = loBound + 1;
            hiSwap = hiBound;
            do {
                    while (loSwap <= hiSwap && vec[loSwap].key <= pivotKey)
                        // INVARIANT (prior to test):
                        // All vec[loBound+1..loSwap-1]
                        // are <= pivot  &&  loSwap <= hiSwap+1
                            loSwap++;
                    while (vec[hiSwap].key > pivotKey)
                        // INVARIANT (prior to test):
                        //    All vec[hiSwap+1..hiBound]
                        //    are > pivot  &&  hiSwap >= loSwap-1
                            hiSwap--;
                    if (loSwap < hiSwap) {
                            temp = vec[loSwap];
                            vec[loSwap] = vec[hiSwap];
                            vec[hiSwap] = temp;
                            loSwap++;
                            hiSwap--;
                    }
                    // INVARIANT: All vec[loBound..loSwap-1] are <= pivot
                    // && All vec[hiSwap+1..hiBound] are > pivot
                    // && (loSwap < hiSwap) --> 
                    //                 vec[loSwap] <= pivot < vec[hiSwap]
                    // && (loSwap >= hiSwap) --> vec[hiSwap] <= pivot
                    // && loBound <= loSwap <= hiSwap+1 <= hiBound+1
            } while (loSwap <= hiSwap);
            vec[loBound] = vec[hiSwap];
            vec[hiSwap] = pivotItem;
    
            if (loBound < hiSwap-1)     // 2 or more items in 1st subvec
                    quickSort(vec, loBound, hiSwap-1);
    
            if (hiSwap+1 < hiBound)     // 2 or more items in 2nd subvec
                    quickSort(vec, hiSwap+1, hiBound);
    }
}
