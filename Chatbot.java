import java.util.Scanner;
import java.util.Locale;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Chatbot {
    private static String context = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm your chatbot. How can I assist you today?");
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            String normalizedInput = normalizeInput(userInput);
            String response = generateResponse(normalizedInput);
            System.out.println("Chatbot: " + response);
            
            if (response.equals("Goodbye! Have a great day!")) {
                break;
            }
        }
        
        scanner.close();
    }

    private static String normalizeInput(String input) {
        String normalizedInput = Normalizer.normalize(input, Normalizer.Form.NFD);
        normalizedInput = normalizedInput.replaceAll("[^\\p{ASCII}]", "");
        return normalizedInput.toLowerCase(Locale.ENGLISH).trim();
    }

    private static String generateResponse(String userInput) {
        if (userInput.contains("hello") || userInput.contains("hi")) {
            return "Hi there!";
        } else if (userInput.contains("how are you")) {
            return "thanks for asking! I'm happy for asking about me, I'm fine and you ?";
        } else if (userInput.contains("bye")) {
            return "Goodbye! Have a great day!";
        } else if (userInput.contains("weather")) {
            return "Currently, the weather is sunny with a temperature of 20 degrees Celsius.";
        } else if (userInput.contains("news")) {
            return "Here are some of the latest news headlines...";
        } else if (userInput.contains("translate")) {
            return "Translated response...";
        } else if (userInput.contains("sentiment")) {
            return "The sentiment of your message is positive!";
        } else {
            return "I'm sorry, I didn't understand that. Can you please rephrase?";
        }
    }
}
