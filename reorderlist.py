#Space:O(1)
#Time:O(N)
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        root = head
        def middle(root):
            slow=fast=root
            while(fast and fast.next):
                slow=slow.next
                fast=fast.next.next
            return slow
        
        def reverse_list(root):
            prev=None
            while(root):
                temp = root.next
                root.next = prev
                prev = root
                root = temp
            return prev
        
        root_first = ans = root
        root_second = reverse_list(middle(root))
        # print(root_first.val,root_second.val)
        while(root_second.next):
            print(root_first.val,root_second.val)
            temp_first = root_first.next
            temp_second = root_second.next
            root_first.next = root_second
            root_second.next = temp_first
            root_first = temp_first
            root_second = temp_second
        return ans