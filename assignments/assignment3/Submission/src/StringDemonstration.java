public class StringDemonstration {
    public static void main(String[] args) {
        // Parameterized constructor
        String str = new String("Yashwant");
        System.out.println("Hello " + str);

        // String literal using static memory
        String str2 = "Yash";
        System.out.println("Hello again! " + str2);

		/*
			Difference beteween static memory string and new keyword string is that
			static memory is allotted at compile time and new keyword string is
			allotted at runtime.
		*/

        // 1. charAt()
        System.out.println("Character at position 1: " + str.charAt(1));
		// we get character at specified index


        // 2. codePointAt()
        System.out.println("Code point at position 3: " + str.codePointAt(3));
		// we get unicode value of character at specified index

        // 3. codePointBefore()
        System.out.println("Code point before position 3: " + str.codePointBefore(3));
		// we get unicode value of character before specified index, in this case 
		// we get unicode value of character before index 3, that is index 2.

        // 4. codePointCount()
        System.out.println("Code point count: " + str.codePointCount(0, 4));
		// we get number of unicode values between specified indexes

        // 5. compareTo()
        System.out.println("Comparison of strings 'Yashwant' and 'Apple': " + str.compareTo("Apple"));
		// we get difference of unicode values of first different character in both strings
		// this is also called lexicographical comparison

        // 6. compareToIgnoreCase()
        System.out.println("Comparison of strings 'Yashwant' and 'apple' ignoring case: " + str.compareToIgnoreCase("apple"));

        // 7. concat()
        System.out.println("Concatenation of 'Yashwant' and ' Bhosale': " + str.concat(" Bhosale"));
		// join two strings

        // 8. contains()
        System.out.println("Does the string 'Yashwant' contain 'want'? " + str.contains("want"));
		// check if string contains specified substring

        // 9. contentEquals()
        StringBuffer sb = new StringBuffer("Yashwant");
        System.out.println("Does 'Yashwant' contentEquals 'Yashwant' (StringBuffer)? " + str.contentEquals(sb));
		// check if string is equal to specified stringbuffer or stringbuilder

        // 10. copyValueOf()
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        System.out.println("copyValueOf() output: " + String.copyValueOf(charArray));
		// copy values of character array to string

        // 11. endsWith()
        System.out.println("Does 'Yashwant' end with 'nt'? " + str.endsWith("nt"));
		// check if string ends with specified substring

        // 12. equals()
        System.out.println("Does 'Yashwant' equal 'Yashwant'? " + str.equals("Yashwant"));
		// check if string is equal to specified string

        // 13. equalsIgnoreCase()
        System.out.println("Does 'Yashwant' equalIgnoreCase 'yashwant'? " + str.equalsIgnoreCase("yashwant"));
		// check if string is equal to specified string ignoring case

        // 14. format()
        String formattedString = String.format("Name: %s, Age: %d", "Yashwant", 25);
        System.out.println("Formatted string: " + formattedString);
		// works like printf in C

        // 15. getBytes()
        byte[] byteArray = str.getBytes();
        System.out.println("Byte array from string:");
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
        System.out.println();
		// get byte array of string, bytes are 8bit integers

        // 16. getChars()
        char[] chars = new char[8];
        str.getChars(0, 8, chars, 0);
        System.out.print("getChars() output: [ ");
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println("]");
		// get characters from string and store them in character array
		// Note: getChars() doesnt return character array, it stores characters in specified character array

        // 17. hashCode()
        System.out.println("Hash code of 'Yashwant': " + str.hashCode());
		// get hash code of string
		// In Java, the hash code of a string is a numerical value calculated using a specific formula. It's used in data structures like HashMaps and HashSets 
		// to efficiently store and retrieve data.


        // 18. indexOf()
        System.out.println("Index of 'h' in 'Yashwant': " + str.indexOf('h'));

        // 19. intern()
        String internedStr = str.intern();
        System.out.println("Interned string: " + internedStr);
		// returns canonical representation of string,
		/*
			We know that creating an object is a costly operation in Java. Therefore, 
			to save time, Java developers came up with the concept of String Constant 
			Pool (SCP). The SCP is an area inside the heap memory. It contains the 
			unique strings. In order to put the strings in the string pool, one needs 
			to call the intern() method. Before creating an object in the string pool, 
			the JVM checks whether the string is already present in the pool or not. 
			If the string is present, its reference is returned.

			ref: https://www.javatpoint.com/java-string-intern
		*/

        // 20. isEmpty()
        String emptyStr = "";
        System.out.println("Is empty string empty? " + emptyStr.isEmpty());

        // 21. join()
        String joinedStr = String.join("-", "Hello", "World");
        System.out.println("Joined string: " + joinedStr);
		// join strings with specified delimiter

        // 22. lastIndexOf()
        System.out.println("Last index of 'a' in 'Yashwant': " + str.lastIndexOf('a'));
		// we get last index of specified character

        // 23. length()
        System.out.println("Length of 'Yashwant': " + str.length());

        // 24. matches()
        System.out.println("Does 'Yashwant' match regex '[A-Za-z]+'? " + str.matches("[A-Za-z]+"));
		// check if string matches specified regex
		// [A-Za-z]+ means string should contain only alphabets

        // 25. offsetByCodePoints()
        System.out.println("Offset by code points from index 2 by 2: " + str.offsetByCodePoints(2, 2));
		// get index of character after specified number of unicode values from specified index

        // 26. regionMatches()
        System.out.println("Region matches 'Yash' in 'Yashwant': " + str.regionMatches(0, "Yash", 0, 4));
		// check if specified region of string matches specified region of another string
		// here we are checking if 'Yash' in 'Yashwant' matches 'Yash' in 'Yash'
		// 0, 4 are starting index and length of region in first string

        // 27. replace()
        System.out.println("Replacing 's' with '$': " + str.replace('s', '$'));

        // 28. replaceAll()
        System.out.println("Replacing 'a' with '@' using replaceAll(): " + str.replaceAll("a", "@"));

		/*
			Difference between replace and replaceAll(): 
			replace() method replaces all the occurrences of the specified character
			replaceAll() method replaces all the occurrences of the specified sequence of 
			characters(uses regex)
		*/

        // 29. replaceFirst()
        System.out.println("Replacing first 'a' with '@': " + str.replaceFirst("a", "@"));
		// replace first occurrence of specified substring with another substring

        // 30. split()
        String[] splitArray = str.split("a");
        System.out.println("Splitting 'Yashwant' by 'a': ");
        for (String s : splitArray) {
            System.out.println(s);
        }
		// split string by specified delimiter

        // 31. startsWith()
        System.out.println("Does 'Yashwant' start with 'Ya'? " + str.startsWith("Ya"));
		// check if string starts with specified substring

        // 32. subSequence()
        System.out.println("Subsequence (0-4): " + str.subSequence(0, 4));
		// get subsequence of string from specified indexes

        // 33. substring()
        System.out.println("Substring (5-8): " + str.substring(4, 8));
		// get substring of string from specified indexes

		/*
			subSequence() and substring() are similar, the only difference is that
			subSequence() returns CharSequence and substring() returns String

			charSequence is an interface in Java that represents a sequence of characters.
			String, StringBuffer, and StringBuilder classes implement the CharSequence interface.
			ref: https://stackoverflow.com/questions/26560440/difference-between-subsequence-and-substring-methods-in-java-string-class
		*/

        // 34. toCharArray()
        char[] charArr = str.toCharArray();
        System.out.println("Character array from string: ");
        for (char c : charArr) {
            System.out.print(c + " ");
        }
        System.out.println();
		// string to character array

        // 35. toLowerCase()
        System.out.println("Lowercase string: " + str.toLowerCase());

        // 36. toUpperCase()
        System.out.println("Uppercase string: " + str.toUpperCase());

        // 37. trim()
        String strWithSpaces = "   Yashwant   ";
        System.out.println("Trimmed string: '" + strWithSpaces.trim() + "'");
		// remove leading and trailing whitespaces

        // 38. valueOf()
        int num = 100;
        System.out.println("String value of 100: " + String.valueOf(num));
		// convert integer to string
    }
}
