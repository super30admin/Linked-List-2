# Time Complexity :O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return head
        
        def reverse(head, prev = None):
            start = head
            root = head
            count = 1
            while root!=None:
                root = head.next
                head.next = prev
                prev = head
                head = root
            return prev
        
        root = head
        fast = head
        prev = root
        while fast and fast.next:
            prev = root
            root = root.next
            if fast.next:
                fast = fast.next.next
        
        head2 = reverse(root)
        prev.next = None
        root = head
        root2 = head2
        flag = True
        while root:
            if root2:
                root.next = ListNode(root2.val, root.next)
                root2 = root2.next
            if root.next and root.next.next:
                root = root.next.next
            else:
                root = root.next