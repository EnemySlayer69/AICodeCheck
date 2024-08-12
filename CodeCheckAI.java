import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeCheckAI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your code below (type 'END' on a new line to finish):");
        
        StringBuilder codeBuilder = new StringBuilder();
        String line;
        
        while (!(line = scanner.nextLine()).equals("END")) {
            codeBuilder.append(line).append("\n");
        }
        
        String code = codeBuilder.toString();
        checkCode(code);
        scanner.close();
    }

    private static void checkCode(String code) {
        System.out.println("\nCode Checking Results:");
        checkSemicolons(code);
        checkBrackets(code);
    }

    private static void checkSemicolons(String code) {
        Pattern pattern = Pattern.compile("(?<!\\w|\\d)(\\w+)(?!\\w|\\d)(\\s*;\\s*)");
        Matcher matcher = pattern.matcher(code);
        int semicolonCount = 0;
        
        while (matcher.find()) {
            semicolonCount++;
        }
        
        if (semicolonCount == 0) {
            System.out.println("No semicolons found. Make sure all statements end with a semicolon.");
        } else {
            System.out.println("Found " + semicolonCount + " semicolons.");
        }
    }

    private static void checkBrackets(String code) {
        int openBrackets = 0;
        int closeBrackets = 0;
        
        for (char ch : code.toCharArray()) {
            if (ch == '{') openBrackets++;
            if (ch == '}') closeBrackets++;
        }
        
        if (openBrackets != closeBrackets) {
            System.out.println("Mismatch in curly brackets. Check for unclosed or extra brackets.");
        } else {
            System.out.println("Curly brackets are balanced.");
        }
    }
}
