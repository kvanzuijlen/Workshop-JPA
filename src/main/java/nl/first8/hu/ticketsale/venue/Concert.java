package nl.first8.hu.ticketsale.venue;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.artist.Artist;
import nl.first8.hu.ticketsale.artist.Genre;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concert implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date concertDate;

    public Concert(Long id, String locationName, String artistName, Genre genre, Date concertDate){
        this.id = id;
        Location location = new Location();
        location.setName(locationName);
        this.location = location;
        Artist artist = new Artist();
        artist.setGenre(genre);
        artist.setName(artistName);
        this.artist = artist;
    }
}
