// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Step 1: We get the lengths of both of the lists
// Step 2: We decrement the larger list until it becomes the length of the smaller list
// Step 3: In the last while, we start incrementing both the lists and stop when they meet.
// Whenever they do meet, we return either head(since they're both at the same place).
// This also handled the null case. If there is no intersection, they will both meet at null and that is what we will return

var getIntersectionNode = function (headA, headB) {
  let sizeA = 0;
  let sizeB = 0;

  let currentValA = headA;
  let currentValB = headB;

  while (currentValA !== null) {
    sizeA++;
    currentValA = currentValA.next;
  }

  while (currentValB !== null) {
    sizeB++;
    currentValB = currentValB.next;
  }

  // Instead of reassigning the current vals, we can just use
  // the heads that were given to us.
  // currentValA = headA;
  // currentValB = headB;

  while (sizeB > sizeA) {
    sizeB--;
    headB = headB.next;
  }

  while (sizeA > sizeB) {
    sizeA--;
    headA = headA.next;
  }

  while (headA !== headB) {
    headA = headA.next;
    headB = headB.next;
  }

  return headB;
};
