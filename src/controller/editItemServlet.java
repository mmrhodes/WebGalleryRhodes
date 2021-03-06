package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryItem;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GalleryItemHelper dao = new GalleryItemHelper();
		
		String title = request.getParameter("title");
		String artistName = request.getParameter("artistName");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		double value = Double.parseDouble(request.getParameter("value"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		GalleryItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setTitle(title);
		itemToUpdate.setArtistName(artistName);
		itemToUpdate.setMedia(media);
		itemToUpdate.setYear(year);
		itemToUpdate.setValue(value);
		
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
