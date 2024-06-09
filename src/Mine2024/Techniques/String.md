Interesting tricks and tips for working with strings in Java


## Table of Contents

- [String](#string)
  - [String to Array of Characters](#string-to-array-of-characters)
  - [Remove char at index from String](#remove-char-at-index-from-string)
  - [String Concatenation](#string-concatenation)
  - [String Comparison](#string-comparison)
  - [String Length](#string-length)
  - [String Substring](#string-substring)
  - [String Split](#string-split)
  - [String Replace](#string-replace)
  - [String Trim](#string-trim)
  - [String Format](#string-format)
  - [String Case Conversion](#string-case-conversion)
  - [String Reverse](#string-reverse)
  - [String Palindrome](#string-palindrome)
  - [String Anagram](#string-anagram)
  - [String Permutation](#string-permutation)
  - [String Rotation](#string-rotation)
  - [String Compression](#string-compression)
  - [String Rotation](#string-rotation)


## String
### String to Array of Characters
```java
String str = "hello";
char[] charArray = str.toCharArray();
```

### Remove char at index from String
```java
String originalString = "hello";
int index = 2;
String newStr = originalString.substring(0, index) + originalString.substring(index + 1);
```
Or
```java
StringBuilder stringBuilder = new StringBuilder(originalString);
stringBuilder.deleteCharAt(indexToRemove);
String modifiedString = stringBuilder.toString();
```

