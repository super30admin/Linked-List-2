// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
        if not head:
            return
        
        #1.Find a middle:
        slow=fast=head      //take two pointers
        while fast and fast.next:   
            slow=slow.next          //slow to increment by one element 
            fast=fast.next.next     //fast will increment by 2 elements => at the end slow will point at mid and fast will point at last node
        
        #2. Reverse 2nd half of list        
        fast=self.reverseList(slow.next)    //this function will reverse the list after mid node
        slow.next=None                      //break the first list at half ie, at mid node
        
        #3. Combine two lists
        slow=head                   //now we have two lists slow and fast
        while fast and slow:        //traverse first element from slow then set the next of slow to fast and set the next of fast to slow.next. then set slow and fast to nexts and nextF. 
            nextS=slow.next
            nextF=fast.next
            
            slow.next=fast
            fast.next=nextS
            
            slow=nextS
            fast=nextF
            
    def reverseList(self,head):
        curr=head
        pre=None
        
        while curr:
            nextt=curr.next
            curr.next=pre
            pre=curr
            curr=nextt
        
        return pre
            
        
        
        
