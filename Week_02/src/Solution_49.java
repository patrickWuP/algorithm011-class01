class Solution_49 {
    //异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String data:strs) {
            // char[] a = data.toCharArray();
            // Arrays.sort(a);
            String key = getKey(data);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(data);
        }
        return new ArrayList(map.values());
    }

    private String getKey(String data) {
        // char[] a = data.toCharArray();
        // Arrays.sort(a);
        // String key = String.valueOf(a);
        char[] arr = new char[26];
        for(char cr:data.toCharArray()) {
            arr[cr - 'a']++;
        }
        return String.valueOf(arr);
    }
}