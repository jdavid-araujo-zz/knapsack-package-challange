package packer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Package;

public class PackerRecursive {
	
	/**
	 * 
	 * @param pck the object that contain the items and limit size
	 * @return the list of index 
	 */
	public List<String> getIndex(Package pck) {
		
		/*
		 * Sort ascending by weight
		 */
		pck.getItems().sort((item1, item2) -> item1.getWeight().compareTo(item2.getWeight()));
		
		/*
		 * Initialize arrays
		 */
		Double[] wt = pck.getItems().stream().map(i -> i.getWeight()).toArray(Double[]::new);
		Integer[] val = pck.getItems().stream().map(i -> i.getCost()).toArray(Integer[]::new);
		Boolean visited[] = new Boolean[pck.getItems().size()];
		Arrays.fill(visited, Boolean.FALSE);
		
		/*
		 * Compute the recursion tree, keeping track of visited items
		 */
		Integer maxValue = maximizeValue(pck.getWeight(), wt, val, pck.getItems().size(), visited);
		
		/*
		 * 
		 */
		List<String> solutionItems = new ArrayList<>();
		for ( int i = 0; i < pck.getItems().size(); i++ ) {
			 if ( visited[i] ) {
				 solutionItems.add(pck.getItems().get(i).getIndex().toString());
			 }
		}
		
		/*
		 * Sort ascending by Index
		 */
		solutionItems.sort( (index1,index2) -> index1.compareTo(index2) );

		return solutionItems;
	}

	/**
	 * @param W the maximum capacity of the package
	 * @param wt array of items weights
	 * @param val array of items values
	 * @param N total number of items
	 * @param visited 
	 * @return maximum value for the package
	 */
	private Integer maximizeValue(Integer W, Double wt[], Integer val[], Integer N, Boolean visited[]) {

		if (N == 0 || W == 0) {
			return 0; // stopping point
		}

		if ( wt[N-1] > W ) {
		
			return maximizeValue(W, wt, val, N-1,visited);
			
		}  else {

			
			Boolean v1[] = new Boolean[visited.length];
			Boolean v2[] = new Boolean[visited.length];
       
			System.arraycopy(visited, 0, v1, 0, v1.length);
			System.arraycopy(visited, 0, v2, 0, v2.length);
       
			v1[N-1] = true;

			Integer s1 = val[N-1] + maximizeValue(W-wt[N-1].intValue(), wt, val, N-1,v1);
			Integer s2 = maximizeValue(W, wt, val, N-1,v2);
       
			if( s1 > s2 ){
				System.arraycopy(v1, 0, visited, 0, v1.length);
				return s1;
			} else{
				System.arraycopy(v2, 0, visited, 0, v2.length);
				return s2;
			}
		}
   }      
}
