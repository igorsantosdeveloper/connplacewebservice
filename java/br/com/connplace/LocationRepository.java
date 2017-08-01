package br.com.connplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public boolean overlapLocation(Location location){

        try{

            jdbcTemplate.update(QueryRepository.getOverlapLocation(),
                    location.getLatitude(),
                    location.getLongitude(),
                    location.getUser().getId());
            return true;
        }catch (Exception e){

            return false;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Location> bringsLocations(){

        try{

            return jdbcTemplate.query(QueryRepository.getBringsLocations(),new BeanPropertyRowMapper(Location.class));
        }catch (Exception e){

            e.printStackTrace();
            return null;
        }
    }
}
