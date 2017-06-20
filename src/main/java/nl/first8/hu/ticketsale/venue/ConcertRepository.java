package nl.first8.hu.ticketsale.venue;

import nl.first8.hu.ticketsale.artist.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcertRepository {

    private final EntityManager entityManager;

    @Autowired
    public ConcertRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ConcertDto> findByArtistName(String searchParam){
        return entityManager.createQuery("SELECT DISTINCT new ConcertDto(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate)  FROM Concert c WHERE c.artist.name LIKE :name", ConcertDto.class)
                .setParameter("name", "%"+searchParam+"%")
                .getResultList();
    }

    public List<ConcertDto> findByArtistGenre(String searchParam){
        try {
            Genre genre = Genre.valueOf(searchParam);
            return entityManager.createQuery("SELECT DISTINCT new ConcertDto(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate) FROM Concert c WHERE c.artist.genre = :genre", ConcertDto.class)
                    .setParameter("genre",genre)
                    .getResultList();
        }catch (IllegalArgumentException ex){
            return new ArrayList<>();
        }
    }

    public List<ConcertDto> findByLocation(String searchParam){
        return entityManager.createQuery("SELECT DISTINCT new ConcertDto(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate) FROM Concert c WHERE c.location.name LIKE :name", ConcertDto.class)
                .setParameter("name", "%"+searchParam+"%")
                .getResultList();
    }

    public List<ConcertDto> findByMinimumDate(String searchParam){
        try {
            Date date = Date.valueOf(searchParam);
            return entityManager.createQuery("SELECT DISTINCT new ConcertDto(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate) FROM Concert c WHERE c.concertDate > :date", ConcertDto.class)
                    .setParameter("date",date)
                    .getResultList();
        } catch (IllegalArgumentException ex){
            return new ArrayList<>();
        }
    }

}
