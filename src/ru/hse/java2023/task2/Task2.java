package ru.hse.java2023.task2;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {
  
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    String filenameIn, filenameOut;
    try {
      System.out.println("Enter absolute path to file to read:");
      filenameIn = scan.nextLine();
      System.out.println("Enter absolute path to file to write:");
      filenameOut = scan.nextLine();
    } catch (NoSuchElementException | IllegalStateException exception) {
      System.out.println("Something went wrong while reading line");
      return;
    }
    File fileIn = new File(filenameIn);
  
    int uppercase = 0, lowercase = 0;
  
    try (FileReader fileReader = new FileReader(fileIn)) {
      int symbol;
      while ((symbol = fileReader.read()) != -1) {
        if (symbol >= 'A' && symbol <= 'Z') {
          uppercase++;
        } else if (symbol >= 'a' && symbol <= 'z') {
          lowercase++;
        }
      }
    } catch (IOException exc) {
      System.out.println("Error while reading file");
      return;
    }
  
    String out = String.format("Uppercase: %d\nLowercase: %d", uppercase, lowercase);
  
    File fileOut = new File(filenameOut);
    try (FileWriter fileWriter = new FileWriter(fileOut)) {
      fileWriter.write(out);
      System.out.println("Successfully wrote to file " + filenameOut);
    } catch (IOException exception) {
      System.out.println("Error while writing to file");
    }
  }
}
