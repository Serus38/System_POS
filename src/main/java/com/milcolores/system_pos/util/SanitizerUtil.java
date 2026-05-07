package com.milcolores.system_pos.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class SanitizerUtil {

    private static final Pattern DIACRITICS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static String capitalizeName(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }

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

    public static String normalizeEmail(String input) {
        if (input == null) {
            return null;
        }
        return input.toLowerCase().trim();
    }

    public static String digitsOnly(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("[^0-9]", "");
    }

    public static String cleanUsername(String input) {
        if (input == null) {
            return null;
        }
        return input.toLowerCase().trim();
    }
}
