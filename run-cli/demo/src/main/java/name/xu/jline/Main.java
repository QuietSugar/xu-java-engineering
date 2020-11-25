package name.xu.jline;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Created by Xu
 */
public class Main {
    public static void main(String[] args) throws IOException {
        TerminalBuilder builder = TerminalBuilder.builder();
        Terminal terminal = builder.build();
        OptionSelector selector = new OptionSelector(terminal, "Select number>"
                , Arrays.asList("one", "two", "three", "four", "5", "6"));
        String selected = selector.select();
        System.out.println("You selected number " + selected);
    }
}
