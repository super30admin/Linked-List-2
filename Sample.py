# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    
    """
    Description: Find the node at which the intersection of 2 singly linked-lists begins
    
    Time Complexicity: O(n)
    Space Complexicity: O(1)
    
    Approach:
    1. find difference in lengths of two list (say d)
    2. depending on whichever list is longer start moving by ignoring first d nodes in longer list
    3. return the matching node
    """
    
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
    
        lenA = 0; lenB = 0
        
        currNode = headA
        while currNode != None:
            currNode = currNode.next
            lenA += 1
        
        currNode = headB
        while currNode != None:
            currNode = currNode.next
            lenB += 1
            
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
            
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
            
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    def reorderList(self, head: ListNode) -> None:

        """
        Description: Reorder a linked list
        
        Time Complexicity: O(n)
        Space Complexicity: O(1)
        
        Leetcode Comment:- Do not return anything, modify head in-place instead.
        
        Approach:
        1. Find middle of the linked list
        2. from mid point onwards, reverse the linked list and shorten the orginal linked list until mid point
        3. use both linked list to merge and re-order 
        
        """
        
        if head == None or head.next == None:
            return 
        
        slow = head; fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head

        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            
    # Function to get reverse linked list
    def reverse(self, head):
        prev = None
        while head:
            temp = head
            head = head.next
            temp.next = prev
            prev = temp
        
        return prev 
 
def deleteNode(node):
    
    """
    Description: delete a node without known head node
    
    Time Complexicity: O(n)
    Space Complexicity: O(1)
    
    Approach:
    1. Use value of next node and replace with current node's value
    2. Now, move node.next to the node.next.next to get rid of next index
    """
    
    node.val = node.next.val   # copy value from next node)
    node.next = node.next.next # point to the next value effectively removing the node
    
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:

    """
    Description: Implement a BST iterator for in-order traversal of a BST
    
    Time Complexicity: O(n)
    Space Complexicity: O(n) {for recursive stack}
    
    Approach:
    Instead of a regular recursion, stop the recursion at every value (create a stack)
    - to be aware that only next and has.next are up
    - stop the recursive stack at every traversal value by poping a stack and return from next()
    - for hasNext, just verify if the stack is empty or not
    """
    
    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        result = self.stack.pop()
        self.dfs(result.right)
        return result.val

    def hasNext(self) -> bool:
        return not len(self.stack) == 0
    
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()    
    
