package util.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilePathValidator {
    private static final String FILE_PATH_Pattern = "([a-zA-Z]:(\\\\w+)*\\\\[a-zA-Z0_9]+)?.html";

    public static boolean isValid(String checkedURL){
        Pattern pattern = Pattern.compile(FILE_PATH_Pattern);
        Matcher matcher = pattern.matcher(checkedURL);
        return matcher.matches();
    }
}
