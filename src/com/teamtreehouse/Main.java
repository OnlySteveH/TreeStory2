package com.teamtreehouse;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // TODO:csd - Instantiate a new Prompter object and prompt for the story template
        Prompter prompter = new Prompter();
        System.out.printf("%nWrite your story here mark word class for the story with surrounding it with __ (example: __name__) to be filled:%n");
        // call a method on Prompter
        String story = prompter.createStory();
        Template tmpl = new Template(story);
        // TODO:csd - Use the prompter object to have it do the prompting, censoring and outputting.  Call Prompter.run

        /**List<String> fakeResults = Arrays.asList(
                "friend",
                "talented",
                "java programmer",
                "high five"); **/

        // TODO:csd - This should really happen in the Prompter.run method, let's get these implementation details out of the main method
        String results = prompter.run(tmpl);
        System.out.printf("Your TreeStory:%n%n%s", results);

    }
}
