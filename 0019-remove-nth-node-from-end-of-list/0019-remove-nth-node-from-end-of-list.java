
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    
    public static ListNode deserialize(String data) {
        data = data.trim();
        if (data.equals("[]") || data.length() == 0) return null;
        data = data.substring(1, data.length() - 1); 
        String[] vals = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String s : vals) {
            curr.next = new ListNode(Integer.parseInt(s.trim()));
            curr = curr.next;
        }
        return dummy.next;
    }

    
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(",");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        
        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        
        ListNode head1 = ListNode.deserialize("[1,2,3,4,5]");
        head1 = sol.removeNthFromEnd(head1, 2);
        System.out.println(head1.serialize()); 

        
        ListNode head2 = ListNode.deserialize("[1]");
        head2 = sol.removeNthFromEnd(head2, 1);
        System.out.println(head2 == null ? "[]" : head2.serialize()); 

        
        ListNode head3 = ListNode.deserialize("[1,2]");
        head3 = sol.removeNthFromEnd(head3, 1);
        System.out.println(head3.serialize()); 
    }
}
