package org.colorterminal;

import org.colorterminal.commands.TerminalColorCommands;

import java.util.List;
import java.util.Scanner;

public class TerminalColor {
    private final boolean interactive;
    private List<String> lines = null;

    public TerminalColor() {
        this.interactive = true;
    }

    public TerminalColor(List<String> batch) {
        this.interactive = false;
        this.lines = batch;
    }

    private void runCommand(String line) {
        line = line.trim();
        if (line.isEmpty()) {
            return;
        }
        var cmd = line.charAt(0);
        var arg = line.substring(1).trim().toLowerCase();

        switch (cmd) {
            case 'C':
                TerminalColorCommands.doChangeForegroundColor(arg);
                break;
            case 'B':
                TerminalColorCommands.doChangeBackgroundColor(arg);
                break;
            case 'W':
                TerminalColorCommands.doWrite(arg);
                if (interactive) {
                    TerminalColorCommands.doNewLine();
                }
                break;
            case 'R':
                TerminalColorCommands.doReset();
                break;
            case 'N':
                TerminalColorCommands.doNewLine();
                break;
            default:
                System.out.println("Unknown command '" + cmd + "'");
        }
    }

    public void run() {
        if (interactive) {
            try (var keyboard = new Scanner(System.in)) {
                while (keyboard.hasNext()) {
                    runCommand(keyboard.nextLine());
                }
            }
        } else {
            for (var line : lines) {
                runCommand(line);
            }
        }
    }
}
