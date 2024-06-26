/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.numericmaster;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author JOHN RAMON
 */
public class Exhandling {
        public static boolean adjacentLetters(String equation) {
        // Convert the equation to a character array for easy comparison
        char[] chars = equation.toCharArray();

        // Iterate through the character array
        for (int i = 0; i < chars.length - 1; i++) {
            // Check if the current character and the next character are letters
            if (Character.isLetter(chars[i]) && Character.isLetter(chars[i + 1])) {
                // Check if they are the same letter
                if (chars[i] == chars[i + 1]) {
                    JOptionPane.showMessageDialog(null, "No adjacent letters ", "Warning", JOptionPane.WARNING_MESSAGE);
                    // If a pair of consecutive identical letters is found, return true
                    return false;
                }
            }
        }
        // If no consecutive identical letters are found, return false
        return true;
    }
        
        public static boolean emptyFieldsCheck(Object...params) {
		for (Object param :params){
			if (param.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in all fields", "Warning", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
        return true;
	}
        public static boolean doubleCheck(String... tests) {
         for (String test : tests) {
            try {
                Double.parseDouble(test);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "The input should be a number: " + test, "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

        
    // Method to check if the equation contains only one type of letter
    public static boolean oneTypeOfLetter(String equation) {
        Set<Character> variables = new HashSet<>();
        for (char c : equation.toCharArray()) {
            if (Character.isLetter(c)) {
                if (!variables.isEmpty() &&!variables.contains(c)) {
                    JOptionPane.showMessageDialog(null, "You should only choose one letter as variable", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                variables.add(c);
            }
        }
        return true;
    }

        public static boolean spaceCheck(String equation) {
        if (equation.contains(" ")) {
            JOptionPane.showMessageDialog(null, "There are spaces in the equation. Please remove them.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }return true;
    }

     public static boolean sqrTestCheck(Double sqrTest) {
         if (sqrTest <0){
            JOptionPane.showMessageDialog(null, "Input another initial guess","", JOptionPane.ERROR_MESSAGE);
            return false;
        }
         return true;
     }
     
    public static boolean checkEquation(String equation) {
        // Check for invalid operators
        if (Pattern.compile("[+-/*^]{2,}").matcher(equation).find()) {
            JOptionPane.showMessageDialog(null, "Invalid operator.");
            return false;
        }

        // Check for mismatched parentheses
        if (countOccurrences(equation, '(')!= countOccurrences(equation, ')')) {
            JOptionPane.showMessageDialog(null, "Mismatched parentheses.");
            return false;
        }

        // Check for valid characters
        for (char c : equation.toCharArray()) {
            if (!Character.isLetter(c) &&!Character.isDigit(c) && 
                c!= '+' && c!= '-' && c!= '*' && c!= '/' && c!= '^' && c!= '(' && c!= ')' && c!= '.') {
                JOptionPane.showMessageDialog(null, "Invalid character.");
                return false;
            }
        }

        // Check if equation ends with an operator
        char lastChar = equation.charAt(equation.length() - 1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '^') {
            JOptionPane.showMessageDialog(null, "Equation cannot end with an operator.");
            return false;
        }

        return true;
    }


    private static int countOccurrences(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
