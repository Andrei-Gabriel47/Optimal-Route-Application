package com.EduMove.project.Traseu;

import com.EduMove.project.Rezervari.RezervareService;
import com.EduMove.project.Statii.StatieModel;
import com.EduMove.project.Statii.StatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/traseu")
public class TraseuController {

    private final StatieRepository statieRepository;
    private final TraseuService traseuService;

    @Autowired
    public TraseuController(StatieRepository statieRepository, TraseuService traseuService) {
        this.statieRepository = statieRepository;
        this.traseuService = traseuService;
    }

    @GetMapping("/traseu-optimal/{dataRezervare}")
    public ResponseEntity<?> getTraseuOptimal(@PathVariable("dataRezervare") String dataRezervare) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date data = sdf.parse(dataRezervare);

            List<StatieModel> statii = statieRepository.findStationsForReservationsOnDate(data);

            if (statii.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nu există stații pentru această dată.");
            }

            double[][] distanceMatrix = traseuService.buildDistanceMatrix(statii);

            TraseuOptim traseuOptim = new TraseuOptim(distanceMatrix);
            List<Integer> optimalPath = traseuOptim.findOptimalPath();
            double minDistance = traseuOptim.getMinDistance();

            List<StatieModel> traseuStatii = new ArrayList<>();
            for (int index : optimalPath) {
                traseuStatii.add(statii.get(index));
            }

            return ResponseEntity.ok(new TraseuService.TraseuResponse(traseuStatii, minDistance));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
