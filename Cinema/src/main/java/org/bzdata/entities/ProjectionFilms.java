
  package org.bzdata.entities;
  
  import java.io.Serializable; import java.util.Collection; import
  java.util.Date;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.persistence.ManyToOne; import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor; import lombok.Data; import
  lombok.NoArgsConstructor; import lombok.ToString;
  
  @Data 
  @AllArgsConstructor @NoArgsConstructor @ToString
  
  @Entity public class ProjectionFilms implements Serializable{
  
  

private static final long serialVersionUID = 1L;
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long idProjectionFilm; 
  private Date dateSorie; 
  private double PrixSeance;
  @JsonProperty(access = Access.WRITE_ONLY)
  @ManyToOne private Salle salle;
  
  @ManyToOne private Film film;
  @JsonProperty(access = Access.WRITE_ONLY)
  @OneToMany(mappedBy = "projectionFims") private Collection<Ticket> tickets;
  
  @ManyToOne private Seance seance; }
 