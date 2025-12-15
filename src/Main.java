import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String menu = """
                
                Welcome to Currency Converter App
                  Please, select from the menu
                
                1) Dollar =>> Real
                2) Real =>> Dollar
                3) Dollar =>> Argentine Peso
                4) Argentine Peso =>> Dollar
                5) Dollar =>> Colombian Peso
                6) Colombian Peso =>> Dollar
                7) Leave
                
                
                """;

        String[] fromCurrencyMap = {"", "USD", "BRL", "USD", "ARS", "USD", "COP"};
        String[] toCurrencyMap = {"", "BRL", "USD", "ARS", "USD", "COP", "USD"};
        String[] fromMonetarySymbol = {"", "US$", "R$", "US$", "ARS$", "US$", "COP$"};
        String[] toMonetarySymbol = {"", "R$", "US$", "ARS$", "US$", "COP$", "US$"};

        ExchangeRateService exchange = new ExchangeRateService();
        Scanner input = new Scanner(System.in);
        System.out.println(menu);
        int inputValue = input.nextInt();
        while (inputValue != 7) {
            try {
                if (inputValue < 1 || inputValue > 7) {
                    throw new InvalidInputException("Invalid input. Choose options 1-6 or 7 to leave");
                }

                System.out.println("\nWhat value you want to convert?");
                double valueToConvert = input.nextDouble();
                double finalValue = valueToConvert * exchange.getExchangeRate(fromCurrencyMap[inputValue], toCurrencyMap[inputValue]);
                System.out.printf("\n%s%.2f corresponds to %s%.2f%n",
                        fromMonetarySymbol[inputValue], valueToConvert,
                        toMonetarySymbol[inputValue], finalValue);
                System.out.println();
                System.out.println(menu);

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println(menu);
            }
            inputValue = input.nextInt();
        }
        System.out.println("See you next time!");
    }
}