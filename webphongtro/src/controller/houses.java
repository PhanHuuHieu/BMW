package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaiDang;
import models.TaiKhoan;
@WebServlet("/houses.html")
public class houses extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public houses() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<BaiDang> houses = (List<BaiDang>) session.getAttribute("bd_temp");
		
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		for(Iterator<BaiDang> i = houses.iterator(); i.hasNext(); ) {
			BaiDang item = i.next();
			if(item.getLoaitin().equals("Cho thuê nhà nguyên căn"))
				list_bd.add(item);
		}

		session.setAttribute("action", "");
		session.setAttribute("list_bd", list_bd);
		if (session.getAttribute("tk") == null)
		{
			 request.setAttribute("tentaikhoan","");
			 request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		}
		 else{
			 TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
			 String mact = tk.getTentk();
			 request.setAttribute("tentaikhoan", mact);
			 request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		 }
	}
}
