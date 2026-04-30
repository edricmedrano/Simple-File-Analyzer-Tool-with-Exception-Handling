import java.io.*;
import java.util.Scanner;

public class FileAnalyzer {

    public void analyzeFile() {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter filename: ");
            String filename = input.nextLine();

            if (filename.equals("")) {
                throw new EmptyFilenameException("you didnt type anything");
            }

            File file = new File(filename);

            if (!file.exists()) {
                System.out.println("file doesnt exist");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            int lines = 0;
            int words = 0;
            int characters = 0;

            String line = reader.readLine();

            while (line != null) {
                lines = lines + 1;

                characters = characters + line.length();

                String[] parts = line.split(" ");
                words = words + parts.length;

                line = reader.readLine();
            }

            reader.close();

            System.out.println("");
            System.out.println("File Analysis Summary");
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);

            PrintWriter writer = new PrintWriter("analysis_output.txt");

            writer.println("File Analysis Summary");
            writer.println("Lines: " + lines);
            writer.println("Words: " + words);
            writer.println("Characters: " + characters);

            writer.close();

            System.out.println("saved to analysis_output.txt");

        } catch (EmptyFilenameException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("file not found error");
        } catch (IOException e) {
            System.out.println("some error happened reading file");
        }

    }
}
