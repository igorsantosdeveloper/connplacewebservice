package br.com.connplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean newUser(User user){

        try {

            jdbcTemplate.update(QueryRepository.getNewUser(),
                    user.getName(),
                    user.getPassword(),
                    user.getAge(),
                    user.getDateOfBirth(),
                    user.getSex());
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
        return true;
    }

    public User authenticateUser(String nameUser, String passwordUser){

        try {

            return jdbcTemplate.queryForObject(QueryRepository.getAuthenticateUser(),
                    new BeanPropertyRowMapper<User>(User.class), nameUser, passwordUser);
        }catch(Exception e){

            return new User(-1,"","",0,"","");
        }
    }

    public User checkNameUser(String nameUser){

        try {

            return jdbcTemplate.queryForObject(QueryRepository.getCheckNameUser(),
                    new BeanPropertyRowMapper<User>(User.class), nameUser);
        }catch(Exception e){

            return new User(-1,"","",0,"","");
        }
    }
}
