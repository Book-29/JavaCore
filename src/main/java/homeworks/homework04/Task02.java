package homeworks.homework04;
//Задача 2. Задана последовательность, состоящая только из символов ‘>’,
//‘<’ и ‘-‘. Требуется найти количество стрел, которые спрятаны в этой
//последовательности. Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {
    public static void main(String[] args) {
        String arrows = ">>--><--<<";

        Pattern pattern = Pattern.compile(">>-->|<--<<");
        Matcher matcher = pattern.matcher(arrows);

        int counter = 0;

        while (matcher.find()) {
            counter++;
        }
        System.out.println(counter);
    }
}
