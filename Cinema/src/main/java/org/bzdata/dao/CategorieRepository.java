package org.bzdata.dao;

import org.bzdata.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")

public interface CategorieRepository  extends JpaRepository<Categorie,Long>{
@RestResource(path="/listeCatalogues")
    public List<Categorie> findByNomCategorieContaining(@Param("mc")  String mc);
}
