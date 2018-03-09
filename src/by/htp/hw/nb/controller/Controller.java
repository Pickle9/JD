package by.htp.hw.nb.controller;

public class Controller {

    private final CommandProvider commandProvider = new CommandProvider();
    //response
    public String doAction(String request){

        String[] params = request.split("|");

        String commandName = params[0].trim();

        Command command = commandProvider.getCommand(commandName);
        String response = command.execute(params);

        return response;
    }

}

// Controller controller = new Controller();
/*
"CREATE_NOTE | newContent=vfvf vskf hfve | year=1234 | month=4 | day=2"
"OK"

"CREATE_NOTE | newContent=aaaaaaa | year=24 | month=12 | day=22"
"ERROR | message=smth wrong"

"EDIT_NOTE | id=12 | text=asasaas | year=4321"

"LOGIN_USER | login=mylogin | password=123456"
""
"OK | ID=1234 | name=Vasya"

"FIND :"
"NULL"
"OK | ID=123 | text=hdajshdja | ;"

//CREATE_NOTE - text, yaer month, day
//EDIT_NOTE,  - id  filedName=newText  fieldName=newYear
//LOGIN_USER - login, password
// String response = controller.doAction("LOGIN_USER   ....");

*/
