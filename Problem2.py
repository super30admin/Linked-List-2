# Time Complexity : O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Node:
    def __init__(self,x):
        self.val = x 
        self.next = None 
        
class Solution:
    def reorderList(self, head):
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return head 
        slow = head 
        fast = head 
        while fast and fast.next:
            slow = slow.next 
            fast = fast.next.next 
        fast = self.__reverse(slow.next)
        slow.next = None 
        slow = head 
        while fast:
            curr = slow.next 
            slow.next = fast 
            fast = fast.next 
            slow.next.next = curr 
            slow = curr 
        return head 
    
    def __reverse(self,node):
        if not node or not node.next:
            return node
        prev = None 
        fast = node.next 
        while fast:
            node.next = prev 
            prev = node 
            node = fast 
            fast = fast.next 
        node.next = prev 
        return node 

if __name__ == "__main__":
    s = Solution()
    n = Node(1)
    n.next = Node(2)
    n.next.next = Node(3)
    n.next.next.next = Node(4)
    n.next.next.next.next = Node(5)
    n.next.next.next.next.next = Node(6)
    res = s.reorderList(n)
    s = []
    while res:
        s.append(res.val)
        res = res.next 
    print(s)