import java.util.Scanner;
class ExpressionTree

{
	class TreeNode
	{    
		char data;
		TreeNode left, right;
		public TreeNode(char data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}

	} 
	class StackNode
	{
		TreeNode treeNode;
		StackNode next;

		public StackNode(TreeNode treeNode)
		{
			this.treeNode = treeNode;
			next = null;
		}
	}

	private static StackNode top;

	public ExpressionTree()
	{
		top = null;
	}

	public void clear()
	{
		top = null;
	}
	private void push(TreeNode ptr)
	{
		if (top == null)
		{
			top = new StackNode(ptr);
		}
		else
		{
			StackNode nptr = new StackNode(ptr);
			nptr.next = top;
			top = nptr;
		}
	}

	private TreeNode pop()
	{
		if (top == null)
		{
			throw new RuntimeException("Underflow");
		}
		else
		{
			TreeNode ptr = top.treeNode;
			top = top.next;
			return ptr;
		}
	}

	private TreeNode peek()
	{
		return top.treeNode;
	}
	private void insert(char val)
	{
		try
		{
			if (isDigit(val))
			{
				TreeNode nptr = new TreeNode(val);
				push(nptr);
			}
			else if (isOperator(val))
			{
				TreeNode nptr = new TreeNode(val);
				nptr.left = pop();
				nptr.right = pop();
				push(nptr);
			}
		}
		catch (Exception e)
		{
			System.out.println("Invalid Expression");
		}
	}

	private boolean isDigit(char ch)
	{
		return ch >= '0' && ch <= '9';
	}

	private boolean isOperator(char ch)
	{
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private int toDigit(char ch)
	{
		return ch - '0';
	}

	public void buildTree(String eqn)
	{
		for (int i = eqn.length() - 1; i >= 0; i--)
		{
			insert(eqn.charAt(i));
		}
	}

	public double evaluate()
	{
		return evaluate(peek());
	}

	public double evaluate(TreeNode ptr)
	{
		if (ptr.left == null && ptr.right == null)
		{
			return toDigit(ptr.data);
		}
		else
		{
			double result = 0.0;
			double left = evaluate(ptr.left);
			double right = evaluate(ptr.right);
			char operator = ptr.data;
			
			switch (operator)
			{
			case '+' : result = left + right; break;
			case '-' : result = left - right; break;
			case '*' : result = left * right; break;
			case '/' : result = left / right; break;
			default  : result = left + right; break;
			}
			return result;
		}
	}

	public void postfix()
	{
		postOrder(peek());
	}
	
	private void postOrder(TreeNode ptr)
	{
		if (ptr != null)
		{
			postOrder(ptr.left);            
			postOrder(ptr.right);
			System.out.print(ptr.data);            
		}    
	}

	public void infix()
	{
		inOrder(peek());
	}

	private void inOrder(TreeNode ptr)
	{
		if (ptr != null)
		{
			inOrder(ptr.left);
			System.out.print(ptr.data);
			inOrder(ptr.right);            
		}    
	}

	public void prefix()
	{
		preOrder(peek());
	}

	private void preOrder(TreeNode ptr)
	{
		if (ptr != null)
		{
			System.out.print(ptr.data);
			preOrder(ptr.left);
			preOrder(ptr.right);            
		}    
	}
}

public class GPACalculator
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Expression Tree Test");
		ExpressionTree et = new ExpressionTree();
		System.out.println("\nEnter equation in prefix form");
		et.buildTree(scan.next());
		System.out.print("\nPrefix  : ");
		et.prefix();
		System.out.print("\n\nInfix   : ");
		et.infix();
		System.out.print("\n\nPostfix : ");
		et.postfix();
		System.out.println("\n\nEvaluated Result : "+ et.evaluate());
	}
}