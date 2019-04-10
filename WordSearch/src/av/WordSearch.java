package av;

public class WordSearch {
	final int size=15;

	public String searchWord(String word) throws Exception
	{
		if(word== null || word.length() <2 || word.length() >= size)
		{
			throw new IllegalArgumentException ("Word must be at least 2 character long");

		}
		return word;
	}
}
