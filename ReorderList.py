# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        mid=self.calculateMid(head)
        newpointer=mid.next
        mid.next=None
        newlist=self.reverse(newpointer)
        one=head
        two=newlist
        three=head.next
        while(three!=None):
            one.next=two
            two.next=three
            two=two.next
            one=three
            three=three.next
        return head
        
    def calculateMid(self,head):
        fast=head
        slow=head
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast=fast.next.next
        return slow
    
    def reverse(self,newpointer):
        prev=None
        curr=newpointer
        fast=curr.next
        while(fast!=None):
            curr.next=prev
            prev=curr
            curr=fast
            fast=fast.next
        curr.next=prev
        return curr
        
 #Time complexity is O(n)
 sample 1->2->3->4-->5
 #i am confused for space complexity, I am making a new Linkedlist for this so 1->-3->Null is pointed by head and
 and there is one new newlist which points to 4->5->null, then I am merging them, so will this newlist will make the solution O(n)?
