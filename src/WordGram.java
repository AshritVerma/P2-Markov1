import java.util.ArrayList;
import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author YOUR NAME HERE
 *
 */
public class WordGram {
	
	private String[] myWords;
	private String myToString;  // cached string
	private int myHash;         // cached hash value
	boolean myCall = true;

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = Arrays.copyOfRange(source, start, size+start);
		myToString = "a";
		myHash = 1;

		// TODO: initialize all instance variable
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		int x = myWords.length;
		return x;
	}


	/**
	 * Complete appropriate comment here
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null || !(((WordGram) o).length() == this.length())){
			return false;
		}
		else
		{
			WordGram wg = (WordGram) o;
			for(int i = 0; i < myWords.length; i++) {
				if (!this.myWords[i].equals(wg.myWords[i])) {
					return false;
				}
			}
		}
		// TODO: Complete this method

		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed
		if(myCall == true)
			myHash = this.toString().hashCode();
		myCall = false;
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);

		for(int j = 0; j < wg.myWords.length-1; j++)
		{
			wg.myWords[j] = wg.myWords[j+1];
		}
		wg.myWords[wg.myWords.length-1] = last;

		// TODO: Complete this method
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method, assign to myToString as needed
		if(myCall == true)
			myToString = String.join(" ", myWords);
		myCall = false;
		return myToString;
	}
}
