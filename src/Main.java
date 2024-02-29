public class Main {
    public static void main(String[] args)
    {
        Calc calc = new Calc();
        System.out.println("*** Калькулятор умеет выполнять операции");
        System.out.println("*** Cложение строк, вычитания строки из строки, умножения строки на число и деления строки на число");
        System.out.println("*** \"a\" + \"b\", \"a\" - \"b\", \"a\" * b, \"a\" / b");
        System.out.println("Ввод:");
        String result = calc.calcMat();
        System.out.println(result);
    }
}