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
        ## Brute force Approach
        # TC - O(n) for converting to list + O(n) for creating the linkedlist --> O(n)
        # Sc - O(n) --> for list
        # if not head or not head.next:
        #     return head

        # ## Step 1: Create a list of all nodes
        # temp = head
        # nodes = []
        # while temp:
        #     nodes.append(temp)
        #     temp = temp.next

        # ## Step 2: Reorder using two pointers
        # left, right = 0, len(nodes) - 1
        # while left < right:
        #     nodes[left].next = nodes[right]  # Link left to right
        #     left += 1
        #     if left == right:  # Avoid a cycle in the middle
        #         break
        #     nodes[right].next = nodes[left]  # Link right to left
        #     right -= 1

        # ## Step 3: Terminate the list properly
        # nodes[left].next = None
        # return head

        ## Optimize Method
        ## TC - o(n) -> for each function of find mid is O(n/2), reverse O(n/2) and reordering is O(n/2) --> But in general O(n)
        ## SC - O(1)
        if head == None or head.next == None:
            return head

        mid = self.findMid(head)
        reversedHead = self.reverseList(mid.next) 
        mid.next = None
        slow = head
        fast =  reversedHead
        while fast!= None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

        return head    

    def reverseList(self, head: ListNode) -> ListNode:
        current = head
        prev = None

        while current!= None:
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        return prev

    def findMid(self, head: ListNode) -> ListNode:
        slow, fast = head, head
        while fast.next!= None and fast.next.next!=None:
            fast = fast.next.next
            slow = slow.next
        return slow   

