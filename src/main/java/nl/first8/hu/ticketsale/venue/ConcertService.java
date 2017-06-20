package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcertService {

    public ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public List<ConcertDto> searchConcert(String searchParam){
        List<ConcertDto> result = new ArrayList<>();
        result.addAll(concertRepository.findByArtistName(searchParam));
        result.addAll(concertRepository.findByArtistGenre(searchParam));
        result.addAll(concertRepository.findByLocation(searchParam));
        result.addAll(concertRepository.findByMinimumDate(searchParam));
        return result;
    }
}
