package FindText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter directory of file: ");
        String directory = scanner.nextLine();
        System.out.print("Please enter string to search: ");
        String input = scanner.nextLine();

        String line;
        try {
            FileReader fr = new FileReader(directory);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null) {
                String[] words = line.split("[., ]");
                for (String word : words) {
                    if (word.contains(input)) {
                        System.out.println(word);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
