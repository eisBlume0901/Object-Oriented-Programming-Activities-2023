import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Activity1
{
    public static void main(String[] args)
    {
        // Question 1
        List<String> stringList1 = Arrays.asList(
                "abs", "cdd", "eert", "alksjr", "lo2k4",
                "lol", "se2es", "kfhf", "koshr", "1ksjf",
                "jrkiif", "lakts", "7jfk11");
        List<Integer> result1 = stringList1
                .stream()
                .filter(element -> hasRepeatingCharacters(element) || isPalindrome(element))
                // [abs, alksjr, lo2k4, koshr, 1ksjf, lakts]
                .map(element -> element.length())
                // [3, 6, 5, 5, 5, 5]
                .filter(length -> length % 2 != 0)
                // [3, 5]
                .collect(Collectors.toList());
        out.println(result1); // [3, 5]

        // Question 2
        List<String> stringList2 = Arrays.asList
                ("1110002", "9338das", "23ds2s", "23jf0",
                "sjfgei", "129shf", "jgoru", "12345",
                "mjshfkro", "0974j1n", "hjsj", "i123h",
                "kshf93", "hjsgfk");
        List<Integer> result2 = stringList2
                .stream()
                .map(element -> convertToNumber(element))
                .filter(obj -> Objects.nonNull(obj))
                .collect(Collectors.toList()); // [1110002, 230, 12345, 123]

        System.out.println(result2);

        // Question 3
        List<Integer> integerList3 = Arrays.asList
                (3, 5, 60, 234, 123, 445, 65301, 5609657, 234235, 345968, 99936099,
                123400234, 123500436, 25460346, 54356, 880888);
        List<String> result3 = integerList3
                .stream()
                .map(element -> getSignificantDigits(element))
                // [1, 1, 1, 3, 3, 3, 5, 7, 6, 6, 8, 9, 9, 8, 5, 6]
                .map(element -> convertToAlphabetCharacters(element))
                // [a, a, a, c, c, c, e, g, f, f, h, i, i, h, e, f]
                .collect(Collectors.collectingAndThen(Collectors.toList(), list ->
                {
                    Collections.reverse(list);
                    return list;
                }));
        out.println(result3); // [f, e, h, i, i, h, f, f, g, e, c, c, c, a, a, a]

        // Question 4
        List<String> stringList4 = Arrays.asList(
                "cunanan", "ong", "anecito", "manalo", "gallardo", "jusi",
                "bisan", "sauquillo", "tomate", "de guia");
        List<String> result4 = stringList4
                .stream()
                .map(element -> modifyString(element))
                .sorted(Comparator.reverseOrder())
                .map(element -> reverseString(element))
                .collect(Collectors.toList());
        out.println(result4); // [etamst, olliuquas, gno, olanao, isfj, odrallag, aiug ed, nananuc, nasib, oticena]
    }

    // Methods for Question 1
    public static boolean hasRepeatingCharacters(String str)
    {
        return str.chars().distinct().count() != str.length();
    }

    public static boolean isPalindrome(String str)
    {
        StringBuilder reversed = new StringBuilder(str).reverse();
        return str.contentEquals(reversed);
    }

    // Methods for Question 2
    public static Integer convertToNumber(String s)
    {
        if (isValidNumber(s)) return Integer.parseInt(s);
        else if (isValidNumber(s.substring(1, s.length() - 1))) return Integer.parseInt(s.substring(1, s.length() - 1));
        else if (s.matches("\\d+.*\\d+"))
        {
            String modified = s.replaceAll("[^\\d]", "");
            if (isValidNumber(modified))
                return Integer.parseInt(modified);
        }
        return null;
    }

    public static boolean isValidNumber(String s)
    {
        return s.matches("\\d+");
    }

   // Methods for Question 3
    public static int getSignificantDigits(Integer num)
    {
        String numString = Integer.toString(num).replaceAll("^0+", "");
        String numString2 = numString.replaceAll("0+$", "");
        return numString2.length();
    }
//
    public static Character convertNumberToCharacter(int i)
    {
        return i >= i && i <= 26 ? (char) ('a' + i - 1) : null;
    }

    public static String convertToAlphabetCharacters(int num)
    {
        String numString = Integer.toString(num);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numString.length(); i++)
        {
            int digit = Character.getNumericValue(numString.charAt(i));
            char c = convertNumberToCharacter(digit);
            result.append(c);
        }
        return result.toString();
    }

    // Methods for Question 4
    public static long countOccurrences(String s, String targetChars)
    {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> targetChars.contains(Character.toString(c)))
                .count();
    }

    public static boolean hasHigherVowels(String s)
    {
        long vowels = countOccurrences(s, "aeiou");
        long consonants = countOccurrences(s, "bcdfghjklmnpqrstvwxyz");
        return vowels > consonants;
    }

    public static boolean hasEqualVowelsConsonants(String s)
    {
        long vowels = countOccurrences(s, "aeiou");
        long consonants = countOccurrences(s, "bcdfghjklmnpqrstvwxyz");
        return vowels == consonants;
    }

    public static String modifyString(String s)
    {
        if (hasHigherVowels(s))
            return replaceOneLetter(s);
        else if (hasEqualVowelsConsonants(s))
            return randomReplace(s);
        else
            return s;
    }

    public static String replaceOneLetter(String s)
    {
        return hasEqualVowelsConsonants(s) ? randomReplace(s) : s;
    }

    public static String randomReplace(String s)
    {
        StringBuilder modified = new StringBuilder(s);
        Random random = new Random();

        String letters = "abcdefghijklmnopqrstuvwxyz";

        int indexToReplace = random.nextInt(s.length());
        char newChar = letters.charAt(random.nextInt(letters.length()));

        modified.setCharAt(indexToReplace, newChar);

        return modified.toString();
    }

    public static String reverseString(String s)
    {
        StringBuilder result = new StringBuilder(s).reverse();
        return result.toString();
    }
}
