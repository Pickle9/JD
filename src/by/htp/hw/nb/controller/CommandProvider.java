package by.htp.hw.nb.controller;


import by.htp.hw.nb.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

    public CommandProvider() {
        commands.put(CommandName.CREATE_NOTE, new CreateNoteImpl());
        commands.put(CommandName.EDIT_NOTE, new EditNoteImpl());
        commands.put(CommandName.FIND_NOTE, new FindNoteImpl());
        commands.put(CommandName.REMOVE_NOTE, new RemoveNoteImpl());
        commands.put(CommandName.SHOW_ALL_NOTES, new ShowAllNotes());
        commands.put(CommandName.ADD_USER, new AddUserImpl());
        commands.put(CommandName.DELETE_USER, new DeleteUserImpl());
        commands.put(CommandName.LOGOUT_USER, new LogoutUserImpl());
        commands.put(CommandName.LOGIN_USER, new LoginUserImpl());
        commands.put(CommandName.EDIT_USER, new EditUserImpl());
        commands.put(CommandName.SHOW_ALL_USERS, new ShowAllUsers());
    }

    public Command getCommand(String commandName) {
        CommandName commandNameEnum = CommandName.valueOf(commandName.toUpperCase());

        Command command = commands.get(commandNameEnum);
        return command;
    }

}