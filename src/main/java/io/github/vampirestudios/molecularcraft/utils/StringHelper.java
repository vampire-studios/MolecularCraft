package io.github.vampirestudios.molecularcraft.utils;

public class StringHelper {

    public static String subscriptNumbers(String string)
    {
        return string.replace('0', '\u2080')
                .replace('1', '\u2081')
                .replace('2', '\u2082')
                .replace('3', '\u2083')
                .replace('4', '\u2084')
                .replace('5', '\u2085')
                .replace('6', '\u2086')
                .replace('7', '\u2087')
                .replace('8', '\u2088')
                .replace('9', '\u2089');
    }

    public static String exponantNumbers(String string) {
        return string
                .replace('0', '⁰')
                .replace('1', '¹')
                .replace('2', '²')
                .replace('3', '³')
                .replace('4', '⁴')
                .replace('5', '⁵')
                .replace('6', '⁶')
                .replace('7', '⁷')
                .replace('8', '⁸')
                .replace('9', '⁹');
    }
}
