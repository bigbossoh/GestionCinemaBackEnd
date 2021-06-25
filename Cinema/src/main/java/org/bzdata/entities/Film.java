
  package org.bzdata.entities;
  
  import java.io.Serializable; import javax.persistence.Entity; import
  java.util.Collection; import java.util.Date;
  
   import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.persistence.ManyToOne; import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor; import lombok.Data; import
  lombok.NoArgsConstructor; import lombok.ToString;
  @Data @AllArgsConstructor @NoArgsConstructor @ToString
  
  @Entity public class Film implements Serializable {
  
  
  private static final long serialVersionUID = 1L;
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private long idFilm;
  private String nomFilm; 
  private double duree; 
  private String realisateur;
  private String description; 
  private Date dateSortie; 
  private String photo;
  
	
	  @OneToMany(mappedBy = "film") private
	  @JsonProperty(access = Access.WRITE_ONLY)
	  Collection<ProjectionFilms>projectionFilm;
	 
  
  @ManyToOne 
 
  private Categorie categorieFilms;
  
  }
 