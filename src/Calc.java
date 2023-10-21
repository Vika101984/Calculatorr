import java.util.Scanner;
public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение:два операнда и один оператор(числа арабские или римские):");
        String input = sc.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        int x;
        int y;
        String oper;
        String res;
        boolean isRoman;
        String[] operands = input.split("[+\\-*/]");
        if (operands.length != 2) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, *, /)");
        }
        oper = operation(input);
        if (!RomanNumerals.isRoman(operands[0]) && !RomanNumerals.isRoman(operands[1])) {
            x = Integer.parseInt(operands[0]);
            y = Integer.parseInt(operands[1]);
            isRoman = false;
        } else if (RomanNumerals.isRoman(operands[0]) && RomanNumerals.isRoman(operands[1])) {
            x = RomanNumerals.convertToArabian(operands[0]);
            y = RomanNumerals.convertToArabian(operands[1]);
            isRoman = true;
        } else {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }
        if (x < 1 || y < 1 && x > 10 || y > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arab = RomanNumerals.calculator(x, y, oper);
        if (isRoman) {
            if (arab < 1) {
                throw new Exception("т.к. в римской системе нет отрицательных чисел");
            }
            res = RomanNumerals.convertToRoman(arab);
        } else {
            res = String.valueOf(arab);
        }
        return res;
    }
    public static String operation(String input)throws Exception {
        if (input.contains("+")) {
            return "+";
        } else if (input.contains("-")) {
            return "-";
        } else if (input.contains("*")) {
            return "*";
        } else if (input.contains("/")) {
            return "/";
        } else {
            throw new Exception("Неподдерживаемая математическая операция");
        }
    }
}
class RomanNumerals {
    static String[] listOfRoman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val) {
        for (int i = 0; i < listOfRoman.length; i++) {
            if (val.equals(listOfRoman[i])) {
                return true;
            }
        }
        return false;
    }
    public static int convertToArabian(String rom) {
        for (int i = 0; i < listOfRoman.length; i++) {
            if (rom.equals(listOfRoman[i])) {
                return i;
            }
        }
        return -1;
    }
    static int calculator(int a, int b, String oper) {
        if (oper.equals("+")) {
            return a + b;
        } else if (oper.equals("-")) {
            return a - b;
        } else if (oper.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
    public static String convertToRoman(int arab) {
        return listOfRoman[arab];
    }
}
