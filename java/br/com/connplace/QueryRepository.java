package br.com.connplace;

public class QueryRepository {

    private static final String newUser =
            "INSERT INTO ccp_user(user_name," +
                    "user_password," +
                    "user_age," +
                    "user_dateofbirth," +
                    "user_sex)" +
                    "VALUES(?,?,?,?,?)";

    private static final String authenticateUser =
            "SELECT user_id AS id," +
                    "user_name AS name," +
                    "user_password AS password," +
                    "user_age AS age," +
                    "user_dateofbirth AS dateOfBirth," +
                    "user_sex AS sex" +
                    " FROM ccp_user WHERE user_name = ?" +
                    " AND user_password = ?";

    public static String getNewUser(){ return QueryRepository.newUser; }

    public static String getAuthenticateUser(){ return QueryRepository.authenticateUser; }
}
