package org.colorterminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        TerminalColor terminalColor;

        if (args.length > 0) {
            terminalColor = new TerminalColor(Files.readAllLines(Paths.get(args[0])));
        } else {
            terminalColor = new TerminalColor();
        }

        terminalColor.run();
    }
}