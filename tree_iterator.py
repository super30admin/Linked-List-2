# Author: Naveen US
# Title: Binary Search Tree Iterator

# Time complexity: O(h) 
# Space complexity: O(h)
# Did the code run on leetcode: Yes

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
            self.stack = []
            while root:
                self.stack.append(root)
                root = root.left

    def next(self) -> int:
        node = self.stack.pop()
        if node.right:
            current = node.right
            while current:
                self.stack.append(current)
                current = current.left
        return node.val
        

    def hasNext(self) -> bool:
        return len(self.stack) > 0
        
