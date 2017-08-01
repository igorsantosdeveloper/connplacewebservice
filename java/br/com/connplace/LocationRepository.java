package br.com.connplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean newLocation(Location location){

        try {

            jdbcTemplate.update(QueryRepository.getNewLocation(),
                    location.getLatitude(),
                    location.getLongitude(),
                    location.getUser().getId());
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }
}
