# Information general on GestionCinemaBackEnd
On souhaite créer une application web et mobile qui permet de gérer des cinémas.
- Chaque cinéma se trouvant dans une ville est défini par son code, son nom et sa position géographique. 
- Le cinéma contient un ensemble de salles. 
- Chaque salle qui est définie par son numéro, son nom contient un ensemble de places. 
- Chaque place a un numéro et positionnée géographiquement. 
- Quotidiennement, on programme plusieurs projections de films dans des salles. 
- Chaque Projection se déroule dans une séance, concerne un Film et se déroule dans une Salle à un date de projection et un prix fixe. 
- Chaque séance est définie par son numéro et l’heure de début e la séance. 
- Chaque projection on prévoie un ensemble de Tickets. 
- Chaque Ticket concerne une Place et défini par le nom du client, le prix du ticket et le code payement. 
- Les films sont classés par catégories
L’application se compose de 2 Parties : La partie backend et la partie Frontend.
## Les exigences fonctionnelles de l’application sont :
1. Gestion des Cinémas 
- Consultations, 
- Saisie, 
- Ajout, 
- Edition, 
- Mise à jour et suppression)
2. Gestion des Salles et des Places
3. Gestion Films
4. Gestion Projection
5. Gestion des ventes des Tickets
6. La partie backend est basée sur Spring et se compose des couches DAO, Service et Web. 
7. La couche DAO est basée sur Spring Data, JPA, Hibernate
8. La couche Métier est définie par une interface et une implémentation quelques spécifications fonctionnelles qui nécessite des calculs ou des traitements particuliers
9. La couche Web est basée sur des API Restful basée sur Spring Data Rest ou un RestController•La partie Frontend est basée sur le Framework Angular
10. La sécurité est basée sur Spring Security et Json Web Token
