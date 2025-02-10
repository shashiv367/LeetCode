class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );
        
        int total = 0;
        int prev = 0;
        
        // Iterate from right to left (more efficient for subtraction logic)
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = roman.get(s.charAt(i));

            // If current numeral is smaller than the previous, subtract it
            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }

            prev = curr; // Update previous numeral
        }
        
        return total;
    }
}