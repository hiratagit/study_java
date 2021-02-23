package model;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

public class GetAllReservationLogic {

	public List<Reservation> execute() {

		List<Reservation> reservationAccountList = new ArrayList<>();

		ProductDAO dao = new ProductDAO();
		reservationAccountList = dao.getAllReservation();

		return reservationAccountList;
	}
}