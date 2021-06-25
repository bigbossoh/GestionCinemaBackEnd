package org.bzdata.dao;

import org.bzdata.entities.ProjectionFilms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin("*")
public interface ProjectionFilmsRepository  extends JpaRepository<ProjectionFilms,Long>{

}
