package br.com.connplace;

import org.springframework.beans.factory.annotation.Autowired;
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
}
