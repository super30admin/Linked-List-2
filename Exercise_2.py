#Time Complexity : O(N), N being length of array.
#Space Complexity : O(1), no additional array is used.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Forgot the second fast.next in the beginning, 
# then had issues with the reorder/merge part and the reverse part. 
#Your code here along with comments explaining your approach in three sentences only
'''Find the mid value, and then reverse the second half of array. The merge the two 
half arrays. 
'''
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #find mid and end with fast and slow pointer
        head1 = head
        slow = head
        fast = head
        while(fast.next!=None):
            fast = fast.next
            if fast.next==None:
                break
            else:
                fast = fast.next
            slow = slow.next
        
        #reverse 2nd half
        tail2 = slow.next
        slow.next = None

        if tail2==None:
            return 
        next_node = tail2.next
        tail2.next = None
        while(next_node!=None):
            temp = next_node
            next_node = next_node.next
            temp.next = tail2
            tail2 = temp

        #merge
        while(tail2!=None and head1!=None):
            temp_head = head1.next
            head1.next = tail2
            head1 = tail2
            tail2 = temp_head
   


        


        