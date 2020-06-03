class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) ->  Math.abs(b[0]-b[1]) - Math.abs(a[0] - a[1]));
        int cityA = 0, cityB = 0;
        int mincost = 0;
        for(int i=0;i<costs.length;i++){
            if(cityA >= costs.length/2 || (costs[i][1] < costs[i][0]  &&  cityB<costs.length/2) ){
                    //if city A already has half people 
                    // or if cost of travelling to city B is less than travelling to city A
                    //and city B has less than half people
                cityB++;    //add person to city B
                mincost += costs[i][1];  //adding cost of travel to total cost
            }
            else{
                    //when cost of travelling to A is less than that of B
                    //condition when B already has half the people
                cityA++;    //add person to city A
                mincost +=costs[i][0];   //adding cost of travel to total cost
            }
        }
        
        return mincost;
    }
}
