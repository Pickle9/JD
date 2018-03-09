package by.htp.hw.nb.main;

import by.htp.hw.nb.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();

		String response = null;

		response = controller.doAction("CREATE_NOTE | newContent=vfvf vskf hfve | year=1234 | month=4 | day=2");

		if(response.equals("OK")){
			System.out.println("Vse xorosho");
		}else{
			System.out.println(response.split("|")[1]);
		}


		response = controller.doAction("CREATE_NOTE | newContent=vfvf vskf hfve111 | year=1234 | month=4 | day=2");

		if(response.equals("OK")){
			System.out.println("Vse xorosho");
		}else{
			System.out.println(response.split("|")[1]);
		}

		response = controller.doAction("EDIT_NOTE | id=12 | text=asasaas | year=4321");

		//......

	}

}



//Controller controller = new Controller();
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
//String response = controller.doAction("LOGIN_USER   ....");
*/