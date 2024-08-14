import java.util.Scanner;

public class Main {
    public static void check(String operation) throws Exception {
        Scanner calculate = new Scanner(System.in);
        char sign;
        String[] inf;

        if (operation.contains(" + ")) {
            inf = operation.split(" \\+ ");
            sign = '+';
        } else if (operation.contains(" - ")) {
            sign = '-';
            inf = operation.split(" - ");
        } else if (operation.contains(" * ")) {
            sign = '*';
            inf = operation.split(" \\* ");
        } else if (operation.contains(" / ")) {
            sign = '/';
            inf = operation.split(" / ");
        } else {
            throw new Exception("Операция указана неверно. Повторите еще раз");
        }
        if (sign == '*' || sign == '/') {
            if (inf[1].contains("\"")) throw new Exception("Строку умножать или делить можно только на число");
        } else if (sign == '+' || sign == '-') {
            if (!inf[0].contains("\""))
                throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка!");

            int first = inf[0].indexOf("\"");
            int second = inf[0].indexOf("\"", first + 1);
            if (second == -1)
                throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка!");
        }
        if (inf[0].length() > 12)
            throw new Exception("Вы ввели более 10 символов!");
        if (inf[1].length() > 12)
            throw new Exception("Вы ввели более 10 символов!");

        }

    public static String getOperation() throws Exception {
        Scanner calculate = new Scanner(System.in);
        System.out.println("Введите операцию:");
        String operation = calculate.nextLine();
        try {
            check(operation);
        } catch (Exception e) {
            System.out.println(e.toString());
            return "";
        }

        if (operation.contains(" + ")) {
            System.out.println(get1(operation));
        } else if (operation.contains(" - ")) {
            get2(operation);
        } else if (operation.contains(" * ")) {
            get3(operation);
        } else if (operation.contains(" / ")) {
            get4(operation);

        }
        return operation;
    }

    public static String get1(String plus){
        plus = plus.replace(" ","");
        String result = plus.replace("+", "");
        String quotes = "\"" + plus.replace("\"", "") + "\"";
        quotes = quotes.replace("+", "");
        return quotes;
    }

    public static void get2(String minus){
        String arr3[] = minus.split("\"");
        String firstWord3 = arr3[1];
        String secondWord3 = arr3[2];
        int crossIndex = firstWord3.indexOf(arr3[3]);
        if (crossIndex >= 0) {
            System.out.println("\"" + firstWord3.substring(0,crossIndex) + "\"");
        } else System.out.println("\"" + firstWord3 + "\"");
    }

    public static boolean get3(String mul) throws Exception {
        mul = mul.replaceAll("\"", "");
        String arr4[] = mul.split(" ");
        String firstWord4 = arr4[0];
        String secondWord4 = arr4[1];
        String thirdWord4 = arr4[2];
        int num = Integer.parseInt(thirdWord4);
        while (num < 1 || num > 10) {
            throw new Exception("Калькулятор принимает числа от 1 до 10 включительно, не более!");
        }
        if (firstWord4.repeat(num).length()>40) {
            System.out.println("\"" + firstWord4.repeat(num).substring(0, 40) + "...");
        } else System.out.println("\"" + firstWord4.repeat(num) + "\"");
        return false;
    }

    public static boolean get4(String split) {
        String arr[] = split.split("\"");
        String firstWord = arr[0];
        String secondWord = arr[1];
        String thirdWord = arr[2];
        String arr2[] = thirdWord.split(" ");
        String firstThirdWord = arr2[0];
        String secondThirdWord = arr2[1];
        String thirdThirdWord = arr2[2];
        int num2 = Integer.parseInt(thirdThirdWord);
        int finalLen = secondWord.length() / num2;
        split = secondWord.substring(0, finalLen);
        System.out.println("\"" + split + "\"");
        return false;
    }

    public static String allIn() throws Exception {
        String result = getOperation();
        return result;
    }

    public static void main(String[] args) throws Exception {
        Main obj = new Main();
            obj.getOperation();
    }
}

