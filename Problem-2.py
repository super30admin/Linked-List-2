# Reorder List 

# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def reorderList(self, head: Optional[ListNode]) -> None:
    """
    Do not return anything, modify head in-place instead.
    """
    
    # Find the middle of the Linked List
    slow, fast = head, head
    while fast and fast.next :
        slow = slow.next
        fast = fast.next.next
    
    # Reverse the second half of the LL
    right = slow.next
    slow.next = None
    prev, cur = None, right
    while cur:
        k = cur.next
        cur.next = prev
        prev, cur = cur, k
    
    # Merge the two list, by intertwining them 
    l, r = head, prev
    while l and r: 
        next_l, next_r = l.next, r.next
        l.next = r
        r.next = next_l
        l, r = next_l, next_r