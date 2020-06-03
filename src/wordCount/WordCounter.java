/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sakemi
 */
public class WordCounter {

    public static void getWordCount(String inputFileName) {
        BinarySearchTree tree = new BinarySearchTree();

        String[] inputText = WordCounter.readInputFile(inputFileName).split(" ");

        for (int i = 0; i < inputText.length; i++) {
            WordCounter.countWords(inputText[i].toLowerCase(), tree);
        }

        tree.inOrder();
    }

    public static void countWords(String word, BinarySearchTree tree) {
        Node wordNode = tree.binSearch(word);

        if (wordNode == null) {
            tree.add(word);
        } else {
            wordNode.increment();
        }
    }

    public static String readInputFile(String inputFile) {
        StringBuilder inputFileText = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String filteredLine = filterWords(line);

                inputFileText.append(filteredLine);
            }
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + inputFile + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + inputFile + "'");
        }

        return inputFileText.toString().trim();
    }

    public static String filterWords(String line) {
        Pattern wordsPattern = Pattern.compile("([A-Z]+)", Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordsPattern.matcher(line);

        StringBuilder filteredLine = new StringBuilder();

        while (wordMatcher.find()) {
            String word = wordMatcher.group();

            filteredLine.append(" " + word);

        }

        return filteredLine.toString();
    }

}
