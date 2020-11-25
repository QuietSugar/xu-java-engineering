package name.xu.demo;

import name.xu.jline.OptionSelector;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Created by Xu
 */
@ShellComponent()
public class Hello {
    @ShellMethod("Prints what has been entered.")
    public String echo(String what) {
        return "You said " + what;
    }


    @ShellMethod("下拉列表")
    public void showSelect() throws IOException {
        TerminalBuilder builder = TerminalBuilder.builder();
        Terminal terminal = builder.build();
        OptionSelector selector = new OptionSelector(terminal, "Select number>"
                , Arrays.asList("one", "two", "three", "four", "5", "6"));
        String selected = selector.select();
        System.out.println("You selected number " + selected);
    }

}

