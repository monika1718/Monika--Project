package com.register.marriage.love;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Userinterface {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\user\\Downloads\\downloaded photos\\komala.jpg");
		
		Bride bride =new Bride("komala",783476543007l,"engineer",file);
		Inserthelperclass.insert(bride);
        //Retrievehelperclass.retrieve();
		//Updatehelperclass.update(args);
	}

}
