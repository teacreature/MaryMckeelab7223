public class SinglyLinkedList {
private Node head;

private class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
  // adding method creates a new node that holds data, then it points to the head of the node, and then replaces the head with the new node
  private void addFirst(int data){
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;

  }

  // add last creates new node with data value, then checks if there are are any values in the list, if not then the value becomes the head. if there are values in the list it searches the list until there are no next values and places the new node
  private void addLast(int data){
    Node newNode = new Node(data);
    if (head == null){
      head = newNode;
    }
    else {
      Node current = head;
      while (current.next != null){
        current = current.next;
      }
      current.next = newNode;
    }
  }

  private void removeByValue(int data){
    Node current = head;
    Node last = null;

    while (current != null){
      if (current.data == data){
        if (last == null){
          head = current.next;
        }
        else {
          last.next = current.next;
        }
        return;
      }
      last = current;
      current = current.next;
    }
  }

  public static void bubbleSortA(SinglyLinkedList list){
    int listLength = getLength(list);
    int temp; 
    Node current = list.head;

    for (int i = 0; i < listLength; i++){
      if (current.data > current.next.data){
        temp = current.next.data;
        current.next.data = current.data;
        current.data = temp;
      }
    }
  }

  public static void bubbleSortD(SinglyLinkedList list){
    int listLength = getLength(list);
    int temp; 
    Node current = list.head;

    for (int i = 0; i < listLength; i++){
      if (current.data < current.next.data){
        temp = current.next.data;
        current.next.data = current.data;
        current.data = temp;
      }
    }
  }

  private static int getLength(SinglyLinkedList list){
    if (list.head == null){
      System.out.println("List is empty");
    }

    int length = 1;
    Node current = list.head;
    while (current.next != null){
      length++;
      current = current.next;
    }
    return length;
  }

  //additional method for printing the list so i can be sure that the values are being added properly
  private static void displayList(SinglyLinkedList list){
    Node current = list.head;
    System.out.println("Linked list: ");
    while (current != null){
      System.out.println(current.data);
      current = current.next;
    }
  }

  
  // Method for demonstration purposes
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        displayList(list);
        list.addLast(0);
        displayList(list);
        list.addFirst(2);
        displayList(list);

        list.removeByValue(1);
        // Add more demonstration code as needed
      System.out.print("Unsorted list: ");
      displayList(list);
      System.out.print("Sorted list in ascending order: ");
      bubbleSortA(list);
      displayList(list);

      System.out.print("Sorted list in descending order: ");
      bubbleSortD(list);
      displayList(list);

    }

}
