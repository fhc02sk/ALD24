package A02_Queue;

public class Queue<T>
{
    private Node<T> first;
    
    private Node<T> last;
    private int counter;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zur�ckliefern.
     * Existiert kein Element, wird eine Exception ausgel�st.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException {
        if (counter == 0)
            throw new QueueEmptyException();

        Node<T> element = first;
        first = first.getNext();
        counter--;
    	return element.getData();
    }
    
    /**
     * �bergebenen Integer am Ende der Queue anh�ngen.
     * @param i Zahl
     */
    public void enqueue(T i) {
        Node<T> newElement = new Node<>(i);
        counter++;
        if (first == null)
            first = newElement;
        else
            last.setNext(newElement);

        last = newElement;

    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return counter;
    }
}
