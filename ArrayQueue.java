import java.util.*;

public class ArrayQueue<T> implements Queue<T>
{
	protected T[] a;
	protected int first;
	protected int last;

	public ArrayQueue()
	{
		a = (T[]) new Object[10];
		first = 0;
		last = 0;
	}

	public boolean empty()
	{
		return((first == last));
	}

	public void enqueue(T item)
	{
		//Those extra bits help confirm that "first" and "last" are in their maximum spaces
		if((last == (first + 1)%(a.length - 1)) && (last == a.length - 1) && (first == a.length - 2))
		{
			T[] copied = (T[]) new Object[(a.length * 2) - 1];
			for(int n = 0; n < a.length - 1; n++)
				copied[n] = a[(n + first)%(a.length - 1)];
			a = copied;
		}
		a[last++] = item;
		last = last%(a.length - 1);
	}


	public T dequeue()
	{
		try {
			if(empty())
				throw new Exception("There is no data in this queue.");
		}
		catch(Exception e){};
		T item = a[first];
		first = (first + 1)%(a.length - 1);
		return(item);
	}



}