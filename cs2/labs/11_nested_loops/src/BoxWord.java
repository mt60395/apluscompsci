import static java.lang.System.*;

class BoxWord
{
	private String word;

	public BoxWord()
	{
		word="cat";
	}

	public BoxWord(String s)
	{
		word = s;
	}

	public void setWord(String w)
	{
		word = w;
	}

	public String toString()
	{
		String output=word+"\n";
		String spaces = "";
		for (int i = 0; i < word.length() - 2; i++) {
			spaces += " ";
		}
		for (int i = 1; i <= word.length() - 2; i++) {
			output += word.charAt(i);
			output += spaces;
			output += word.charAt(word.length() - i - 1);
			output +="\n";
		}
		if (word.length() > 1) {
			char ch[] = word.toCharArray();
			String rev = "";
			for(int i=ch.length-1; i>=0; i--){
				rev+=ch[i];
			}
			output += rev + "\n";
		}
		return output+"\n";
	}
}
