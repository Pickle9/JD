package by.htp.hw.nb.controller;


import by.htp.hw.nb.controller.impl.CreateNoteImpl;
import by.htp.hw.nb.controller.impl.EditNoteImpl;
import by.htp.hw.nb.controller.impl.FindNoteImpl;
import by.htp.hw.nb.controller.impl.LoginUserImpl;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

    public CommandProvider() {
        commands.put(CommandName.CREATE_NOTE, new CreateNoteImpl());
        commands.put(CommandName.EDIT_NOTE, new EditNoteImpl());
        commands.put(CommandName.LOGIN_USER, new LoginUserImpl());
        commands.put(CommandName.FIND_NOTE, new FindNoteImpl());
    }

    public Command getCommand(String commandName) {
        CommandName commandNameEnum = CommandName.valueOf(commandName.toUpperCase());

        Command command = commands.get(commandNameEnum);//LOGIN_USER
        return command;
    }

}
