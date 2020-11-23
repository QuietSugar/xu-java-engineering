package name.xu.jline;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Created by Xu
 */
public class OptionSelectorTest {

    @Test
    public void select() throws IOException {

        TerminalBuilder builder = TerminalBuilder.builder();
        Terminal terminal = builder.build();
        OptionSelector selector = new OptionSelector(terminal, "Select number>"
                , Arrays.asList("one", "two", "three", "four", "5", "6"));
        String selected = selector.select();
        System.out.println("You selected number " + selected);

    }
}
