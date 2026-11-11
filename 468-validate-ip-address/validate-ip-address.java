class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null) return "Neither";
        
        if (queryIP.indexOf('.') != -1) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.indexOf(':') != -1) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        }
        
        return "Neither";
    }
    
    private boolean isValidIPv4(String ip) {
        String[] tokens = ip.split("\\.", -1);
        if (tokens.length != 4) return false;
        
        for (String token : tokens) {
            if (token.length() == 0 || token.length() > 3) return false;
            // Correct check for leading zeros (e.g., "01" or "00")
            if (token.charAt(0) == '0' && token.length() > 1) return false;
            
            int num = 0;
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                if (!Character.isDigit(c)) return false;
                num = num * 10 + (c - '0');
            }
            
            if (num < 0 || num > 255) return false;
        }
        return true;
    }
    
    private boolean isValidIPv6(String ip) {
        String[] tokens = ip.split(":", -1);
        if (tokens.length != 8) return false;
        
        for (String token : tokens) {
            if (token.length() == 0 || token.length() > 4) return false;
            
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                boolean isDigit = c >= '0' && c <= '9';
                boolean isLowerChar = c >= 'a' && c <= 'f';
                boolean isUpperChar = c >= 'A' && c <= 'F';
                
                if (!isDigit && !isLowerChar && !isUpperChar) return false;
            }
        }
        return true;
    }
}