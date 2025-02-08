package com.EduMove.project.Traseu;

import com.EduMove.project.Algoritm.DistanceCalculator;
import com.EduMove.project.Statii.StatieModel;
import com.EduMove.project.Statii.StatieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraseuService {

    private final StatieRepository statieRepository;

    public TraseuService(StatieRepository statieRepository) {
        this.statieRepository = statieRepository;
    }

    public double[][] buildDistanceMatrix(List<StatieModel> statii) {
        int n = statii.size();
        double[][] distanceMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double lat1 = statii.get(i).getLatitudine();
                double lon1 = statii.get(i).getLongitudine();
                double lat2 = statii.get(j).getLatitudine();
                double lon2 = statii.get(j).getLongitudine();

                // Calculăm distanța folosind Haversine
                distanceMatrix[i][j] = DistanceCalculator.haversineDistance(lat1, lon1, lat2, lon2);
            }
        }

        return distanceMatrix;
    }



public static class TraseuResponse {
        private List<StatieModel> traseu;
        private double distantaTotala;

        public TraseuResponse(List<StatieModel> traseu, double distantaTotala) {
            this.traseu = traseu;
            this.distantaTotala = distantaTotala;
        }

        public List<StatieModel> getTraseu() {
            return traseu;
        }

        public void setTraseu(List<StatieModel> traseu) {
            this.traseu = traseu;
        }

        public double getDistantaTotala() {
            return distantaTotala;
        }

        public void setDistantaTotala(double distantaTotala) {
            this.distantaTotala = distantaTotala;
        }
    }

}


