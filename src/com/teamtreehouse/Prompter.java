package com.teamtreehouse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Prompter {
    private BufferedReader mReader;
    private Set<String> mCensoredWords;

    public Prompter() {
        mReader = new BufferedReader(new InputStreamReader(System.in));
        loadCensoredWords();
    }

    private void loadCensoredWords() {
        mCensoredWords = new HashSet<String>();
        Path file = Paths.get("resources", "censored_words.txt");
        List<String> words = null;
        try {
            words = Files.readAllLines(file);
        } catch (IOException e) {
            System.out.println("Couldn't load censored words");
            e.printStackTrace();
        }
        mCensoredWords.addAll(words);
    }

    public String createStory(){
        System.out.println("Enter the story");
        String line = null;
        try {
            line = mReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public String run(Template tmpl) {
        List<String> results = null;
        try {
            results = promptForWords(tmpl);
        } catch (IOException e) {
            System.out.println("There was a problem prompting for words");
            e.printStackTrace();
            System.exit(0);
        }
        // TODO:csd - Print out the results that were gathered here by rendering the template
        return tmpl.render(results);
    }

    /**
     * Prompts user for each of the blanks
     *
     * @param tmpl The compiled template
     * @return
     * @throws IOException
     */
    public List<String> promptForWords(Template tmpl) throws IOException {
        List<String> words = new ArrayList<String>();
        for (String phrase : tmpl.getPlaceHolders()) {
            String word = promptForWord(phrase);
            words.add(word);
        }
        return words;
    }


    /**
     * Prompts the user for the answer to the fill in the blank.  Value is guaranteed to be not in the censored words list.
     *
     * @param phrase The word that the user should be prompted.  eg: adjective, proper noun, name
     * @return What the user responded
     */
    public String promptForWord(String phrase) throws IOException {
        // TODO:csd - Prompt the user for the response to the phrase, make sure the word is censored, loop until you get a good response.
        boolean valid = true;
        String answer = "";
        while(valid){
            System.out.printf("Enter a %s: ", phrase);
            answer = mReader.readLine();
            if(mCensoredWords.contains(answer)) {
                System.out.printf("%s is a censored word; try again: ", phrase);
            } else {
                valid = false;
            }
        }
        return answer;
    }
}
