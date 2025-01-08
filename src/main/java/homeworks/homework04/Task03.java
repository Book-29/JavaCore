package homeworks.homework04;

//Задача 3*. Задана строка, состоящая из букв английского алфавита,
//разделенных одним пробелом. Необходимо каждую последовательность
//символов упорядочить по возрастанию и вывести слова в нижнем регистре.


import java.util.Arrays;

public class Task03 {
    public static void main(String[] args) {
        String alphabet = "qwertyui opasdfghjklzxcvbnm";//строки
            String[] words = alphabet.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        char[] charArray = words[i].toLowerCase().toCharArray();
                        Arrays.sort(charArray);
                        words[i] = new String(charArray);
                    }
        System.out.println(String.join(" ", words));
        }



}

