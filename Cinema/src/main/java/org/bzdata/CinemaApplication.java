package org.bzdata;

import org.bzdata.entities.Film;
import org.bzdata.entities.Salle;
import org.bzdata.entities.Ticket;
import org.bzdata.service.IcinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {
@Autowired
	private IcinemaInitService icinemaInitService;
@Autowired
	private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class);
		icinemaInitService.initVille();
		icinemaInitService.initCinema();
		icinemaInitService.initSalle();
		icinemaInitService.initPlace();
		icinemaInitService.initSeance();
		icinemaInitService.initCategories();
		icinemaInitService.initFilms();
		icinemaInitService.initProjection();
		icinemaInitService.initTicket();
	}

}
