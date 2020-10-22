package util.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {

    private static final String URL_Pattern = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";

    public static boolean isValid(String checkedURL){
        Pattern pattern = Pattern.compile(URL_Pattern);
        Matcher matcher = pattern.matcher(checkedURL);
        return matcher.matches();
    }
}
