class Solution {
    public String getPermutation(int n, int k) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);          // initialize all numbers
		}	
		k--;                // change k to be index
 
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}       // set factorial of n
 
		String result = "";
 
		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			int curIndex = k / mod;     // find the right number(curIndex) of
			k = k % mod;        // update k
			result += numberList.get(curIndex);     // get number according to curIndex
			numberList.remove(curIndex);        // remove from list
		}
		return result.toString();
    }
}
