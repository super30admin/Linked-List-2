public class DeleteWithoutHeadPointer {
    
    //Linked List = 10 -> 20 -> 4 -> 30, del_node = 20 
    // I have the head pointing to 10 and del_node pointing to the delete node
    
    // traverse the linked list from delete node and at each step copy the next val if present and I might need a dummy node to 

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){
        }
        ListNode(int val,ListNode next){
            this.val = val ;
            this.next = next;
        }
    }
    private void del_node(ListNode delNode){
        delNode.val = delNode.next.val;
        delNode.next = delNode.next.next; 
    }


    public static void main(String[] args){
        DeleteWithoutHeadPointer obj = new DeleteWithoutHeadPointer();
        ListNode node1 = new ListNode(10,null);
        ListNode node2 = new ListNode(20,null);
        ListNode node3 = new ListNode(30,null);
        ListNode node4 = new ListNode(40,null);
        ListNode node5 = new ListNode(50,null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = node1;
        System.out.println(head.val);
        obj.del_node(node1);
        System.out.println(head.val);
    }
    
}
