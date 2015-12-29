/**
 * This class encapsulates a basic music
 * library. It uses a binary search tree to store
 * albums. It's like a TreeMap. The key into the tree 
 * is a String, the name of the album. The value is
 * the actual album itself.
 */
public class MusicLibrary
{
	AlbumNode root;

	/**
	 * Constructor.
	 */
	public MusicLibrary()
	{
		root = null;
	}
	
	/**
	 * Add an album to the tree.
	 * Use a recursive helper method. The albums
	 * in the tree should be ordered based on
	 * the name of the album, NOT the artist.
	 * 
	 * @param a the AlbumNode to add
	 */
	public void addAlbum(AlbumNode a)
	{
		AlbumNode newNode = new AlbumNode(a.getArtist(), a.getName()); 
		if (root != null) 
		{ 
			addAlbum(root, newNode); 
		}
		else 
		{ 
			root = newNode;
		}
	}
	/**
	 * Add the node to the album
	 */
	public void addAlbum(AlbumNode latestRoot ,AlbumNode a)
	{
		if(a.getName().compareTo(latestRoot.getName()) < 0)
		{
			if (latestRoot.left != null) 
			{ 
				addAlbum(latestRoot.left, a);
			}
			else
			{ 
				latestRoot.left = a; 
			}	
		}
		else
		{
			if (latestRoot.right != null)
			{
				addAlbum(latestRoot.right, a);
			}
			else
			{ 
				latestRoot.right = a;
			}
		}
	}
	
	/**
	 * Return an Album from the tree
	 * if it exists, or null otherwise.
	 * Use a recursive helper method.
	 * 
	 * @param albumName the name of the album to return
	 * @return an Album or null
	 */
	public AlbumNode getAlbum(String albumName)
	{
		if(root != null)
		{
			return getAlbum2(root, albumName);
		}
		else
		{
			return null;
		}	
	}
	private AlbumNode getAlbum2(AlbumNode a ,String albumName)
	{
		AlbumNode subNode = a;
		while(subNode != null)
		{
			if(albumName.compareTo(subNode.getName()) == 0)
			{
				return subNode;
			}
			else if(albumName.compareTo(subNode.getName()) < 0)
			{
				subNode = subNode.left;
			}
			else if(albumName.compareTo(subNode.getName()) > 0)
			{
				subNode = subNode.right;
			}
		}
		return subNode;
	}
	
	/**
	 * Return the size of the library. Use
	 * a recursive helper method.
	 * 
	 * @return an int
	 */
	public int count()
	{	
		return count(root);
	}
	private static int count(AlbumNode a)
	{	
		if(a != null)
		{
			int count = 1;
			count += count(a.left);
			count += count(a.right);
			return count;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * Print the list of albums
	 * in the MusicLibrary in order based on name.
	 * Print each album on its own line.
	 * Use a recursive helper method. Use the
	 * toString method in the AlbumNode class
	 * to print each album.
	 */
	public void printInOrder()
	{
		printInOrder(root);
	}
	private static void printInOrder(AlbumNode node)
	{
		if(node != null)
		{
			printInOrder(node.left);
			System.out.println(node.toString());
			printInOrder(node.right);
		}
		else
		{
			return;
		}
	}
	
	/**
	 * Print the list of albums
	 * in the MusicLibrary in reverse order based on name.
	 * Use a recursive helper method.
	 */
	public void printInReverseOrder()
	{	
		printInReverseOrder(root);	
	}
	private static void printInReverseOrder(AlbumNode node)		
	{
		if(node != null)
		{
			printInReverseOrder(node.right);
			System.out.println(node.toString());
			printInReverseOrder(node.left);
		}
		else
		{
			return;
		}
	}	
}
