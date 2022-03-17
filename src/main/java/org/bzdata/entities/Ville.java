
  package org.bzdata.entities;
  
  import java.io.Serializable; import java.util.Collection;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.persistence.OneToMany;
  
  import lombok.AllArgsConstructor; import lombok.Data; import
  lombok.NoArgsConstructor; import lombok.ToString;
  
  @Data @AllArgsConstructor @NoArgsConstructor @ToString
  
  @Entity 
  public class Ville implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long idVille;
  private String nomVille; 
  private double longitude,latidude,altitude;
 
 @OneToMany(mappedBy = "ville") 
  private Collection<Cinema> cinemas;
  }
 