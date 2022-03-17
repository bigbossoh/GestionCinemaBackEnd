
  package org.bzdata.entities;
  
  import java.io.Serializable;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.persistence.ManyToOne;



import lombok.AllArgsConstructor; import lombok.Data; import
  lombok.NoArgsConstructor; import lombok.ToString;
  
  @Data @AllArgsConstructor@NoArgsConstructor@ToString
  
  @Entity public class Ticket implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idTicket; 
  private String nomClient; 
  private double prix; 
  private Integer codePayment; 
  private boolean reserve;
  @ManyToOne
  private Place place;
  @ManyToOne
  private ProjectionFilms projectionFims;
  
  
  }
 
