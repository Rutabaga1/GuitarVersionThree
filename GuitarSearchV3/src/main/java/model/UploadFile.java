package main.java.model;

import javax.servlet.http.Part;

public class UploadFile {
	public String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return filename;
    }
	
}
