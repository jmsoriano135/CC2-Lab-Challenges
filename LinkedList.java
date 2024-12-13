// Soriano, JM P.
// CITCS1N
// Final Challenge No. 4 : Linked Lists Application

public class LinkedList {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("https://facebook.com");
        
        browserHistory.visit("https://youtube.com");
        browserHistory.printCurrentPage();  // Current Page: https://youtube.com

        browserHistory.visit("https://netflix.com");
        browserHistory.printCurrentPage();  // Current Page: https://netflix.com

        System.out.println("Back: " + browserHistory.back(1));  // Back: https://youtube.com 
        browserHistory.printCurrentPage();  // Current Page: https://youtube.com

        System.out.println("Forward: " + browserHistory.forward(1));  // Forward: https://netflix.com
        
        browserHistory.visit("https://github.com");                   // clears forward history
        browserHistory.printCurrentPage();   // Current Page: https://github.com
        
        System.out.println("Back: " + browserHistory.back(2));           // Back: https://facebook.com (no previous page)
        
        System.out.println("Forward: " + browserHistory.forward(1));     // Forward: null (no next page)
        
        browserHistory.printCurrentPage();  // Current Page: https://facebook.com
    }
}

class Node {
    String url;       // URL of the node
    Node prev;       // Pointer to the previous node
    Node next;       // Pointer to the next node

    public Node(String url) {
        this.url = url;   // Initialize the URL
        this.prev = null; // Initially, there is no previous node
        this.next = null; // Initially, there is no next node
    }
}

class BrowserHistory {
    private Node head; // Head of the doubly linked list
    private Node tail; // Tail of the doubly linked list
    private Node curr; // Current node representing the current page

    public BrowserHistory(String homepage) {
        head = new Node(homepage); // Create a new node for the homepage
        tail = head;               // Set tail to head initially
        curr = head;               // Set current to head initially
    }

    public void visit(String url) {
        Node newNode = new Node(url);  // Create a new node for the visited URL
        curr.next = newNode;           // Link current node to the new node
        newNode.prev = curr;           // Link new node back to current node
        curr = newNode;                // Update current to the new node
        tail = newNode;                // Update tail to the new node
        clearForwardHistory();          // Clear forward history when visiting a new page
    }

    public String back(int steps) {
        while (curr.prev != null && steps > 0) { // Ensure we don't go beyond head
            curr = curr.prev;  // Move back in history
            steps--;           // Decrement steps left to move back
        }
        return curr.url;      // Return current URL after moving back
    }

    public String forward(int steps) {
        while (curr.next != null && steps > 0) { 
            curr = curr.next;  
            steps--;           
        }
        return curr.url;      
    }

    public String getCurrentUrl() {
        return curr.url;      // Return the URL of the current page
    }

    private void clearForwardHistory() {
        if (curr.next != null) {
            curr.next = null;  // Disconnect all forward nodes from current position
            tail = curr;       // Update tail to current as there are no more forward nodes
        }
    }

    public void printCurrentPage() {
        System.out.println("Current Page: " + getCurrentUrl());
    }
}
