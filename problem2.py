#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
#By using 2 pointer approach and moving one pointer faster than the second pointer, we can find the middle element of the linked list. Now , we can reverse the second half of the linked list. After reversing the second half, we can interleve the elemnts from the first half and second half.  
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
        first=head
        second=head
        while(first and first.next):
            first=first.next
            if(first==None):
                second=second.next
                break
            first=first.next
            second=second.next
        print(second.val)
        curr=second
        prev=None
        nxt=curr.next
        while(True):
            curr.next=prev
            prev=curr
            curr=nxt
            if(curr==None):
                break
            nxt=nxt.next
        p1=head
        p2=prev
        t1=p1.next
        t2=p2.next
        while(t1 and t2):    
            p1.next=p2
            p2.next=t1
            p1=t1
            p2=t2
            t1=t1.next
            t2=t2.next
        return head
        
