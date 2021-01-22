# TC: for next, hashnext: O(1)
# SC: O(H)
# Controlled recursion
# We make controlled dfs recursion. We are only bothered about the immediate next element. Hence we make sure top of stack is always out next element. Once we pop and go to the immediate right and to the leftmost node from that point - we pause our usual inorder flow at this point until next pop. At this point stack top is the nect element. As long as stack has elements, we have next elements 
class BSTIterator:

    def __init__(self, root):
        self.stack = []
        self.dfs(root)
        
    def next(self) -> int:
        res = self.stack.pop()
        self.dfs(res.right)
        return res.val        

    def hasNext(self) -> bool:
        return True if self.stack else False
        
    def dfs(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left
            