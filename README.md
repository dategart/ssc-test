##  Exercise 1 - Run Length Encoding

Given a string, Your task is to complete the function encode that returns the run length encoded string for the given 
string. eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″. You are required
to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded 
string.

Example 1:
Input: str = aaaabbbccc Output: a4b3c3 
Explanation: a repeated 4 times consecutively b 3 times, c also 3 times.
Example 2:
Input: str = abbbcdddd Output: a1b3c1d4

Your Task: Complete the function encode() which takes a character array as a input parameter and returns the 
encoded string. You can use Java/C#/NodeJS for this exercise and an IDE of your choice.

Implementation Note: we won't restrict to alphanumeric characters only.

## How to execute and run tests

Build:
```
./mvnw compile
```

Execute with one of the following:
```
java -cp target/classes ssc.CharCounter "ddooodd"
./mvnw exec:java -Dexec.args="aaabbbdddeeef"
```

Tests:
```
./mvnw test
```