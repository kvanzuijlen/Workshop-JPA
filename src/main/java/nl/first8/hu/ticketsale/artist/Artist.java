package nl.first8.hu.ticketsale.artist;

import lombok.Data;
import nl.first8.hu.ticketsale.venue.Concert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Artist implements Serializable {

    @Id
    @GeneratedValue
    public Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "artist")
    public List<Concert> concertList;
}
