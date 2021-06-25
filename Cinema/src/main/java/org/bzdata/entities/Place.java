
  package org.bzdata.entities;
  
  import java.io.Serializable; import java.util.Collection;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.persistence.ManyToOne; import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor; import lombok.Data; import
  lombok.NoArgsConstructor; import lombok.ToString;
  
  @Data @AllArgsConstructor @NoArgsConstructor @ToString
  
  @Entity public class Place implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long idPlace;
  private int numeroPlace; 
  private double longitude,latidude,altitude;
  @JsonProperty(access = Access.WRITE_ONLY)
  @ManyToOne private Salle salle;
  @OneToMany(mappedBy = "place") 
  @JsonProperty(access = Access.WRITE_ONLY)
  private Collection<Ticket> tickets;
  
  }
 