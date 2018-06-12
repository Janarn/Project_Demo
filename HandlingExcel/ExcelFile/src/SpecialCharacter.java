import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharacter {


	public static void main(String[] args) {
		String DisplayedText="4/15 ALBION ST, ST KILDA VIC 3182";
		System.out.println("Displayed Text  is :"+DisplayedText);
		//Pattern pattern = Pattern.compile("[^!#$%&'()+,-./:;<=>?@_`{|}]*");
		//Matcher matcher = pattern.matcher(DisplayedText);
		int index=DisplayedText.indexOf("/");
		System.out.println(DisplayedText.indexOf("/"));
		if(Character.isDigit(DisplayedText.charAt(index-1))&&Character.isDigit(DisplayedText.charAt(index+1))){
			System.out.println("both characters are digits");
		}
		/*if(){
			System.out.println("------------------------------------------------------- ");
			System.out.println("matches");
		}else{
			System.out.println("Not matches");
		}*/
	}
}
