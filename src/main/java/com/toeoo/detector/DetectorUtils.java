package com.toeoo.detector;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectorUtils {
    public static List<String> match(Pattern pattern, String input) {
        List<String> result = new LinkedList<>();

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            result.add(matcher.group(0));
        }

        return result;
    }

}
