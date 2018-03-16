package by.htp.hw.nb.main;

import by.htp.hw.nb.controller.Controller;

/**
 * Юзер должен знать свой id
 *
 * CREATE_NOTE    -  CREATE_NOTE    | idUser=.. | text=..  (метод сам создаст файл с путём "idUser_notes")
 * FIND_NOTE      -  FIND_NOTE      | idUser=.. | text=..
 * REMOVE_NOTE    -  REMOVE_NOTE    | idUser=.. | idNote=..
 * EDIT_NOTE      -  EDIT_NOTE      | idUser=.. | idNote=..   | newText=..
 * SHOW_ALL_NOTES -  SHOW_ALL_NOTES | idUser=..
 *
 * LOGIN_USER     -  LOGIN_USER     | idUser=.. | login=..    | password=..
 * LOGOUT_USER    -  LOGOUT_USER    | idUser=.. | login=..    | password=..
 * DELETE_USER    -  DELETE_USER    | idUser=.. | login=..    | password=..
 * ADD_USER       -  ADD_USER       | idUser=.. | login=..    | password=..    | name=..    | surname=..
 * EDIT_USER      -  EDIT_USER      | idUser=.. | newLogin=.. | newPassword=.. | newName=.. | newSurname=..
 * SHOW_ALL_USERS -  SHOW_ALL_NOTES
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(new Controller().doAction(
                "ADD_USER | idUser=1 | login=Pickle | password=7788 | name=Pavel | surname=Dav"));
    }
}


