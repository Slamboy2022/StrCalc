
import java.util.Scanner;

public class Calc {
    Scanner scanner = new Scanner(System.in);

    protected String calcMat() throws IllegalArgumentException {
       String result = null;

       String[] input = scanner.nextLine().split(" ");

        if(input.length != 3) throw new IllegalArgumentException("ОШИБКА: должно быть введено Строка Оператор Строка/число!");

        String str1 = input[0].replace("\"", "" );
        String operator = input[1];
        String str2 = input[2];
        int n ;

        switch (operator)
        {
            case "+":
                result = str1 + str2;
                break;
            case "/":
                try {
                    n = parse(str2);
                    int subStrLength = str1.length() / n;
                    result = str1.substring(0, subStrLength);
                    break;
                }
                catch (NumberFormatException e){
                    result = "ОШИбКА: Нельзя делить на строку";
                }
            case "*":
                try {
                    n = parse(str2);
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < n; i++)
                    {
                        builder.append(str1);
                    }
                    result = builder.toString();
                }catch (NumberFormatException e)
                {
                    result = "ОШИбКА: Нельзя умножить на строку";
                }
                break;
            case "-":
                result = str1.replace(str2,"");
                break;
            default:
                throw new IllegalArgumentException("ОШИБКА: неправильный оператор!");

        }
        if(result.length() > 40)
        {
            result = result.substring(0,40) + "...";
        }
        return "Ответ: " + "\"" + result + "\"";
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
