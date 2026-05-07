package com.milcolores.system_pos.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class TextFormatter {

    private static final Pattern DIACRITICS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static String formatName(String input) {
        if (input == null || input.isBlank())
            return input;
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        String cleanString = DIACRITICS_PATTERN.matcher(normalized).replaceAll("");

        String[] words = cleanString.toLowerCase().trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isBlank()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String cleanIdentifier (String input) {
        return (input == null) ? null : input.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String cleanUsername(String input) {
        return (input == null) ? null : input.toLowerCase().trim();
    }

}
