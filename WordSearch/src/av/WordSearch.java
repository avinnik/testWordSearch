package av;

public class WordSearch {
	//let's make it one dimensional, two dimensional is too easy
	private String inpString="U,M,K,H,U,L,K,I,N,V,J,O,C,W,E," + 
			"L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G," + 
			"H,S,U,P,J,P,R,J,D,H,S,B,X,T,G," + 
			"B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E," + 
			"A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D," + 
			"S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F," + 
			"B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z," + 
			"O,K,R,I,K,A,M,M,R,M,F,B,A,P,P," + 
			"N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S," + 
			"E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K," + 
			"S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D," + 
			"T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K," + 
			"O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H," + 
			"W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S," + 
			"K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B";

	final int size=15;
	String [] stringArray=null;
	String [] rows= new String[size];
	String [] columns= new String[size];
	String [] diagonalsRight=new String[size];
	String [] diagonalsLeft=new String[size];

	public enum ResultType {
		ROW,
		COLUMN,
		DIAGONAL_RIGHT,
		DIAGONAL_LEFT
	}

	/**
	 * constructor
	 */
	public WordSearch()
	{
		stringArray = inpString.split(",");
		// init all
		for( int i=0; i< size; i++)
		{
			rows[i]=getRow(i);
			columns[i]=getColumn(i);
			diagonalsRight[i]=getDiagonalLeftToRight(i);
		}

	}

	/**
	 * get row by index
	 * @param ind
	 * @return
	 */
	String getRow(int ind)
	{
		char [] res=new char[size];
		int start=size*ind;

		for(int i=0; i < size; i++)
			res[i]=stringArray[start+i].charAt(0);

		return String.valueOf(res);
	}

	/**
	 * get diagonal  starting from specified column
	 * @param x -- columnindex
	 * @return
	 */
	String getDiagonalLeftToRight(int x)
	{
		int diagonalSize=size-x;

		char [] res=new char[diagonalSize];

		for(int i=0, j=x; i < diagonalSize; i++,j+=size+1)
		{
			res[i]=stringArray[j].charAt(0);
		}

		return String.valueOf(res);
	}

	/**
	 * get column by index
	 * @param ind
	 * @return
	 */
	String getColumn(int ind)
	{
		char [] res=new char[size];

		for(int i=0, j=ind; i < size; i++,j+=size) 	res[i]=stringArray[j].charAt(0);

		return String.valueOf(res);
	}

	public String searchWord(String word) throws Exception
	{
		if(word== null || word.length() <2 || word.length() >= size)
		{
			throw new IllegalArgumentException ("Word must be at least 2 character long");

		}

		try {

			String tmpResult=searchWord(word, false);
			if(tmpResult != null) return tmpResult;
			tmpResult=searchWord(word, true);
			return tmpResult;
		}
		catch ( Exception ex)
		{
			ex.printStackTrace();
			throw ex;
		}

	}

	private String searchWord(String word, boolean reverse)
	{

		//do not forget reverse
		String wordToSearch=word;

		for(int i=0; i< size; i++)
		{
			String tmpResult;

			int index;
			String whereToSearch=rows[i];
			index=whereToSearch.indexOf(wordToSearch);
			tmpResult=formatResult(word, i, index, ResultType.ROW, reverse);
			if(tmpResult != null) return tmpResult;

			whereToSearch=columns[i];
			index=whereToSearch.indexOf(wordToSearch);
			tmpResult=formatResult(word, i, index, ResultType.COLUMN, reverse);
			if(tmpResult != null) return tmpResult;

			whereToSearch=diagonalsRight[i];	
			index=whereToSearch.indexOf(wordToSearch);
			tmpResult=formatResult(word, i, index, ResultType.DIAGONAL_RIGHT, reverse);
			if(tmpResult != null) return tmpResult;

		}

		return null;
	}

	/**
	 * now we will format result string
	 * @param word -- word to search for
	 * @param itemIndex -- row or column index
	 * @param startingIndex -- starting index where word is found 
	 * @param resultType -- type of result (ROW,COLUMN,DIAGONAL_RIGHT,DIAGONAL_LEFT)
	 * @param reversed -- flag if it is search in reverse
	 * @return
	 */
	String formatResult(String word, int itemIndex, int startingIndex, ResultType resultType, boolean reversed)
	{
		if(startingIndex<0) return null;

		int wordLen=word.length();
		String [] res=new String[wordLen];

		for(int i=0; i < wordLen; i++) {
			switch (resultType)
			{
			case ROW:
			{
				res[i]=String.format("(%d,%d)", startingIndex+i, itemIndex);
				break;
			}

			case COLUMN:
			{
				res[i]=String.format("(%d,%d)", itemIndex, startingIndex+i);
				break;
			}

			case DIAGONAL_RIGHT:
			{
				res[i]=String.format("(%d,%d)", itemIndex+startingIndex+i, startingIndex+i);
				break;
			}

			default:
				break;

			}
		}

		String str= word+ " " + res[0];


		for(int i=1; i< res.length; i++) str += ","+ res[i];

		return str;

	}

}

