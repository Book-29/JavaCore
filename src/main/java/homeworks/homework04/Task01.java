package homeworks.homework04;
//Задача 1. Для введенной с клавиатуры буквы английского алфавита
//нужно вывести слева стоящую букву на стандартной клавиатуре. При этом
//клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a», а слева от "а"
//буква "р", также соседними считаются буквы «l» и буква «z», а буква «m» с
//буквой «q».

import java.util.Scanner;

public class Task01 {
public static void main(String[] args) {

    String  alphabet = "qwertyuiopasdfghjklzxcvbnm";//строки

    Scanner console =new Scanner(System.in);
    System.out.println("Введите букву: ");
    String input = console.nextLine();
    char letter = input.charAt(0);
    int index = alphabet.indexOf(letter);
    if (index == 0) {
        System.out.println(alphabet.charAt(alphabet.length() - 1));
    } else {
        System.out.println(alphabet.charAt(index - 1));
    }
}



}




