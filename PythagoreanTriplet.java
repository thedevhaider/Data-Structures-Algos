import java.util.*;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 1, 4, 6, 5};
		Arrays.sort(arr);
		for(int x = arr.length - 1; x >= 0; x--) {
			int sum = arr[x] * arr[x];
			int input[] = Arrays.copyOfRange(arr, 0, x);
			Set<Integer> map = new HashSet<>();
			for(int i = 0; i < input.length; i++) {
				int temp = sum - input[i]*input[i];
				if(map.contains(temp)) {
					System.out.println((int)Math.sqrt(sum)+"^2="+(int)Math.sqrt(temp)+"^2+"+input[i]+"^2");
				}else {
					map.add(input[i]*input[i]);
				}
			}
		}

	}

}
