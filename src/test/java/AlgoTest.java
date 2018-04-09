package test.java;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import main.java.SortDemoData;
import main.java.Item;
import main.java.SortAlgos;

public class AlgoTest {
	SortDemoData data = new SortDemoData();
	
	/**
	 * BubbleEmptyException checks that bubbleSort handles uninitialized arrays correctly.
	 * This covers edge sequence number 2, <20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 36>
	 */
	@Test (expected = NullPointerException.class)
	public void BubbleEmptyException() {
		Item[] test = new Item[5];
		SortAlgos.sortFactory(0).sort(test);
	}
	
	/**
	 * BubbleNullException checks that bubbleSort handles null arrays correctly.
	 * This covers edge sequence number 1, <20, 21, 36>
	 */
	@Test (expected = NullPointerException.class)
	public void BubbleNullException() {
		Item[] test = null;
		SortAlgos.sortFactory(0).sort(test);
	}
	
	/**
	 * BubbleOne checks that arrays of length one are handled.
	 */
	@Test
	public void BubbleOne() {
		Item[] test = {new Item(new Integer(5))};
		Item[] compare = {new Item(new Integer(5))};
		
		SortAlgos.sortFactory(0).sort(test);
		System.out.println("original: " + compare[0].key + " after: " + test[0].key + " boolean: " + test[0].equals(compare[0]));
		assertTrue("Not equal", test[0].equals(compare[0]));
	}
	
	/**
	 * BubbleSmall checks that small positive arrays with the smallest and largest
	 * entries in the middle are handled.
	 * This covers both node coverage and edge coverage number 3, 
	 * <20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 28, 29, 34, 28, 35, 27, 28, 36>
	 */
	@Test
	public void BubbleSmall() {
		Item[] test = {new Item(new Integer(8)), new Item(new Integer(612)), new Item(new Integer(1)),
				new Item(new Integer(15)), new Item(new Integer(62))};
		Item[] compare = {new Item(new Integer(1)), new Item(new Integer(8)), new Item(new Integer(15)),
				new Item(new Integer(62)), new Item(new Integer(612))};
		
		SortAlgos.sortFactory(0).sort(test);
		for(int i = 0; i < test.length; ++i) {
			assertTrue("Not equal at index " + i, test[i].equals(compare[i]));
		}
	}
	
	/**
	 * BubbleNeg checks that small negative arrays with the smallest entry at the start
	 * and the largest entry at the end are handled.
	 */
	@Test
	public void BubbleNeg() {
		Item[] test = {new Item(new Integer(-612)), new Item(new Integer(-8)), new Item(new Integer(-8)),
				new Item(new Integer(-62)), new Item(new Integer(-1))};
		Item[] compare = {new Item(new Integer(-612)), new Item(new Integer(-62)), new Item(new Integer(-8)),
				new Item(new Integer(-8)), new Item(new Integer(-1))};
		
		SortAlgos.sortFactory(0).sort(test);
		for(int i = 0; i < test.length; ++i) {
			assertTrue("Not equal at index " + i, test[i].equals(compare[i]));
		}
	}
	
	/**
	 * BubbleMixed checks that small arrays with 0, the smallest entry at the end, 
	 * and the largest entry at the start are handled.
	 */
	@Test
	public void BubbleMixed() {
		Item[] test = {new Item(new Integer(612)), new Item(new Integer(-8)), new Item(new Integer(15)),
				new Item(new Integer(0)), new Item(new Integer(-62))};
		Item[] compare = {new Item(new Integer(-62)), new Item(new Integer(-8)), new Item(new Integer(0)),
				new Item(new Integer(15)), new Item(new Integer(612))};
		
		SortAlgos.sortFactory(0).sort(test);
		for(int i = 0; i < test.length; ++i) {
			assertTrue("Not equal at index " + i, test[i].equals(compare[i]));
		}
	}
	
	/**
	 * BubbleLarge checks that large arrays are handled.
	 */
	@Test
	public void BubbleLarge() {
		Item[] test = new Item[1000];
		Item[] compare =  new Item[1000];
		
		for(int i = -500; i < 500; ++i) {
			compare[i+500] = new Item(new Integer(i));
			test[i+500] = new Item(new Integer(-1-i));
		}
		
		SortAlgos.sortFactory(0).sort(test);
		for(int i = 0; i < 1000; ++i) {
			assertTrue("Large test failed at index " + i, test[i].equals(compare[i]));
		}
	}
	
	/**
	 * Sort checks that all valid options of runAlgo return sorted results. It also checks 
	 * that negative numbers and zero are sorted correctly.
	 */
	@Test
	public void Sort() {
		StringBuffer result = new StringBuffer();
		
		result.append("Bubble Sort\n");
		for (int i = -1; i <= 8; i++) {
            result.append(
                    (i+1) + ": " + (7-i) + " --> " + i + "\n");
		}
		result.append("\r");
		
		data.initializeArray("8 7 6 5 4 3 2 1 0 -1");
		assertTrue("Bubble sort not sorted", result.toString().equals(data.runAlgo(0).toString()));

		data.initializeArray("8 7 6 5 4 3 2 1 0 -1");
		result.replace(0, 6, "Selection");
		assertTrue("Selection sort not sorted", result.toString().equals(data.runAlgo(1).toString()));

		data.initializeArray("8 7 6 5 4 3 2 1 0 -1");
		result.replace(0, 9, "Insertion");
		assertTrue("Insertion sort not sorted", result.toString().equals(data.runAlgo(2).toString()));

		data.initializeArray("8 7 6 5 4 3 2 1 0 -1");
		result.replace(0, 9, "Merge");
		assertTrue("Merge sort not sorted", result.toString().equals(data.runAlgo(3).toString()));

		data.initializeArray("8 7 6 5 4 3 2 1 0 -1");
		result.replace(0, 5, "Quick");
		assertTrue("Quick sort not sorted", result.toString().equals(data.runAlgo(4).toString()));

		data.initializeArray("8 7 6 5 4 3 2 1 0 -1");
		result.replace(0, 5, "Heap");
		assertTrue("Heap sort not sorted", result.toString().equals(data.runAlgo(5).toString()));
	}

}
