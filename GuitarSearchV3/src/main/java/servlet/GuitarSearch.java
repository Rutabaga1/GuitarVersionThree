package main.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Builder;
import main.java.model.Guitar;
import main.java.model.GuitarSpec;
import main.java.model.Inventory;
import main.java.model.Type;
import main.java.service.SearchService;



/**
 * Servlet implementation class GuitarSearch
 */
@WebServlet("/GuitarSearch")
public class GuitarSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuitarSearch() {
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
		
		String search=request.getParameter("search");
		  
		SearchService userService = new SearchService();
		
		Inventory inventory = userService.getGuitars();
		List<Guitar> matchingGuitars=null;
		
		if(!search.equals("allGuitar")){  //不改GuitarSpec的结构，放在这里判断
			String builder=request.getParameter("builder");
			String numStrings=request.getParameter("numStrings");
			String color=request.getParameter("color");
			String type=request.getParameter("type");
			GuitarSpec whatIsWanted =new GuitarSpec(Builder.fromString(builder),color,
    				Type.fromString(type),numStrings);
			
			matchingGuitars = inventory.search(whatIsWanted);
			
			request.setAttribute("color",color);
			request.setAttribute("type",type);
			request.setAttribute("numStrings",numStrings);
		}else{
			matchingGuitars =inventory.getAllInventory();//显示全部库存吉他
		}
		
		String page="NotFound.jsp";
		
		if(matchingGuitars.size()!=0){
			page="GuitarSearchResult.jsp";
			request.setAttribute("matchingGuitars", matchingGuitars);
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
