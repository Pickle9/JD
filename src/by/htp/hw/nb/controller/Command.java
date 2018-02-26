package by.htp.hw.nb.controller;

import java.io.IOException;

public interface Command {

    Responses execute(String[] params) throws IOException;
}
