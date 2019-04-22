import java.io.*;

public class HashTable {
    static int collisions = 0;
    static int getIndex(String arg, String[] ht) {
        int len = ht.length;
	int hc = arg.hashCode();
	//System.out.println("Returned hashcode for " + arg + " is: " + hc);
	if(hc < 0) {
	    hc = hc + Integer.MAX_VALUE + 1;
	}
	//System.out.println("Converted hashcode for " + arg + " is: " + hc);
        int index = hc%len;
	//System.out.println("Index is: " + index + "len is: " + len);
	if(ht[index] == null) return index;
	int i = 1;
	while(ht[index] != null) {
	    collisions++;
	    index = (index + 2*i-1)%len;
	    i++; 
	}
	return index;
    }

    static void insert(String[] ht, String[] words, double load_fact) {
	    int len = ht.length;
	    for(int i = 0; i < words.length; i++) {
                if((double)i/len >= load_fact) {
			System.out.println();
			System.out.println("Rehashing required...!!");
			ht = new String[67];
			insert(ht, words, load_fact);
			return;
                }
		int ind = getIndex(words[i], ht);
		ht[ind] = words[i];
		System.out.println(words[i] + " inserted successfully in hashtable");
            }
    }

    public static void main(String[] args) {
	double load_fact = 0.5;
	String[] words = {"Hey", "Hello", "World", "this", "will", "bedone", "for", "the", "hash", "table", "assign", "given",
	       	           "inthe", "subject", "CS5343", "atutd", "using", "quadrtic", "probing", "resoln"};
        String[] ht = new String[31];
	insert(ht, words, load_fact);
	System.out.println("Number of Collisons : " + collisions);
    }
}
