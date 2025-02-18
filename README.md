# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

# Append the root first and then the left elements.
# The next() method should always return the next minimum element in the BST. 
# Whenever an element is popped from the stack that is used, push that node's right element and then 
# all its left elements till the last left element.

## Problem2 (https://leetcode.com/problems/reorder-list/)

# Create a function to reverse the linked list nodes, we take current, previous and next nodes. Assign 
# the next node with previous where previous is initialized as 'None'. Assign the previous as current
# and the current node as next which reverses the direction.
# We make the next node as next of next node and current as previous node for the next iteration.
# Find the mid element by using slow and fast pointers. Approach to the last element and link the 
# first element to the last. The element is found by checking the fast pointer with 'Null'.
# We recursively do this by assigning elements of the 1st half to the elements of reversed second half
# of the linked list.

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

# Get the current nodes next value and store it in the current node
# Make the current node's next value as None - essentially deleting it

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

# We find the lengths of both the linked lists and check for the greater list
# Find the intersection and based on the larger length we move the head of A or B
# When both the heads are at the same intersection point we will return the node.