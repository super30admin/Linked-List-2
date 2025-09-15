# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    # tc : O(n)
    # sc : O(1) no extra space 
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # intution
        # since like arrays i cannot go from tail to the prev node without knowing address
        # brute force : use an extra space like stack data structure to store the nodes and alternaitvely add them up and setting and take care of edge node by setting to null
        # optimal approach : the issue to let me go from last node to the prev node so after L0->Ln->L1->Ln-1 i can go easliy
        # so i will reverse the linked list so after L0, i can add next node as Ln and so on, i can optimize it by not using any extra space but split the current list to two parts
        # First half till start to mid, second half mid+1 to end , reverse the second list and merge them 

        # mid 
        mid = self.mid(head) 
        reverse = mid.next
        mid.next = None

        # reverse
        second_half = self.reverse(reverse) # second list is reverse Ln->Ln-1->Lmid+1
        first_half = head # first half list L0->L1->Lmid->none

        # reordering
        while(second_half is not None): 
            temp1 = first_half.next
            temp2 = second_half.next

            first_half.next = second_half
            second_half.next = temp1

            first_half = temp1
            second_half = temp2

        return head 

            

    # mid
    def mid(self,head): # tc: O(n/2) steps
        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        return slow

    # reverse  # tc : O(n/2)
    def reverse(self,head):
        curr = head
        prev = None

        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev

       