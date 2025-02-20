class Solution {
    public String nearestPalindrclass Solution {
    public String nearestPalindromic(String n) {
        int length = n.length();
        long original = Long.parseLong(n);
        int half = (int)Math.ceil(length / 2.0);  // Correctly compute the half-length
        String str = n.substring(0, half);
        long prefix = Long.parseLong(str);
        boolean even = (length % 2 == 0);
        
        ArrayList<Long> res = new ArrayList<>();
        res.add(increement(prefix, even));
        res.add(decreement(prefix, even));
        res.add(same(prefix, even));
        res.add(nines(length));
        res.add(hundreds(length));
        
        long ans = -1;
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            long candidate = res.get(i);
            if (candidate == original)
                continue;
            long diff = Math.abs(candidate - original);
            if (diff < minDiff || (diff == minDiff && candidate < ans)) {
                minDiff = diff;
                ans = candidate;
            }
        }
        return Long.toString(ans);
    }
    
    public static Long increement(long num, boolean even) {
        num++; 
        long res = num;
        long temp = num;  // Use a temporary variable for reversal
        if (even) {
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            temp /= 10; // For odd length, drop the last digit before mirroring
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    public static Long decreement(long num, boolean even) {
        num--; 
        long res = num;
        long temp = num;
        if (even) {
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            temp /= 10;
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    public static Long same(long num, boolean even) {
        long res = num;
        long temp = num;
        if (even) {
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            temp /= 10;
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    public static Long nines(int len) {
       Long nines = (long)Math.pow(10, len) + 1;
       return nines;
    }
    
    public static Long hundreds(int len) {
       Long hundreds = (long)Math.pow(10, len - 1) - 1;
       return hundreds;
    }
}
omic(String n) {
        int length = n.length();
        long original = Long.parseLong(n);
        int half = (int)Math.ceil(length / 2.0);  // Correctly compute the half-length
        String str = n.substring(0, half);
        long prefix = Long.parseLong(str);
        boolean even = (length % 2 == 0);
        
        ArrayList<Long> res = new ArrayList<>();
        res.add(increement(prefix, even));
        res.add(decreement(prefix, even));
        res.add(same(prefix, even));
        res.add(nines(length));
        res.add(hundreds(length));
        
        long ans = -1;
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            long candidate = res.get(i);
            if (candidate == original)
                continue;
            long diff = Math.abs(candidate - original);
            if (diff < minDiff || (diff == minDiff && candidate < ans)) {
                minDiff = diff;
                ans = candidate;
            }
        }
        return Long.toString(ans);
    }
    
    public static Long increement(long num, boolean even) {
        num++; 
        long res = num;
        long temp = num;  // Use a temporary variable for reversal
        if (even) {
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            temp /= 10; // For odd length, drop the last digit before mirroring
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    public static Long decreement(long num, boolean even) {
        num--; 
        long res = num;
        long temp = num;
        if (even) {
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            temp /= 10;
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    public static Long same(long num, boolean even) {
        long res = num;
        long temp = num;
        if (even) {
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            temp /= 10;
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    public static Long nines(int len) {
       Long nines = (long)Math.pow(10, len) + 1;
       return nines;
    }
    
    public static Long hundreds(int len) {
       Long hundreds = (long)Math.pow(10, len - 1) - 1;
       return hundreds;
    }
}
