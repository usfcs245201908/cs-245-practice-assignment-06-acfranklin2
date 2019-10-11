import java.util.*;

public class ArrayStack<T> implements Stack<T>
{
	protected T[] a;
	protected int top;
	
	public ArrayStack()
	{
		a = (T[]) new Object[10];
		top = -1;
	}

	protected void growArray()
	{
		T[] copied = (T[]) new Object[a.length * 2];
		for(int i = 0; i < a.length; i++)
			copied[i] = a[i];
		a = copied;
	}

	public void push(T item)
	{
		if(top == a.length - 1)
			growArray();
		a[++top] = item;
	}

	public T peek()
	{
		try{
			if(empty())
				throw new Exception("This stack is Empty.");
		}
		catch(Exception e){}
		return(a[top]);
	}

	public T pop()
	{
		try{
			if(empty())
				throw new Exception("This stack is Empty.");
		}
		catch(Exception e){}
		return(a[top--]);
	}

	public boolean empty()
	{
		return(top == -1);
	}

}