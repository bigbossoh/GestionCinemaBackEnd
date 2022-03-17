package org.bzdata.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types= {org.bzdata.entities.ProjectionFilms.class})
public interface ProjectionProj {

	public Long getIdProjectionFilm();
	public Date getDateSorie();
	public double getPrixSeance();
	public Salle getSalle() ;
	public Film getFilm() ;
	public Collection<Ticket> getTickets() ;
	public Seance getSeance() ;


}
