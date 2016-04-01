import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * All you need to know is that the getMap method
 * will return a map with all the huffman encodings
 * in the form HashMap<Character, String>
 * String is such as "0110", etc
 * see the password java file (temporary) for its use
 * @author Matt
 *
 */
public  class HuffmanTree
{
	public HuffmanTree(Character start) {root = new Node(start);}
	
	public HuffmanTree(HuffmanTree l, HuffmanTree r)
	{
		root = new Node(l.root, r.root);
	}
	
	public Map<Character, String> bemap(){ return bemap(root, "");}
	
	public Map<Character, String> bemap(Node n, String s)
	{
	Map<Character, String> map = new HashMap<>();
		if(n.data == null)
		{
			if(n.left != null) map.putAll(bemap(n.left, s + "0"));
			if(n.right != null)map.putAll(bemap(n.right, s + "1"));
		}
		else
		{
			map.put(n.data, s);
		}
		return map;
	}
	
	public Node root;
	class Node
	{
		public Node(Character data){this.data = data;}
		public Node(Node l, Node r)
		{
			left = l; right = r;
		}
		public Character data;
		public Node left;
		public Node right;
	}
	
	public class Group implements Comparable<Group>
	{
		@Override
		public String toString()
		{
			return val + " x" + count + " ";
		}
		
		private Character val;
		private int count;
		
		public Group(Character val){this.val = val;}
		public Group(Character val, int i){this.val = val; count = i;}
		public int compareTo(Group other){return count - other.getCount();}
		
		public Character getVal(){return val;}
		public Integer getCount(){return count;}
	}
	
	public Map<Character, String> getMap(String in)
	{
		ArrayList<Group> p = new ArrayList<>();
		for(int i = 0; i < in.length(); i++)
		{
			boolean hath = false;
			for(int k = 0; k < p.size(); k++) {if(p.get(k).getVal() == in.charAt(i)) hath = true;}
			if(!hath)
			{
				int total = 0;
				for(int j = 0; j < in.length(); j++)
				{
					if(in.charAt(i) == in.charAt(j)) total++;
				}
				p.add(new Group(in.charAt(i), total));
			}
		}
		Collections.sort(p);
		Stack<HuffmanTree> huffStack = new Stack<HuffmanTree>();
		
		for(int i = p.size() - 1; i >= 0; i--)
		{
			huffStack.push(new HuffmanTree(p.get(i).getVal()));
		}
		while(huffStack.size() > 1)
		{
			HuffmanTree bind = new HuffmanTree(huffStack.pop(), huffStack.pop());
			huffStack.push(bind);
		}
		Map<Character, String> m = huffStack.pop().bemap();
		return m;
	}	
}