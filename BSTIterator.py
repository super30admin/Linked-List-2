# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#All TC on leetcode passed


class BSTIterator:

    #Here we append all left nodes into the stack
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left
        
    #Here we check if length of stack is greater than 0
    #Time complexity: O(h) in worst case and O(1) averagely. 
    #Because we append elements into stack when there are elements to right of poped TreeNode.
    #Space complexity: O(h)
    def next(self) -> int:
        poped = self.stack.pop()
        
        cur = poped.right
        while cur:
            self.stack.append(cur)
            cur = cur.left
        
        return poped.val
        
    #Here we check if length of stack is greater than 0
    #Time complexity: O(1)
    #Space complexity: O(1)
    def hasNext(self) -> bool:
        return len(self.stack)>0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()