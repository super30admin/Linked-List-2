//Time Complexity: O(n)
//Sapce Complexity: O(n)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        HashMap<Integer,ListNode> map = new HashMap<>();
        int index=0;
        ListNode temp =head;
        while(temp!=null){
            map.put(index,new ListNode(temp.val));
            temp=temp.next;
            index++;
        }
       int mid = (index+1)/2;
        ListNode t2 = head;
        for(int j=index;j>mid;j--){
            ListNode nextNode = new ListNode();
            if(t2.next!=null) nextNode = t2.next;
            else nextNode = null;
            t2.next= map.get(j);
            t2.next.next=nextNode;
            t2=nextNode;
        }
        
    }
}
