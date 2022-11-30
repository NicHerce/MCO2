import java.util.ArrayList;
import java.util.Hashtable;

public class KmerDistribution {

    public static ArrayList<String> substrings = new ArrayList<>();
    public static Hashtable<Integer, String> table = new Hashtable<>(10);
    // 10 is the tentative table size

    public static void main(String[] args) {
        hashFunction("taccaccaccatag");
//        String word = "accacc";
//        System.out.println(word + " hash code = " + word.hashCode());
    }

    public static void hashFunction(String strDNA) {
        int k = 6; // k == 6

        for(int i = 0; i < strDNA.length() - k + 1; i++){
            String substring = "";
            int letterSum = 0;

            // create substring from the DNA string
            for(int j = i; j < i + k; j++){
                String letter = String.valueOf(strDNA.charAt(j));
                letterSum += strDNA.charAt(j);
                substring = substring.concat(letter);
            }

            // replace with hash function
            substrings.add(substring);

            System.out.println("substring = " + substring);
            int key = letterSum % 10;
            System.out.println(letterSum);

            System.out.println("key = " + key + "\n");
            table.put(key, substring);
        }

        System.out.println(table);
        substrings.forEach(System.out::println);
    }

}
