class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store anagram groups
        HashMap<String, List<String>> map = new HashMap<>();
        
        // Loop through each word in the given array
        for (String words : strs) {
            // Create an array of size 26 to count character frequency
            char[] wordsArray = new char[26];
            
            // Count the frequency of each character in the word
            for (int i = 0; i < words.length(); i++) {
                char c = words.charAt(i);
                wordsArray[c - 'a']++; // Increment count for the character
            }
            
            // Convert character frequency into a unique string key
            StringBuilder newWord = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (wordsArray[i] > 0) { // If a character is present
                    newWord.append((char) (i + 'a')); // Append character
                    newWord.append(wordsArray[i]); // Append count
                }
            }
            
            // Check if this key already exists in the map
            if (map.containsKey(newWord.toString())) {
                map.get(newWord.toString()).add(words); // Add word to existing list
            } else {
                // Create a new list for this key
                List<String> ls = new ArrayList<>();
                ls.add(words);
                map.put(newWord.toString(), ls); // Store in map
            }
        }
        
        // Convert map values to a list of lists and return
        return new ArrayList<>(map.values());
    }
}
