package com.teamtreehouse;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Prompter prompter = new Prompter();
        System.out.printf("%nWrite your story here mark word class for the story with surrounding it with __ (example: __name__) to be filled:%n");
        // call a method on Prompter
        String story = prompter.createStory();
        Template tmpl = new Template(story);
        prompter.run(tmpl);
    }
}
