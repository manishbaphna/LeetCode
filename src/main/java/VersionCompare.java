import java.util.regex.Pattern;

//https://leetcode.com/problems/compare-version-numbers/solutions/

public class VersionCompare {
    public int compareVersion(String version1, String version2) {


        /*String[] token1 = version1.split("\\.");
        String[] token2 = version2.split("\\.");*/

        String[] token1 = version1.split(Pattern.quote("."));
        String[] token2 = version2.split(Pattern.quote("."));

        //  ("1.01", "1.001"));
        int length = Math.max(token1.length, token2.length);

        for (int i=0; i < length; ++i){
            Integer ver1 = i < token1.length ? Integer.parseInt(token1[i]) : 0;
            Integer ver2 = i < token2.length ? Integer.parseInt(token2[i]) : 0;

            int compare = ver1.compareTo(ver2);
            if ( compare != 0)
                return compare;
        }

        return 0;
    }


    public static void main(String[] args) {
        VersionCompare DUT = new VersionCompare();
        System.out.println(DUT.compareVersion("1.2", "1.10"));
        System.out.println(DUT.compareVersion("1.01", "1.001"));
        System.out.println(DUT.compareVersion("1.0.1", "1"));
    }
}

