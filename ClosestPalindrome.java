import java.util.*;

public class ClosestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t = 1; t <= test; t++) {
			long num = in.nextLong();
			String n = String.valueOf(num);
			
		}
	}
	
	public static void solveProb(String num) {
		if(num.length() == 1) {
			System.out.println(num);
			return;
		}
		if(getMirror(num).equals(num)) {
			System.out.println(num);
			return;
		}
		long normal = Long.parseLong(getMirror(num));
		long plus = Long.parseLong(getMirror(String.valueOf(Integer.parseInt(num.substring(0, num.length()/2))+1) + num.substring(num.length()/2)));
		long minus = Long.parseLong(getMirror(String.valueOf(Integer.parseInt(num.substring(0, num.length()/2))-1) + num.substring(num.length()/2)));
		ArrayList<Long> list = new ArrayList<>();
		list.add(normal);
		list.add(plus);
		list.add(minus);
		long ans = 0;
		long diff = 0;
		for(int i = 0; i < list.size(); i++) {
			if(Math.abs(list.get(i)-Long.parseLong(num)) < diff){
				diff = Math.abs(list.get(i)-Long.parseLong(num));
				ans = list.get(i);
			}else if(Math.abs(list.get(i)-Long.parseLong(num)) == diff) {
				ans = Long.min(ans, list.get(i));
			}
		}
		System.out.println(ans);
		
	}
	
	public static String getMirror(String num) {
		char[] str = num.toCharArray();
		int i = 0, j = str.length - 1;
		while(i < j) {
			str[j--] = str[i++];
		}
		return new String(str);
	}

}
