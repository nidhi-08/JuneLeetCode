class Solution {
  public int findDuplicate(int[] nums) {
                   // Find the intersection point of the two runners.
    int tortoise = nums[0];
    int hare = nums[0];     //set both pointers to initial point
    do {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
    } while (tortoise != hare);

                  // Find the "entrance" to the cycle.
    tortoise = nums[0];
    while (tortoise != hare) {
      tortoise = nums[tortoise];
      hare = nums[hare];
    }

    return hare;
  }
}

/*
This is the Floyd's Tortoise and Hare (Cycle Detection) method:
The idea is to reduce the problem such that given a linked list, return the node where the cycle begins.
The cycle appears because nums contains duplicates. The duplicate node is a cycle entrance.

Algorithm
Floyd's algorithm consists of two phases and uses two pointers, usually called tortoise and hare.
In phase 1, hare = nums[nums[hare]] is twice as fast as tortoise = nums[tortoise]. 
Since the hare goes fast, it would be the first one who enters the cycle and starts to run around the cycle. 
At some point, the tortoise enters the cycle as well, and since it's moving slower the hare catches the tortoise up at some intersection point. 
Now phase 1 is over, and the tortoise has lost.
Note that the intersection point is not the cycle entrance in the general case.
In phase 2, we give the tortoise a second chance by slowing down the hare, so that it now moves with the speed of tortoise: 
tortoise = nums[tortoise], hare = nums[hare]
The tortoise is back at the starting position, and the hare starts from the intersection point.



*/
