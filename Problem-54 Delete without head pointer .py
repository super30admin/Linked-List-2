# Delete without head pointer 
# https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

# Time Complexity: O(1)
# Space Complexiety: O(1)

# if ptr is the node given and it points to the node that is to be deleted.
if ptr.next:
    ptr.val = ptr.next.val
    ptr.next = ptr.next.next
else:
    ptr = None