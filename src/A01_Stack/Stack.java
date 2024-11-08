package A01_Stack;


public class Stack<T>
{
	 private Node<T> first;
     private int counter = 0;
    /**
     * Oberstes Element entfernen und zur�ckliefern.
     * Existiert kein Element, wird eine Exception ausgel�st.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {
        if (counter == 0)
            throw new StackEmptyException();
        Node<T> top = first;
        first = first.getNext();
        counter--;
    	return top.getData();
    }
    
    /**
     * �bergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {
        Node<T> newNode = new Node<>(i);
        newNode.setNext(first);
        counter++;
        first = newNode;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return counter;
    }
}
