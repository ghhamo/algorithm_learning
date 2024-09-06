package job.hashMap;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = getStringStringHashMap();
        System.out.println(hashMap.get("adbcgg"));
        System.out.println(hashMap.get("aasdfasssfdfadl"));
        System.out.println(hashMap.get("aasdfassfdsgl"));
        System.out.println(hashMap.get("ac"));
        hashMap.contains("aasdfassfdsgl");
        hashMap.remove("aasdfassfdsgl");
        hashMap.contains("aasdfasssfdfadl");
        hashMap.remove("aabcd");
        hashMap.contains("aa");
    }

    private static HashMap<String, String> getStringStringHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aabcd", "aa");
        hashMap.put("abbce", "ab");
        hashMap.put("acbcf", "ac");
        hashMap.put("adbcgg", "ad");
        hashMap.put("aebers", "ae");
        hashMap.put("asfdvf", "af");
        hashMap.put("agsadf", "ag");
        hashMap.put("ahsdfaasdf", "ah");
        hashMap.put("aiwerw", "ai");
        hashMap.put("ag", "ag");
        hashMap.put("aksdsdfas", "ak");
        hashMap.put("aasdfassl", "al");
        hashMap.put("aasdfassfdsgl", "al");
        hashMap.put("aasdfasssfdfadl", "al");
        return hashMap;
    }
}