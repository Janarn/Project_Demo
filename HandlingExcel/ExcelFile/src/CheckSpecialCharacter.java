import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSpecialCharacter {

	public static void main(String[] args) {
		String DisplayedText="abc/  : ? �  , .$";
		System.out.println("Displayed Text  is :"+DisplayedText);
		Pattern pattern = Pattern.compile("[a-zA-Z0-9/:?�,. ]*");
		Matcher matcher = pattern.matcher(DisplayedText);
		if(matcher.matches()){
			System.out.println("------------------------------------------------------- ");
			System.out.println("Dosen't Contain any Special character");
			
		}
		else {
			
			System.out.println("Displayed Special Characters : "+DisplayedText.replaceAll("[a-zA-Z0-9/:?�,. ]*", "").trim());
		}

	}

}
