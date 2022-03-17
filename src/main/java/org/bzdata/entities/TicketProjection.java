package org.bzdata.entities;


import org.springframework.data.rest.core.config.Projection;



@Projection(name="t1",types = {org.bzdata.entities.Ticket.class})
public interface TicketProjection {
    public Long getIdTicket();
    public String getNomClient();
    public double getPrix();
    public Integer getCodePayment();
    public boolean getReserve();
    public Place getPlace();


}
