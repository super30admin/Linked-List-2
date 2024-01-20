
"""
143. Reorder List
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 
Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

 
Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000


"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Explanation:
        Find the middle of the list. Reverse the list from the middle. Then merge the two lists.
    """
    def reorderList(self, head: Optional[ListNode]) -> None:
        dummy = ListNode(-1)
        slow, fast = head, head
        while fast.next is not None and fast.next.next is not None: #finding mid
            slow = slow.next
            fast = fast.next.next
        # preparing for reversing the second list
        head2 =  slow.next
        slow.next = None
        prev = None
        walker = head2
        while walker is not None: # inplace reverse
            tmp = walker.next
            walker.next = prev
            prev = walker 
            walker = tmp
        walker = dummy
        head2 =  prev
        while head is not None: #merging the two lists, head and head2
            temp = head.next
            walker.next = head
            head.next = None
            walker = walker.next
            head = temp
            if head2 is None:
                break
            temp = head2.next
            walker.next = head2
            head2.next = None
            walker = walker.next
            head2 = temp
        return dummy.next # not required, technically the list is reordered in place
    
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Explanation:
        Traverse the list and store the nodes in a stack. Als maintain a walker node to traverse the list.
        Then pop the nodes from the stack and insert them after the walker node.
        This will result in the list being reordered.
    """
    def reorderList(self, head: Optional[ListNode]) -> None:
        dummy = ListNode(-1)
        stack = deque()
        walker = head
        size = 0
        while walker is not None:
            stack.append(walker)
            walker = walker.next
            size += 1
        beg = head
        walker = dummy
        for i in range(size//2) :
            end = stack.pop()
            end.next = head.next
            head.next = end
            head= head.next.next
        head.next = None

LeetCode(PROBLEM, Solution).check()
