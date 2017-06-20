package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.first8.hu.ticketsale.artist.Genre;

import java.util.Date;

@Data
@AllArgsConstructor
public class ConcertDto {
    private long id;
    private String locationName;
    private String artistName;
    private Genre artistGenre;
    private Date concertDate;
}
