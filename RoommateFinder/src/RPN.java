package tester;
import java.util.*;

public class RPN
{
	
	public static boolean higherPrecedence(String one, String two)
	{
		if(one.equals("+") || one.equals("-")) return two.equals("(");
		if(one.equals("*") || one.equals("/") || one.equals("%")) return two.equals("+") || two.equals("-") || two.equals("(");
		else throw new IllegalArgumentException();
	}
	public static String convert(String arg)
	{
		Stack<String> ops = new Stack<>();
		String postfix = "";
		String input = "";
		Scanner in = new Scanner(arg + " =");
		
		while(in.hasNext())
		{
			if(in.hasNextInt()) postfix += in.next() + " ";
			else
			{
				input = in.next().trim();
				if(input.equals("=")) break;
				if(input.equals("(")) ops.push(input);
				else if(input.equals(")"))
				{
					while(!ops.isEmpty())
					{
						String following = ops.pop();
						if(following.equals("(")){input = null; break;}
						else postfix += following + " ";
					}
					if(input != null) throw new IllegalStateException();
				}
				else if(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("%"))
				{
					while(!ops.isEmpty() && !higherPrecedence(input, ops.peek()))
					{
						postfix += ops.pop() + " ";
					}
					ops.push(input);
				}
				else throw new IllegalArgumentException();
			}
		}
		in.close();
		while(!ops.isEmpty()) postfix += ops.pop() + " ";
		return postfix;
	}
	public static void main(String args[])
	{
		System.out.println(convert("5 + 3 - 2"));
	}
}
