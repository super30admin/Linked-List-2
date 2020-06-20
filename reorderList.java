// Time Complexity : O(2n) // 1 to find size+add arraylist elements , 1 to create new list.
// Space Complexity : O(2n) // a Array List + n-1 new nodes
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : A little bit trying to figure out where to
// reduce memory. But I could not think of a solution without extra memory.


// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null)
            return;
        
        List<Integer> listValues=new ArrayList<>();
        
        ListNode traverse=head;
        int count=0;
        while(traverse!=null){
            listValues.add(traverse.val);
            traverse=traverse.next;
            count++;
        }
        traverse=head;
        int high=listValues.size()-1;
        int low=1;
        
        while(count-->1)
        {
            traverse.next=new ListNode(listValues.get(high--));
            traverse=traverse.next;
            if(low<high)
            {
            traverse.next=new ListNode(listValues.get(low++));
            traverse=traverse.next;
            }
                if(low>high)
                break;
        }
        
        traverse.next=null;
    }
}