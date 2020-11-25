package name.xu.demo;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by Xu
 */
@ShellComponent()
public class GenericSelector {
    private final List<String> OPTIONS = new ArrayList<>(Arrays.asList("create", "update", "delete"));
    private final Terminal terminal;

    public GenericSelector(@Lazy final Terminal terminal) {
        this.terminal = terminal;
    }

    @ShellMethod("completeSelect")
    public String completeSelect() {
        LineReader lineReader = LineReaderBuilder.builder()
                .terminal(this.terminal)
                .completer(new StringsCompleter(this.OPTIONS))
                .build();
        /* Important: This allows completion on an empty buffer, rather than inserting a tab! */
        lineReader.unsetOpt(LineReader.Option.INSERT_TAB);

        String desription = "select on of this options: " + OPTIONS + "\n"
                + " use TAB (twice) to select them\n";
        String input = lineReader.readLine(desription + "input: ").trim();
        return "you selected \"" + input + "\"";
    }
}
