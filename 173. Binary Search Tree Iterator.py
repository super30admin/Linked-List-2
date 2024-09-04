# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class BSTIterator:
    '''
    - Use controlled recursion to maintain a stack in advance
    - stack will always recursively be updated to maintain the node inorder
    '''

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.recurse(root)
    
    def recurse(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        temp = self.stack.pop()
        self.recurse(temp.right)
        return temp.val

        
    def hasNext(self) -> bool:
        if len(self.stack) > 0:
            return True
        else:
            return False