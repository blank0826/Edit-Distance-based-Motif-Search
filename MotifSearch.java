import java.io.*;
import java.util.*;

public class MotifSearch {
    public static final int SIZE = 600;

    public static void main(String args[]) throws IOException {
        int val = (int) System.currentTimeMillis();
        File file = new File("Data.txt");

        BufferedReader fp = new BufferedReader(new FileReader(file));
        String st[] = new String[4];
        String str = "";
        int index = 0;

        while ((str = fp.readLine()) != null) {
            st[index] = str;
            index++;
        }

        int L = Integer.parseInt(st[0]);
        int D = Integer.parseInt(st[1]);
        int indel = Integer.parseInt(st[2]);
        int sub = Integer.parseInt(st[3]);

        fp.close();

        char[] types = { 'A', 'G', 'T', 'C' };
        ArrayList<ArrayList<String>> allSubstrings = new ArrayList<ArrayList<String>>(); // contains substrings of
                                                                                         // length L for every strings
        System.out.println("Strings are: ");

        for (int i = 0; i < 20; i++) { // loop to create 20 random strings of 600 length while creating and storing all
                                       // its substrings.
            String DNASequence = createRandomString(types);
            System.out.println(i + 1 + ". " + DNASequence + " \n");
            ArrayList<String> subStrings = createAllSubstrings(DNASequence, L, D);
            allSubstrings.add(subStrings);
        }

        printAllNeighboursWEditDistance(allSubstrings, D, indel, sub, L); // traverse thorugh the array and show the
                                                                          // output
        System.out.print("Execution Time:" + ((int) System.currentTimeMillis() - val));
    }

    private static void printAllNeighboursWEditDistance(ArrayList<ArrayList<String>> neighbourSubstring, int D,
            int indel, int sub, int L) throws IOException {
        ArrayList<String> result = new ArrayList<>(); // stores all the string that are considered to be shown
        FileWriter fw = new FileWriter("Out.txt");
        fw.append("Results: \n");

        for (int p = 0; p < neighbourSubstring.size(); p++) {
            // System.out.println("p. " + p);
            ArrayList<String> getMSubstrings = neighbourSubstring.get(p); // get the list of substrings
            for (int c = 0; c < getMSubstrings.size(); c++) { // traverse for each element in the all arraylist
                String substring = getMSubstrings.get(c);
                if (substring.length() != L) {
                    continue;
                }
                int i = 1;
                int count = 0;
                int prevCount = 0;
                for (; i < neighbourSubstring.size(); i++) {// traverse through the whole other list of arraylists
                    // System.out.println("i. " + i);
                    if (i == p) {
                        continue;
                    }
                    ArrayList<String> neigbourStr = neighbourSubstring.get(i); // get the list
                    int j = 0;
                    for (; j < neigbourStr.size(); j++) { // traverse through the list
                        String nStr = neigbourStr.get(j);
                        int distance = calculateEditDistance(substring, nStr, indel, sub); // checks edit distance
                        if (distance <= D) {
                            count++; // if it satifies the condition then just increase the count
                            break;
                        }
                    }

                    if (count == prevCount) { // checks if count doesn't increase then we didn't find any of the
                                              // neighbour in
                        // the concerned substring so no need to check it further.
                        break;
                    } else {
                        prevCount = count;
                    }
                }

                if (i == neighbourSubstring.size()) { // if able to taverse through the whole list of arraylist then it
                                                      // means able to find atleast one neighbour in every string
                    result.add(substring); // prints M
                }
            }
        }

        ArrayList<String> finalAnswer = new ArrayList<>(); // have substrings that are written in the file
        for (String str : result) { // remove duplicates
            if (!finalAnswer.contains(str)) {
                finalAnswer.add(str);
            }
        }
        for (String str : finalAnswer) { // write in file
            fw.append(str + "\n");
        }

        fw.close();
    }

    private static int calculateEditDistance(String substring, String neighbourSubstring, int indel, int sub) {

        int substringLength = substring.length();
        int neighbourSubstringLength = neighbourSubstring.length();

        int[][] memo = new int[substringLength + 1][neighbourSubstringLength + 1];

        // initializing the memoization array
        for (int i = 0; i <= substringLength; i++) {
            memo[i][0] = i;
        }

        for (int i = 0; i <= neighbourSubstringLength; i++) {
            memo[0][i] = i;
        }

        // gets character and check what operation to perform and provide with the
        // optimal cost.
        for (int i = 0; i < substringLength; i++) {
            char substringChar = substring.charAt(i);
            for (int j = 0; j < neighbourSubstringLength; j++) {
                char neigbourChar = neighbourSubstring.charAt(j);

                if (substringChar == neigbourChar) {
                    memo[i + 1][j + 1] = memo[i][j];
                } else {
                    int replacementCost = memo[i][j] + sub;
                    int insertionCost = memo[i][j + 1] + indel;
                    int deletionCost = memo[i + 1][j] + indel;

                    int minimumCost = replacementCost > insertionCost ? insertionCost : replacementCost;
                    minimumCost = deletionCost > minimumCost ? minimumCost : deletionCost;
                    memo[i + 1][j + 1] = minimumCost;
                }
            }
        }

        return memo[substringLength][neighbourSubstringLength];

    }

    private static ArrayList<String> createAllSubstrings(String dNASequence, int L, int D) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < SIZE; i++)
            for (int j = i + 1; j <= SIZE; j++) {
                String ans = dNASequence.substring(i, j); // gets substring of the array
                if (ans.length() <= (L + D) && ans.length() >= (L - D)) { // store only substrings from length L - D to
                                                                          // L + D
                    result.add(ans);
                }
            }
        return result;
    }

    private static String createRandomString(char[] types) { // creates random string of length
        String str = "";

        for (int i = 0; i < SIZE; i++) {
            int index = (int) (Math.random() * 4);
            str += types[index];
        }

        return str;

    }
}