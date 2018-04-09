package main.java;

public class BubbleSort extends SortAlgos {
	public static final String NAME = "Bubble Sort";
	
	public String getName() {
		return NAME;
	}
		
	/**
     * Sorts with bubble sort algorithm
     * 
     * Returns a NullPointerException when the array is empty
     * Returns a sorted array with the same length as the param array vec
     * 
     * @param vec the array to be sorted
     * @exception NullPointerException if <code>vec</code> 
     * is not initialized
     */
    public void sort(Item[] vec) throws NullPointerException {
            if (vec == null) throw new NullPointerException();
    
	        int n = vec.length;
	        Item temp;
            int bottom;       // bottom for each pass        
            for (bottom = 1; bottom < n; bottom++)  {
                    for (int i = n-1; i >= bottom; i--) {
                            if (vec[i-1].key > vec[i].key) {
                                    temp = vec[i-1];
                                    vec[i-1] = vec[i];
                                    vec[i] = temp;
                            }
                    }
            }
    }
}
