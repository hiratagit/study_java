package model;

import dao.ProductDAO;

public class SetReservationLogic {

	public boolean execute(Reservation reservation) {

		ProductDAO dao = new ProductDAO();
		return dao.setReservation(reservation);
	}
}