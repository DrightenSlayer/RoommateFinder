import java.util.Map;

public class Password
{
	/*
	 * takes a string, and produces a key for the password (as follows).
	 * In subsequent entries of the password, the Huffman Tree
	 * will be recomputed, the password will be converted into Huffman values,
	 * That string (of bits) will be converted to decimal, then the first character's of the password ASCII value  is added
	 * if that matches the key, the user logs in.
	 */
	public static boolean createPassword(String p, String c)
	{
		if(!p.equals(c)){ System.out.println("Passwords do not match!"); return false;}
		if(p.equals("")) return false;
		HuffmanTree ht = new HuffmanTree(null);
		Map<Character, String> en = ht.getMap(p);
		
		String r = "";
		for(int i = 0; i < p.length(); i++){r += en.get(p.charAt(i));}
		int t = 0;
		for(int i = r.length()-1, k = 0; i >= 0; i--, k++)
		{
			if(r.charAt(i) == '1') t += (Math.pow(2, k));
		}
		int key = t + p.charAt(0);
		return true;
		
	}
	
	public static void main(String args[])
	{
		createPassword("apple", "apple");
	}
}