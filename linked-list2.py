# problem 1 : 173. Binary Search Tree Iterator : https://leetcode.com/problems/binary-search-tree-iterator/
# Time Complexity : O(1) amortized
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.nodes = []
        while root :
            self.nodes.append(root)
            root = root.left        

    def next(self) -> int:
        """
        @return the next smallest number
        """
        res = self.nodes.pop()
        ans = res.val
        if res.right:
            res = res.right
            while res:
                self.nodes.append(res)
                res = res.left
        return ans

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.nodes) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


# problem 2: 143. Reorder List : https://leetcode.com/problems/reorder-list/
# Time Complexity : O(n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return head
        
        middle = self._getMiddle(head)
        second = self._reverse(middle.next)
        middle.next = None
        start = head
        while start and second:
            temp = start.next
            start.next = second
            temp2 = second.next
            second.next = temp
            start = temp
            second = temp2
        return head
    
    def _getMiddle(self, node: ListNode) -> ListNode:
        slow, fast = node, node
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def _reverse(self, node: ListNode) -> ListNode:
        prev = None
        curr = node
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
        


# problem 3 : Delete without head pointer : https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
# Time Complexity : O(1) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

def deleteNode(curr_node):
    #code here
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next



# problem 4 : 160. Intersection of Two Linked Lists : https://leetcode.com/problems/intersection-of-two-linked-lists/
# Time Complexity : O(max(m,n)) where m and n are length of lists 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
###          Go from the last node of smaller list to bigger list head. 
#         if headA == None or headB == None:
#             return None

#         A_pointer = headA
#         B_pointer = headB

#         while A_pointer != B_pointer:
#             A_pointer = headB if A_pointer == None else A_pointer.next
#             B_pointer = headA if B_pointer == None else B_pointer.next

#         return A_pointer

### find length of both list. Find differenc in lengths. Move pointer of bigger list forward by difference then move both list one step till intersection point found of end is reached
        if headA == None or headB == None :
            return None
        lenA, lenB= 0, 0
        diff = 0
        ha = headA
        while ha is not None :
            lenA += 1
            ha = ha.next
        hb = headB
        while hb is not None :
            lenB += 1
            hb = hb.next
            
        
        if lenA > lenB :
            diff = lenA - lenB
            ha, hb = headA, headB
            while diff != 0 :
                ha = ha.next 
                diff -= 1
            
            while ha is not None :
                if ha == hb :
                    return ha
                ha = ha.next
                hb = hb. next

        else :
            diff = lenB - lenA
            ha, hb = headA, headB
            while diff != 0 :
                hb = hb.next 
                diff -= 1
            
            while hb is not None :
                if ha == hb :
                    return hb
                ha = ha.next
                hb = hb. next

        return None

              
