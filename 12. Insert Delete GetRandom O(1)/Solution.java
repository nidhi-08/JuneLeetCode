class RandomizedSet {
    Map<Integer, Integer> set;      
                //we need map for insert and remove in O(1) time
                    //but it doesn't use indices so random element will be an issue
    List<Integer> list;
                //so we use list to get a random element in O(1) time
                //but to remove it we will need O(n) time so we don't remove it from the list 
                //but we remove the element from the map and hence ew need two DS.
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set= new HashMap<Integer, Integer>();
        list=new ArrayList<>();
        random=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.containsKey(val)){
            return false;
        }
        else{
            list.add(val);
            set.put(val, list.size() -1);
            return true;
        }
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.containsKey(val)){
            return false;
        }
        else{
            int index = set.get(val);       //getting the index of the number
            int lastElement = list.get(list.size() - 1);    //index of last element
            list.set(index, lastElement);       //putting number as last element in list
            set.put(lastElement, index);        //putting last element at the index in map
                    //here we have swapped the number with the last number in the list
                    //effectively removing the number from the list and map
            list.remove(list.size()-1);       //complexity to remove the last element in the ArrayList is O(1)
            set.remove(val);
            return true;
        }
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
