package homeworks.homework08;

import homeworks.homework08.person.Person;
import homeworks.homework08.product.DiscountProduct;
import homeworks.homework08.product.Product;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStream;

public class App {

    public static void main(String[] args) {
        String inputPath = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework08/data.txt";
        String outputPath = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework08/output.txt";


        List<Product> products = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        Map<String, List<String>> personOrders = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
        BufferedWriter br2 = new BufferedWriter(new FileWriter(outputPath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                System.out.println("Чтение строки " + lineNumber + ": " + line);
                String[] data = line.split("[;,]");
                for (String s : data) {
                    if (lineNumber == 1) {
                        String[] split = s.split("=");
                        if (split.length == 2) {
                            String key = split[0].trim();
                            int value = Integer.parseInt(split[1].trim().replace(", ", ""));
                            persons.add(new Person(key, value));
                        }
                    } else if (lineNumber == 2) {

                        String[] split = s.split("=");
                        if (split.length == 2) {
                            String key = split[0].trim();
                            int value = Integer.parseInt(split[1].trim().replace(", ", ""));
                            products.add(new Product(key, value));
                        }

                    } else if (lineNumber > 2) {
                        System.out.println("Обработка строки заказа: " + line);
                        String[] split = s.split(" ");
                        if (split.length > 1) {
                            String key;
                            String value;

                            if (split.length > 2) {
                                key = split[0].trim() + " " + split[1].trim();
                                value = String.join(" ", Arrays.copyOfRange(split, 2, split.length)).trim();
                            } else {
                                key = split[0].trim();
                                value = "";
                            }

                            if (!personOrders.containsKey(key)) {
                                personOrders.put(key, new ArrayList<>());
                            }
                            personOrders.get(key).add(value);
                            br2.write(key + " купил " + value);
                            br2.newLine();
                        }
                    }
                }
            }
            if (personOrders.isEmpty()) {
                System.out.println("Нет заказов");
            } else {
                for (Map.Entry<String, List<String>> entry : personOrders.entrySet()) {
                  String orders =  entry.getValue().toString();
                   orders = orders.replace("[", "").replace("]", "");
                  br2.write(entry.getKey() + " - " + orders);
                   br2.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}







