
  package org.bzdata.entities;
  
  import java.io.Serializable; import java.util.Date;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor; import lombok.Data; import
  lombok.NoArgsConstructor; import lombok.ToString;
  
  @Data @AllArgsConstructor @NoArgsConstructor @ToString
  
  @Entity public class Seance implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSeance; 
  @Temporal(TemporalType.TIME)
  private Date heureDebut;
  
  
  }
 