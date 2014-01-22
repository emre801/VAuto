

/*PP 1.1: Spend up to 1 hour in the programming language of your choice and write a program
that takes an arbitrary sentence and abbreviates it by replacing each word with the first 
letter of the word and the last letter of the word and a number representing the number of 
characters between the first and last letter.  For example, Ford would become F2d.  
Words are separated by spaces or any other non-alphabetic characters.  
The program should maintain all non-alphabetic characters in their original form*/


public class Abbreviate {

	
	
	public static String abbreviateSentence(String sentence)
	{
		String result="";
		int start=0;
		//Iterates trough each char in the sentence
		for(int i=0;i<sentence.length();i++)
		{
			char c=sentence.charAt(i);
			//if the current char is a non alphabetical char then it would split it
			if(!isValidChar(c))
			{
				//Gets the current word
				String word=sentence.substring(start,i);
				start=i+1;
				//adds the result of the abbreviated word
				result+=abbreviateWord(word)+c;
			}
		}
		//This is for the last and final word
		result+=abbreviateWord(sentence.substring(start));
		
		
		//The run time of this would be O(n) where n is the length of the sentence
		//The methods abbreviatedWord and isValidChar run in constant time, O(1);
		//returns the new abbreviated word
		return result;
	}
	
	public static String abbreviateWord(String word)
	{
		if(word.length()==0)
			return "";
		char start=word.charAt(0);//gets the char at the front
		char end=word.charAt(word.length()-1);//gets the char at the end
		String length=(word.length()-2)+"";//get the length in between first and last char
		String appWord=start+length+end;//combines them into one word
		return appWord;
	}
	
	
	public static boolean isValidChar(char c)
	{
		//Determines if the char is an alphabetical char or not
		return (c>='a' && c<='z')|| (c>='A' && c<='Z');
	}
	
	public static void main(String[] args)
	{
		//My test case
		System.out.println(Abbreviate.abbreviateSentence("Ford")); //Test case for single word based on example
		System.out.println(Abbreviate.abbreviateSentence("hello world happy world"));//multiple words
		System.out.println(Abbreviate.abbreviateSentence("hello-$%$---my-name-is-!john "));//instead of spaces I use non alphabetical characters
		System.out.println(Abbreviate.abbreviateSentence("123456789"));//all non alphabetical chars
		System.out.println(Abbreviate.abbreviateSentence(""));//blank should return blank
	}
	
	
	
}
