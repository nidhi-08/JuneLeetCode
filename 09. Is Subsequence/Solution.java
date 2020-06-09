class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())  //if substring is greater than original string
            return false;
        
        int i = 0, j = 0;
        int n1 = s.length(), n2 = t.length(); 
        while ((i < n1) && (j < n2)) {
            if (s.charAt(i) == t.charAt(j))     //comparing if characters are equal
                i ++;
            j++;
       }
    return i == n1;
    }  
}
