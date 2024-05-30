package com.example.test_challenge.service.problem1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissingLettersService {
    /**
     * generation of the list with all the lowercase characters of the english alphabet(codes 97- 122)
     * @return list with the lowercase characters
     */
    private List<Character> getControlString() {
        ArrayList<Character> elements = new ArrayList<>();
        for (int i = 97; i <= 122; i++) {
            elements.add((char) i);
        }
        return elements;
    }


    /**
     * function that search the missing letters on the input string
     * @param input string to analyze
     * @return  string with the letters that are not present on the input
     */
    public String findMissingLetters( String input){
        int length = input.length();
        int charPos =0;
        List<Character> missingLetters = getControlString();

        while( charPos< length && !missingLetters.isEmpty()){
            Character actualChar = Character.toLowerCase(input.charAt(charPos));
            if(isValidChar(actualChar)){
                missingLetters.remove(actualChar);
            }
            charPos++;
        }

        return  missingLetters.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    /**
     * verifies if the character corresponds with a valid 97-122 lowercase
     * @param character  input to compare
     * @return true if character is [a-z], false otherwise
     */
    private boolean isValidChar(Character character) {
        return 97<= (int)character && (int)character <= 122;
    }

}
