# // Time Complexity : O(m+n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
## we take two pointers starting from each linked list. This approach is same as get the length of both the linked list
## and pushing the pointer on the longer list to match that of shorter list. and then iterating through them at the same time until we find the 
## intersection.

## in this approach the moment any of the pointer comes to end we shift it to the other linked list. This is because both the pointers
## will travel the same distance till the intersection.

class solution:
    def intersection(self, headA, headB):
        if not headA or not headB:
            return None
        ptr1 = headA
        ptr2 = headB

        while ptr1!= ptr2:
            if ptr1 == None:
                ptr1 = headB
            else:
                ptr1 = ptr1.next
            
            if ptr2 == None:
                ptr2 = headA
            else:
                ptr2 = ptr2.next
        
        return ptr1
