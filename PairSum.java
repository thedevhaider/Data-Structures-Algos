import java.util.*;
public class PairSum {

	public static void main(String[] args) {
		int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17};
		int k = 6;
		printPairs(arr, k);
		int[][] res = subsetsSumK(arr, k);
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(res[i][j] + " ");
			}
		}

	}
	
	public static void printPairs(int[] input, int sum) {
		Map<Integer, Integer> pairs = new HashMap();
		for (int i : input) {
		    if (pairs.containsKey(i)) {
		        if (pairs.get(i) != null) {           
		            System.out.println(i + " " + (sum - i));
		        }                
		        pairs.put(sum - i, null);
		    } else if (!pairs.containsValue(i)) {        
		        pairs.put(sum-i, i);
		    }
		}
	}
	public static int[][] subsetsSumK(int input[], int sum) {
		// Write your code here
      	int[][] arr = new int[input.length][2];
      	Map<Integer, Integer> pairs = new HashMap();
      	int j = 0;
		for (int i : input) {
		    if (pairs.containsKey(sum - i)) {
		        if (pairs.get(sum - i) != null) {           
		            
                  	arr[j][0] = sum - i;
                  	arr[j][1] = i;
                  	j++;
		        }                
		        pairs.put(i, null);
		    } else if (!pairs.containsValue(sum - i)) {        
		        pairs.put(i, sum - i);
		    }
		}
		int[][] res = new int[j][2];
		int m = 0;
		for(int i = res.length - 1; i >= 0; i--) {
			res[m][0] = arr[i][0];
			res[m][1] = arr[i][1];
			m++;
		}
      	return res;

	}
  	

}
