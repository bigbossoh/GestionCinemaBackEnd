package org.bzdata.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.bzdata.dao.CategorieRepository;
import org.bzdata.dao.CinemaRepository;
import org.bzdata.dao.FilmRepository;
import org.bzdata.dao.PlaceRepository;
import org.bzdata.dao.ProjectionFilmsRepository;
import org.bzdata.dao.SalleRepository;
import org.bzdata.dao.SeanceRepository;
import org.bzdata.dao.TicketRepository;
import org.bzdata.dao.VilleRepository;
import org.bzdata.entities.Categorie;
import org.bzdata.entities.Cinema;
import org.bzdata.entities.Film;
import org.bzdata.entities.Place;
import org.bzdata.entities.ProjectionFilms;
import org.bzdata.entities.Salle;
import org.bzdata.entities.Seance;
import org.bzdata.entities.Ticket;
import org.bzdata.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CinemaInitServiceImpl implements IcinemaInitService{
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private ProjectionFilmsRepository projectionFilmRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private FilmRepository filmRepository;
	DateFormat dateFormatJour=new SimpleDateFormat("yyyy-MM-dd");
	public void initVille() {
		Stream.of("Yopougon","Cocody","Plateau","Bouaké").forEach(v->{
			Ville ville=new Ville();
			ville.setNomVille(v);
			villeRepository.save(ville);
			
		});
		
	}

	@Override
	public void initCinema() {
		villeRepository.findAll().forEach(ville->{
			Stream.of("Studio","Prima","Carrefour","Majestic").forEach(c->{
				Cinema cinema=new Cinema();
				cinema.setNomCinema(c);
				cinema.setVille(ville);
				cinema.setNombreSalle(3+(int)(Math.random()*7));
				cinemaRepository.save(cinema);
			});
		});
		
	}

	@Override
	public void initSalle() {
		cinemaRepository.findAll().forEach(cinema->{
			for(int i=0;i<cinema.getNombreSalle();i++) {
				Salle salle=new Salle();
				salle.setCinema(cinema);
				salle.setNomSalle("salle "+(i+1));
				salle.setNombrePlace(15+(int)(Math.random()*20));
				salleRepository.save(salle);
				
				
			}
		});
		
	}

	public void initPlace() {
		salleRepository.findAll().forEach(salle->{
			for(int i=0;i<salle.getNombrePlace();i++) {
				Place place=new Place();
				place.setSalle(salle);
				place.setNumeroPlace(i+1);
				placeRepository.save(place);
			}
		});
		
	}

	@Override
	public void initSeance() {
		DateFormat dateforma=new SimpleDateFormat("HH:MM");
		Stream.of("14:00","16:00","18:00","20:00","22:00").forEach(s->{
			Seance seance=new Seance();
			try {
				seance.setHeureDebut(dateforma.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		});
		
	}

	@Override
	public void initCategories() {
		Stream.of("Action","Fiction","Drame","Comedie","Humour").forEach(c->{
			Categorie categorie=new Categorie();
			categorie.setNomCategorie(c);
			categorieRepository.save(categorie);
		});
		
	}

	@Override
	public void initFilms() {
			double[] durees=new double[] {1.5,2,2.5,2,3};
			List<Categorie> categorie=categorieRepository.findAll();
			Stream.of("Game of Throne","Ligne Verte","Titanic","Power","Dr House","Ma famille","Tintin")
			.forEach(titreFilm->{
				Film film=new Film();
				film.setNomFilm(titreFilm);
				film.setDuree(durees[new Random().nextInt(durees.length)]);
				film.setPhoto(titreFilm.replaceAll(" ","")+".JPG");
				film.setCategorieFilms(categorie.get(new Random().nextInt(categorie.size())));
				try {
					film.setDateSortie(dateFormatJour.parse("2020-12-"+( 1+(int)(Math.random()*5))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				filmRepository.save(film);
				
			});
		 
		
		
	}

	@Override
	public void initProjection() {
		double[] prixFilm=new double[] {2000,5000,7000,3000,1500,10000};
		List<Film> films=filmRepository.findAll();
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalle().forEach(salle->{
					//filmRepository.findAll().forEach(film->{
					int index=new Random().nextInt(films.size());
					Film film=films.get(index);
						seanceRepository.findAll().forEach(seance->{
							ProjectionFilms projectionfilm=new ProjectionFilms();
							projectionfilm.setPrixSeance(prixFilm[new Random().nextInt(prixFilm.length)]);
							projectionfilm.setFilm(film);
							projectionfilm.setSalle(salle);
							projectionfilm.setSeance(seance);
							projectionfilm.setDateSorie(new Date());
							projectionFilmRepository.save(projectionfilm);
						});
					//});
				});
			});
		});
	}

	@Override
	public void initTicket() {
		projectionFilmRepository.findAll().forEach(projectionFilm->{
			projectionFilm.getSalle().getPlace().forEach(place->{
				Ticket ticket =new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(projectionFilm.getPrixSeance());
				ticket.setReserve(false);
				ticket.setProjectionFims(projectionFilm);
				ticketRepository.save(ticket);
			});
		});
		
	}

}
