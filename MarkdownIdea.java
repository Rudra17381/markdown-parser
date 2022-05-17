//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MarkdownIdea {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if (openBracket == -1) {
                break;
            }
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (closeBracket == -1 || openParen == -1 || closeParen == -1) {
                currentIndex = markdown.indexOf("[", currentIndex) + 1;
                continue;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
        AcceptableDomains domains = new AcceptableDomains();
        domains.parseFileToArrayOfAcceptableDomain("acceptableDomains.txt");
    }
}

class AcceptableDomains {
    public AcceptableDomains() {}

    public void parseFileToArrayOfAcceptableDomain(String filePath) {
        System.out.println(filePath);
        File givenFile = new File("acceptableDomains.csv");
        //Scanner scnr = new Scanner(givenFile);
        /*  
        scnr.useDelimiter("\n");
        scnr.next();
        
        ArrayList<String> listOfAcceptableDomains = new ArrayList<String>();
        while (scnr.hasNext())   
        {  
            listOfAcceptableDomains.add(scnr.next());
        }   
        scnr.close();
        for (String element : listOfAcceptableDomains) {
            System.out.println(element);
        }
        */
    }
}