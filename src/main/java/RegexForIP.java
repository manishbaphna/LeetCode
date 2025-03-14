import javax.xml.xpath.XPath;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexForIP {
    public String Till255 = "([0|1]?\\d{1,2}|[2][0-4]\\d|[2][0-5]{2})";
    //    private String ze "((0|1)\\d{2}|2[0-4]\\d|25[0-5]|\\d{1,2})";
//23.45.12.56
    //        assertTrue(RegexForIP.isValidIP("277.0.0.1"));
    public String pattern = Till255 + "." + Till255 + "." + Till255 + "." + Till255;
    public static boolean isValidIP(String input) {
        RegexForIP ip = new RegexForIP();

        try {
            Pattern pat = Pattern.compile(ip.pattern);
            Matcher mat = pat.matcher(input);
            return mat.matches();
        } catch ( PatternSyntaxException e) {
            System.out.println("Wrong pattern " + e.toString());
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(RegexForIP.isValidIP("255"));
        System.out.println(RegexForIP.isValidIP("259"));
        System.out.println(RegexForIP.isValidIP("005"));


    }
}
