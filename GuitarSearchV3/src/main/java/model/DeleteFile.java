package main.java.model;

import java.io.File;

public class DeleteFile {
		  
		 public void deleteFile(String deletefile) {
			 File file=new File("c:/JavaWork/GuitarSearchV3/WebContent/images");
		        File Array[] = file.listFiles(); 
		        for (File f : Array) { 
		            if (f.isFile()) {// ������ļ� 
		                if (f.getName().equals(deletefile+".jpg")) { 
		                    f.delete();
		                } 
		            } 
		        }
		    }
		  
}
