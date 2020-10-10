# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
Approach:
Used stack to store the elements. Store the left side elements of the stack. Once next() method to return the minimum is called, top of the stack (Which will always contain min value will be returned). Before popping, I haved checked whether that element has a right side node or not. If yes then store that in the stack as well.

## Problem2 (https://leetcode.com/problems/reorder-list/)
Appraoch:
Divided the list into 2 halfs. Reversed the second half of the list and then linked 1st element of first half to first element of reversed half and joined that second element to third element of first half and so on till list is completed.

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
We have provided with the node that has to be deleted. Copy the next node's value in the current node and do node.next = node.next.next.

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
Appraoch:
If the length of both lists is same, then there is no problem finding the interaction. But if its not then used an approach of two pointers where any one of the pointer reached null first will be assigned to head of the opposite list and similiarily 2nd pointer will be assigned to the head of the other list. Using this we will eliminate that extra distance between two lists. Then just traverse by one position and return when both pointers are equal. 
