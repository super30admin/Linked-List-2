### Intuition - Brute Force
    # a. Reverse original LL and keep a copy of original
    # b. Take one node from each and form a LL
    # Example:
    # 1-2-3-4-5 is original
    # 5-4-3-2-1 is reversed
        # Take 1-5-2-4-3 (each from one LL but notice that after 3 we have redundant nodes)
        # we are not using those so instead of reversing whole LL we can revers eat mid point


# Approach: Here we first split the linked list into to finding the mid point
# Then we reverse the second linked list 
# Reorder list by updating the pointers

# Time: O(N)
# Space: O(1) in place modification

# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:

        # null checks
        if head == None or head.next == None or head.next.next == None:
            return

        # 1. To find mid point of Linked List

        slow = head
        fast = head

        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        # after while loop exits, here we get slow as the mid point


        # 2. Now reverse LL from next node from slow (ie slow.next) and reset fast ptr to this new reversed LL's head
        # we need ptrs on both LL's head to merge and reorder them that is why

        fast = self.reverse(slow.next)

        # Now break off connection from LL1 to LL2, and reset slow to head of LL1
        # slow .next is still pointing to reversed LL to cut off connections
        slow.next = None
        
        # same as above fast ptr, assign to head for merging
        slow = head

        # 3. Re order LL

        while fast != None:
            # since fast will be either lesser length or equal to original half list we do this
            # no need to check slow as it belongs to bigger or equal list length

            temp = slow.next # to ensure in next step i dont lose ref to next node
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp # again put it to temp to repeat process

    def reverse(self, head):
        prev = None
        current = head
        fast = current.next

        while fast != None:

            current.next = prev
            prev = current
            current = fast
            fast = fast.next

        current.next = prev
        return current




        