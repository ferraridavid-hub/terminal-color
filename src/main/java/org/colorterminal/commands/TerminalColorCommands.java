package org.colorterminal.commands;

import java.util.Map;

public class TerminalColorCommands {

    private static final Map<String, Integer> foregroundColors = Map.of(
            "black", 30,
            "red", 31,
            "green", 32,
            "yellow", 33,
            "blue", 34,
            "magenta", 35,
            "cyan", 36,
            "white", 37,
            "default", 39
    );

    private static final Map<String, Integer> backgroundColors = Map.of(
            "black", 40,
            "red", 41,
            "green", 42,
            "yellow", 43,
            "blue", 44,
            "magenta", 45,
            "cyan", 46,
            "white", 47,
            "default", 48
    );

    public static void doChangeForegroundColor(String color) {
        var foregroundColor = foregroundColors.get(color);
        System.out.print("\033[" + foregroundColor + "m");
    }

    public static void doChangeBackgroundColor(String color) {
        var backgroundColor = backgroundColors.get(color);
        System.out.print("\033[" + backgroundColor + "m");
    }

    public static void doReset() {
        System.out.print("\033[0m");
    }

    public static void doWrite(String msg) {
        System.out.print(msg);
    }

    public static void doNewLine() {
        System.out.println();
    }
}
