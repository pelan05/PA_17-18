package logicaJogo;

import logicaJogo.events.Event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Freader extends IOException {
    private String fileName;

    public Event[] ReadFile(String fileName, Event []event) {
        this.fileName = fileName;

        // This will reference one line at a time
        String line;
        String[] resulted;
        int i = 0;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                resulted = line.split("\\|");

                event[i] = new Event(Integer.parseInt(resulted[0]), resulted[1], resulted[2]);
                i++;
            }

            // Always close files.
            bufferedReader.close();
            return event;
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        return null;
    }

    public void ReadFile(String fileName) {
        this.fileName = fileName;

        // This will reference one line at a time
        String line;


        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();


        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

    }



}