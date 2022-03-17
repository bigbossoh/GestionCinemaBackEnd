package org.bzdata.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.bzdata.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface FilmRepository  extends JpaRepository<Film,Long>{
    DateFormat dateFormatJour=new SimpleDateFormat("MM-dd");
    @RestResource(path ="/birthday")

    public List<Film>findFilmByDateSortieContaining(@Param("mc") @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="MM-dd") Date mc);

}
