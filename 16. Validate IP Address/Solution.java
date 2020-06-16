/*REGEX SOLUTION*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    String zeroTo255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern IPv4 = Pattern.compile("^(" + zeroTo255 + "\\.){3}" + zeroTo255 + "$");
                    //string 0 to 255
                    //to explain: nums (1-9),(10-99),(100-199),(200-249),(250-255)
                    //pattern is thrice the string with a dot plus the string                
    
    String group = "([0-9a-fA-F]{1,4})";
    Pattern IPv6 = Pattern.compile("^(" + group + "\\:){7}" + group + "$");
                    //string contains hexadecimal characters including letters in groups of 4
                    //pattern is 7 times string with a dot plus the string once more
    
    public String validIPAddress(String IP) {               
        if(IPv4.matcher(IP).matches()){
            return "IPv4";
        }
        if(IPv6.matcher(IP).matches()){
            return "IPv6";
        }
        return "Neither";
    }
}
