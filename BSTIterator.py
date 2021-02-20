# // Time Complexity : O(1) for operations. Dont consider the time complexity of implementation in design problems
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# CONTROLLED RECURSION
# use stack. declare in constructor
# go left -> left -> lfet (create dfs function)and append(root)
# hasNext => return len(stack) != 0
# next() => pop and return value
# after poping look if node has right and do dfs on that to go left left left
# This Always keeps the next element at top  


class BSTIterator:
    
    stack = deque()
    
    def __init__(self, root: TreeNode):
        self.stack = deque()
        self.dfs(root)
        
        
    def next(self) -> int:
        if self.hasNext:
            #if right found go left down
            x = self.stack.pop()
            if x.right:
                self.dfs(x.right)
            # return top most element
            return x.val
        

    def hasNext(self) -> bool:
        # if stack is empty then no next
        return len(self.stack) != 0
    
    def dfs(self,root):
        # until the root is NONE go donw left
        while root:
            # fill the stack
            self.stack.append(root)
            root = root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()