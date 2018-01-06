import java.util.List;
import java.util.ArrayList;

public class uri1059 {
	static List numbers;

	static void populateList()
	{
		numbers = new ArrayList<Integer>();

		for (int number = 2; number <= 100; number += 2)
			numbers.add(number);
	}

	static void writeList(int index)
	{
		if (index != numbers.size())
		{
			System.out.println((int) numbers.get(index));
			writeList(index+1);
		}
	}

	public static final void main(String[] args) 
	{
		populateList();
		writeList(0);
	}
}
