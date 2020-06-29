class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
		// build graph 
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> path = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty())
                stack.push(flights.get(stack.peek()).poll());
			path.addFirst(stack.pop());
        }
        
        return path;
    }
}
/*
This is an application of Hierholzer’s algorithm to find a Eulerian path.

PriorityQueue should be used instead of TreeSet, because there are duplicate entries.
*/
