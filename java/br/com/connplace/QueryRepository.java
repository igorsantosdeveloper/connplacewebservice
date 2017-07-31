package br.com.connplace;

public class QueryRepository {

    private static final String newUser =
            "INSERT INTO ccp_user(user_name," +
                    "user_password," +
                    "user_age," +
                    "user_dateofbirth," +
                    "user_sex)" +
                    "VALUES(?,?,?,?,?)";

    public static String getNewUser(){ return QueryRepository.newUser; }

}
