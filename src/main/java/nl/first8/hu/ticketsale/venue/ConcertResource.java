package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/concerts")
@Transactional
public class ConcertResource {

    private final ConcertService service;

    @Autowired
    public ConcertResource(ConcertService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ConcertDto>> searchConcert(@RequestParam("searchParam") final String searchParam) {
        try {
            List<ConcertDto> concerts = service.searchConcert(searchParam);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
