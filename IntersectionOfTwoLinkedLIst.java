import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Time Complexity: O(N)
Space Complexity: O(N) using HashSet
 */
public class IntersectionOfTwoLinkedLIst {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode intersectionNode(ListNode first, ListNode second){
        ListNode f = first;
        ListNode s = second;
        HashSet<ListNode> set = new HashSet<>();

        while(f!= null){
            set.add(f);
            f = f.next;
        }

        while(s!= null){
            if(set.contains(s)){
                return s;
            }
            s = s.next;
        }
        return null;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(4);
        ListNode first1 = new ListNode(1);
        ListNode second1 = new ListNode(8);
        ListNode third1 = new ListNode(4);
        ListNode fourth1 = new ListNode(5);
        node1.next = first1;
        first1.next = second1;
        second1.next = third1;
        third1.next = fourth1;
        fourth1.next = null;

        ListNode node2 = new ListNode(5);
        ListNode first2 = new ListNode(6);
        ListNode second2 = new ListNode(1);
        node2.next = first2;
        first2.next = second2;
        second2.next = second1;

        System.out.println("Intersecting point: "+intersectionNode(node1, node2).val);
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Hllo", "Pir"));
        System.out.println(words);
    }
}
