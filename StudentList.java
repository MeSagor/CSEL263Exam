import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static BufferedReader creatFileReadMode() {
        Constants cons = new Constants();
        try {
            BufferedReader file = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(cons.fileName)));
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public static BufferedWriter creatFileWriteMode() {
        Constants cons = new Constants();
        try {
            BufferedWriter file = new BufferedWriter(
                    new FileWriter(cons.fileName, true));
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {

        Constants cons = new Constants();

        if (args.length != 1) {
            System.out.println(cons.agrsDetails);
        }
        //		Check arguments
        else if (args[0].equals(cons.a)) {
            System.out.println(cons.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                String words[] = line.split(cons.comma);
                for (String word : words) {
                    System.out.println(word);
                }
            } catch (Exception e) {
            }
            System.out.println(cons.loaded);
        } else if (args[0].equals(cons.r)) {
            System.out.println(cons.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                System.out.println(line);
                String words[] = line.split(cons.comma);
                Random x = new Random();
                int randIdx = x.nextInt();
                System.out.println(words[randIdx]);
            } catch (Exception e) {
            }
            System.out.println(cons.loaded);
        } else if (args[0].contains(cons.plus)) {
            System.out.println(cons.loading);
            try {
                BufferedWriter file = creatFileWriteMode();
                String newData = args[0].substring(1);
                Date d = new Date();
                String df = cons.dateFormat;
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd = dateFormat.format(d);
                file.write(cons.comma + newData + cons.lastUp + fd);
                file.close();
            } catch (Exception e) {
            }

            System.out.println(cons.loaded);
        } else if (args[0].contains(cons.f)) {
            System.out.println(cons.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                String words[] = line.split(cons.comma);
                boolean done = false;
                String targetData = args[0].substring(1);
                for (int idx = 0; idx < words.length && !done; idx++) {
                    if (words[idx].equals(targetData)) {
                        System.out.println(cons.weFound);
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(cons.loaded);
        } else if (args[0].contains(cons.c)) {
            System.out.println(cons.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                char charArray[] = line.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : charArray) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + cons.wordFile + charArray.length);
            } catch (Exception e) {
            }
            System.out.println(cons.loaded);
        } else {
            System.out.println(cons.pleaseValid);
        }
    }
}