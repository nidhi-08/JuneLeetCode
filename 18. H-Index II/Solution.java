class Solution {
    public int hIndex(int[] citations) {
        if(citations==null){
            return 0;
        }
        int low=0, high=citations.length-1, mid=0;
        while (low <= high) {
            mid = (low+high)/2;
            if (citations.length-mid > citations[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return (citations.length-low);
    }
}

/*
Logarithmic time complexity indicates binary search.

*/
