#time: O(n)
#space: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        # 1 divide the list in two parts
        slow=head
        fast= head
        while fast.next != None and fast.next.next != None:
            slow=slow.next
            fast= fast.next.next
        list2= slow.next
        slow.next = None
        #2 reverse 2nd list
        curr= list2
        prev= None
        nxt= curr.next
        while nxt != None:
            temp = curr
            curr.next= prev
            prev=temp
            curr= nxt
            nxt = nxt.next
        curr.next = prev
        #3 merging the lists
        fast = curr
        slow = head
        while fast is not None:
            temp= slow.next
            slow.next= fast
            fast= fast.next
            slow.next.next= temp
            slow= temp
        return head
