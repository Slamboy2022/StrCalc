
import java.util.Scanner;

public class Calc {



    public String calcMat() {
        Scanner scanner = new Scanner(System.in);
        String res;
        String input = scanner.nextLine();

        String[] inputStr = new String[2];

            if(input.contains("+") || input.contains("-")) {
                input = input.substring(1,input.length() - 1);
                inputStr = input.split("\"");
            }
            else if (input.contains("*") || input.contains("/")){
                inputStr = input.split(" ");
            }

            inputStr[2] = inputStr[2].replace("\"", "");
            inputStr[0] = inputStr[0].replace("\"", "");
            inputStr[1] = inputStr[1].replace(" ", "");

            switch (inputStr[1]) {
                case "+": {
                    res = inputStr[0] + inputStr[2];
                    break;
                }
                case "-": {
                    res = inputStr[0].replace(inputStr[2], "");
                    break;
                }
                case "/": {
                    try {
                        int n = parse(inputStr[2]);
                        int subStrLength = inputStr[0].length() / n;
                        res = inputStr[0].substring(0, subStrLength);
                        break;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("ОШИБКА: Нельзя делить на строку!");
                    }
                }
                case "*": {
                    try {
                        int n = parse(inputStr[2]);
                        StringBuilder builder = new StringBuilder();
                        int i = 0;
                        while (i != n) {
                            i++;
                            builder.append(inputStr[0]);
                        }
                        res = builder.toString();
                        break;
                    } catch (NumberFormatException e) {
                        res = "ОШИбКА: Нельзя умножить на строку";
                        break;
                    }
                }
                default: {
                    throw new IllegalArgumentException("ОШИБКА: неправильный оператор!");
                }
            }
            if (res.length() > 40) {
                res = res.substring(0, 40) + "...";
            }

            return "Ответ: " + "\"" + res + "\"";
    }

    private int parse(String s)
    {
        int result = Integer.parseInt(s);
        if(result < 1 || result > 10) {
            throw new IllegalArgumentException("ОШИБКА: Числа могут быть только от 1 до 10");
        }
        else
        {
            return result;
        }
    }
}
