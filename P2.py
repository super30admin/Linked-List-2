# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# TC : O(n)
# SC : O(n) # using list
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        dummy = head
        l = []
        while dummy:
            l.append(dummy.val)
            dummy = dummy.next
        dummy2 = head
        while l:
            try :
                dummy2.val = l.pop(0)
                dummy2 = dummy2.next
                dummy2.val = l.pop(-1)
                dummy2 = dummy2.next
            except:
                break
            
#         # finding mid
#         slow = head
#         fast = head.next
#         mid = 0
#         while True:
#             try :
#                 slow = slow.next
#                 fast = fast.next.next
#                 mid += 1
#             except:
#                 break
#             # print(slow, fast,"ok", mid)
#         # first half linked list
#         dummy = head
#         i = 0
#         first_half = []
#         print(mid)
#         while i <= mid:
#             first_half.append(dummy.val) 
#             i += 1
#             dummy = dummy.next
#         print(dummy.val, first_half)
        
#         # reversing the second half linked list