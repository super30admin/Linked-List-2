# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

'''
3 operations:
    1) Split the list into 2 halves. 
    2) Reverse the second half of the list
    3) Reorder the two lists
Time Complexity:
    1) Split -> O(N/2), we iterate over half of the list to split 
    2) Reverse -> O(N/2), second half
    3) Re-order -> O(N/2)
    Total: O(N)
Space Complexity: O(1), no auxillary space. 
'''
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None: # edge case, when empty list or only one element present
            return

        # Step1: split the List in two halves
        slow = head
        fast = head.next

        while fast!=None and fast.next!=None:
            slow = slow.next
            fast = fast.next.next
        
        split_head = slow.next #starting from this node, we need to reverse the list
        slow.next = None # break the link to split the list 
        
        # Step2: reverse the second half of the list
        slow = split_head
        fast = split_head.next

        while fast!=None:
            temp = fast.next
            fast.next = slow
            slow = fast 
            fast = temp
        split_head.next = None
        
        reversed_head = slow

        # Step3: Reorder the list 
        l1_head = head
        l2_head = reversed_head

        while l1_head!=None and l2_head!=None:
            temp = l2_head.next
            l2_head.next = l1_head.next
            l1_head.next = l2_head
            l1_head = l1_head.next.next
            l2_head = temp
        
