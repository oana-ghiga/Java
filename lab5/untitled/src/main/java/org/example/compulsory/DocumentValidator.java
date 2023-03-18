package org.example.compulsory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentValidator {
    public static boolean validateDocument(Document document) {
        String location = document.getLocation();
        String regex = "^(http|https)://.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(location);
        return matcher.matches();
    }
    public static boolean isValidPathOrUrl(String pathOrUrl) {
        Pattern pattern = Pattern.compile("^(https?|ftp|file)://.*|.*\\.\\w{2,}$");
        Matcher matcher = pattern.matcher(pathOrUrl);
        return matcher.matches();
    }
}