import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexText {

    public static void main(String [] args){
        Pattern p = Pattern.compile("\\d\\d\\d"); // 3 digits
        // FIND doesn't work when specify start and end
        // when length more than number of letters specified
        // (If not consecutive, false)
        // (If consecutive, not matching start or end.

        String a = "123";
        String b = "a123b";
        Matcher mA = p.matcher(a);
        Matcher mB = p.matcher(b);

        System.out.println(mA.find()); // true
        System.out.println(mA.matches()); // true

        // FIND returns true when 3 consecutive digits found
        System.out.println(mB.find()); //true
        System.out.println(mB.matches()); // false
    }
}
