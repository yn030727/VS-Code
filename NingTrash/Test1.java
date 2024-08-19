package NingTrash;
class Main{
    public static void main(String[] args) {
        Main main = new Main();
        main.reverList(new ListNode());
        reverList(null);
    }

    public static void reverList(ListNode head) {
        
    }
}

class ListNode{
    int val;
    ListNode next;
    
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}