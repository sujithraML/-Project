package com.aspire.travelexploration.manager;

import java.util.List;
import com.aspire.travelexploration.daoimpl.TicketDAO;
import com.aspire.travelexploration.entity.Ticket;

public class TicketManager {
	TicketDAO ticketDao=new TicketDAO();
	
	public boolean insertTicket(Ticket ticket) {
		return ticketDao.addDetails(ticket);
	}
	public List<Object> searchTicket(Ticket ticket){
		return ticketDao.selectDetails(ticket);
	}
	public boolean cancelTicket(Ticket ticket) {
		return ticketDao.cancelTicket(ticket);
	}
}
