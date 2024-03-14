//Sahithra Kesavan
//Period 4
public class LinkedIntList
{
	
	ListNode front;
	
	public LinkedIntList()// Def constructor
	{
		front = null;
	}
	
	public LinkedIntList(int val) //Constructer with param
	{

		front = new ListNode(val);//setting front to val
		
	}
	
public void add(int val) { //add value to end
	 if (front == null) 
	 {
	     front = new ListNode(val); // create first node if list is empty
	 } 
	 else 
	 {
	     ListNode current = front;
	     
	     while (current.next != null) //move thru list until at last node
	     {
	         current = current.next; 
	         
	     }
	         current.next = new ListNode(val); // add new node at the end
	 }
	 }

public void add(int ind, int val) //add at given index
{
    if (ind < 0) //if they input a neg ind
    {
        throw new IndexOutOfBoundsException("Index can't be negative");
    }

    if (ind == 0)
    {
        ListNode newNode = new ListNode(val);
        newNode.next = front;
        front = newNode; // add at the beginning
    }
    else 
    {
        ListNode current = front;
        int currentIndex = 0;
        while (current != null && currentIndex < ind - 1) //go through list until at node before given index
        {
            current = current.next;
            currentIndex++;
        }
        if (current == null) //check if node is null and give exception  if so
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ListNode newNode = new ListNode(val);
        newNode.next = current.next; //connect node to list
        current.next = newNode; // add at the specified index
    }
}
	

	
public int get(int index)
{
    if (index < 0 || front == null) //throw exception if empty/out of bonds
    {
        throw new IndexOutOfBoundsException("Index out of bounds or list is empty");
    }

    ListNode current = front;
    int currentIndex = 0;
    
    while (current != null && currentIndex < index) //go thru list until given index or the end of it
    {
        current = current.next;
        currentIndex++;
    }

    if (current == null) //chec k if current node is null
    {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    return current.data; // Return the value at the specified index
}
	
public int indexOf(int value)
{
    ListNode current = front;
    int index = 0;

    while (current != null) //go thru list
    {
        if (current.data == value) 
        {
            return index; // return the index of the first occurrence of the value
        }
        current = current.next;
        index++;
    }

    return -1; // return -1 if the value never occurs 
}
	
public int remove(int index)
{
    if (index < 0 || front == null) //check if index is negative or list is empty
    {
        throw new IndexOutOfBoundsException("Index out of bounds or list is empty");
    }

    int removedValue;
    
    if (index == 0)
    {
        removedValue = front.data;//store data from node to be remoed
        front = front.next; // Remove the first node
    }
    else 
    {
        ListNode current = front;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) //go thru list to find the node before the given index
        {
            current = current.next;
            currentIndex++;
        }

        if (current == null || current.next == null) //check if current node is null
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        removedValue = current.next.data; //store value to be removed
        current.next = current.next.next; // remove the node at the given index
    }

    return removedValue; //return value of removed node
}
	
public int size() 
{
    int count = 0;
    ListNode current = front; //start from front

    while (current != null) //go thru list and count nodes
    {
        count++;
        current = current.next;
    }

    return count; //return number of nodes
}
public String toString() 
{
    String result = ""; //  empty string to store the result
    ListNode current = front; //start from the front 

    // go thru list 
    while (current != null) {
        result += current.data; // add data of current node to the result

        if (current.next != null)
        {
            result += ", "; // add a comma and space if it's not the last element
        }

        current = current.next;
    }

    return result; // return the string 
}

}
