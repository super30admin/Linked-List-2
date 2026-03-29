# problem 2
# https://leetcode.com/problems/reorder-list/
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
        all_path = []
        fwd_head = head
        while(fwd_head):
            all_path.append(fwd_head)
            fwd_head = fwd_head.next
        str_idx = 0
        end_idx = len(all_path)-1
        while(str_idx<end_idx):
            all_path[str_idx].next = all_path[end_idx]
            str_idx+=1
            if str_idx < end_idx:
                all_path[end_idx].next = all_path[str_idx]
                end_idx-=1
        all_path[str_idx].next = None