package main.java;

public class SelectionSort extends SortAlgos{
	public static final String NAME = "Selection Sort";
	
	public String getName() {
		return NAME;
	}
	
	/**
     * Sorts with selection sort algorithm
     * @param vec the array to be sorted
     * @exception NullPointerException if <code>vec</code> 
     * is not initialized
     */
    public void sort(Item vec[]) throws NullPointerException {
            if (vec == null) throw new NullPointerException();
            
            int minIndx;            // Index of smallest key in each pass
            int bottom;             // bottom for each pass
            int i;
            Item temp;
            int n = vec.length;
        
            for (bottom = 0; bottom < n-1; bottom++) {
                         //  INVARIANT (prior to test):
                         //  All vec[bottom+1..n-1] are >= vec[bottom]
                         //  && vec[0..bottom] are in ascending order
                         //  && bottom >= 0
                    minIndx = bottom;
                    for (i = bottom+1; i < n; i++) {
                                // INVARIANT (prior to test):
                                // vec[minIndx] <= all
                                // vec[0..i-1]
                                // && i >= bottom+1
                            if (vec[i].key < vec[minIndx].key) { 
                                    minIndx = i; 
                            }
                    }
                    temp = vec[bottom];
                    vec[bottom] = vec[minIndx];
                    vec[minIndx] = temp; 
            }
    }
}
