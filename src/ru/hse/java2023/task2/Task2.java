package ru.hse.java2023.task2;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {
  
  public static int CompleteCycle() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter absolute path to file:");
    String filename;
    try {
      filename = scan.nextLine();
    } catch (NoSuchElementException | IllegalStateException exception) {
      System.out.println("Something went wrong while reading line");
      return -1;
    }
    System.out.println("filename = " + filename);
    File fileIn = new File(filename);
    
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
  
    System.out.println("uppercase = " + uppercase + "; lowercase = " + lowercase);
    return 0;
  }
  public static void main (String[] args) {
    if (CompleteCycle() < 0) {
      System.out.println("No");
    }
    System.out.println("Yes");
  }
}
