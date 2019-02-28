package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * 購入履歴画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/UserBuyHistoryDetail")
public class UserBuyHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
		String id = request.getParameter("buy_id");

		int num = Integer.parseInt(id);
		System.out.println(num);


		ArrayList<ItemDataBeans> buyDetailItemList = BuyDetailDAO.getItemDataBeansListByBuyId(num);
			request.setAttribute("buyDetailItemList",buyDetailItemList );



			BuyDataBeans bdb = BuyDAO.getBuyDataBeansByBuyId(num);
			request.setAttribute("bdb",bdb );


			request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_DETAIL_PAGE).forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}




	}
}
