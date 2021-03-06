package org.bzdata.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity
public class Categorie  {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	private String nomCategorie;
	@OneToMany(mappedBy = "categorieFilms")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Film> films;
	 
	
}
