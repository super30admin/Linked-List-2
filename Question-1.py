#Time Complexity : O(h)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = deque()
        self.node = root
                
    def next(self) -> int:
        while self.node:
            self.stack.append(self.node)
            self.node = self.node.left
            
        current = self.stack.pop()
        self.node = current.right
            
        return current.val

    def hasNext(self) -> bool:
        return self.node or self.stack