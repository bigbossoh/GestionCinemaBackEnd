package org.bzdata.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.bzdata.dao.FilmRepository;
import org.bzdata.dao.TicketRepository;
import org.bzdata.entities.Film;
import org.bzdata.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@Transactional
@CrossOrigin("*")
public class CinemaRestController {
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping("/listFilms")
	 public List<Film> listFilms(){
		 return filmRepository.findAll();
	 }
	@GetMapping(path="/imageFilm/{idFilm}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] images(@PathVariable(name="idFilm") Long idFilm) throws Exception {
		Film f=filmRepository.findById(idFilm).get();
		String photoFilm=f.getPhoto();
		File file=new File(System.getProperty("user.home")+"/Cinema/images/"+photoFilm);
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
	@PostMapping("/payerTicket")
	@Transactional
	public List<Ticket> payerTicket(@RequestBody TicketForm ticketform ){
		
		List<Ticket> listTickets=new ArrayList<>();
		ticketform.getTickets().forEach(t->{
			System.out.println(t);
			Ticket tick= ticketRepository.findById(t).get();
			tick.setNomClient(ticketform.getNomClient());
			tick.setReserve(true);
			tick.setCodePayment(ticketform.getCodepayment());
			ticketRepository.save(tick);
			listTickets.add(tick);
		});
		return listTickets;
		
	}
	
}
@Data
class TicketForm {
	private String nomClient;
	private int codepayment;
	private List<Long> tickets=new ArrayList<>();
}
