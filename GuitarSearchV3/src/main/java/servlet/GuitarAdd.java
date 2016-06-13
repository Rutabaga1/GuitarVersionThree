package main.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import main.java.model.Builder;
import main.java.model.UploadFile;
import main.java.model.Guitar;
import main.java.model.GuitarSpec;
import main.java.model.Type;
import main.java.service.SearchService;

/**
 * Servlet implementation class GuitarAdd
 */
@MultipartConfig(location="c:/JavaWork/GuitarSearchV3/WebContent/images")
@WebServlet("/GuitarAdd")
public class GuitarAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuitarAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Part picture = request.getPart("picture");
		UploadFile getfilename=new UploadFile();
        String filename = getfilename.getFilename(picture);
        picture.write(filename);
        
        String builder=request.getParameter("builder");
		String numStrings=request.getParameter("numStrings");
		String color=request.getParameter("color");
		String type=request.getParameter("type");
		//String serialNumber=request.getParameter("serialNumber");
		String inventoryNum=request.getParameter("inventoryNum");
		String price=request.getParameter("price");
		GuitarSpec newGuitarSpec =new GuitarSpec(Builder.fromString(builder),color,
				Type.fromString(type),numStrings);

		filename=filename.substring(filename.length()-14, filename.length()-4);//去掉文件拓展名
		Guitar newGuitar=new Guitar(filename,Double.valueOf(price),newGuitarSpec);
		
		SearchService userService = new SearchService();
		userService.addNewGuitars(newGuitar, inventoryNum);
		
		//response.sendRedirect("index.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
