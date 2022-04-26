#reorder list
# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no




def reorderList( head):
    slow=head
    fast=head
    while(fast.next !=None and fast.next.next!=None):                       #find the midpoint first; make slow the midpoint
        slow=slow.next
        fast=fast.next.next
        
    fast=reverse(slow.next)                                                     #reverse the right half of the linked list
    slow.next=None
    slow=head
    while(fast!=None):                                                          #connect the linkedlist in a zigzag order
        temp=slow.next
        slow.next=fast
        fast=fast.next
        slow.next.next=temp
        slow=temp
        
def reverse(head):                                                          #helper function to find the reverse of a linkedlist
    if head==None: return head
    prev=None
    curr=head
    nex=head.next
    while(nex!=None):
        curr.next=prev
        prev=curr
        curr=nex
        nex=nex.next
    curr.next=prev
    return curr