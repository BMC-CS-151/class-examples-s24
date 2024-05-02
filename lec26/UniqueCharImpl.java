class UniqueCharImpl {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i=0; i<s.length(); i++) {
            Character cur = s.charAt(i); 
            if (!map.containsKey(cur))  {
                map.put(cur, i);
            } else {
                map.put(cur, 10000000);
            }
        }
        
        int minIdx = 10000000;
        for (Integer index: map.values()) {
            if (index < minIdx) {
                minIdx = index;
            }
        }

        if (minIdx == 10000000) {
            return -1; 
        } else {
            return minIdx;
        }
    }
}
