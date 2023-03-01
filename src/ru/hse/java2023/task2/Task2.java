package ru.hse.java2023.task2;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {
  
  public static int CompleteCycle() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter absolute path to file to be read and then the one to be wrote at:");
    String filenameIn, filenameOut;
    try {
      filenameIn = scan.nextLine();
      filenameOut = scan.nextLine();
    } catch (NoSuchElementException | IllegalStateException exception) {
      System.out.println("Something went wrong while reading line");
      return -1;
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
      return -1;
    }
  
    String out = String.format("Uppercase: %d\nLowercase: %d", uppercase, lowercase);
    
    File fileOut = new File(filenameOut);
    try (FileWriter fileWriter = new FileWriter(fileOut)) {
      fileWriter.write(out);
    } catch (IOException exception) {
      System.out.println("Error while writing to file");
      return -1;
    }
    
    return 0;
  }
  public static void main (String[] args) {
    if (CompleteCycle() < 0) {
      System.out.println("No");
    }
    System.out.println("Yes");
  }
}
