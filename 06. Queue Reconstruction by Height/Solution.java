class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[0] == y[0] ? x[1] - y[1] 
                    : y[0] - x[0];
            }
        });
        
        for(int[] person : people) {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
