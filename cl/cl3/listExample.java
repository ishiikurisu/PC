import java.util.*;

public class listExample
{
	public static final void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		List list = new LinkedList();
		int number;

		do
		{
			number = input.nextInt();
			list.add(number);

			for (int i = 0; i < list.size(); i++)
				System.out.print(list.get(i) + " ");
			System.out.println(" ");
    }
		while (number != 0);
  }
}
