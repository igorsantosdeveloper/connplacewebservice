package br.com.connplace;

public class QueryRepository {

    //User
    private static final String newUser =
            "INSERT INTO ccp_user" +
                    "(user_name," +
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

    private static final String checkNameUser =
            "SELECT user_id AS id," +
                    "user_name AS name," +
                    "user_password AS password," +
                    "user_age AS age," +
                    "user_dateofbirth AS dateOfBirth," +
                    "user_sex AS sex" +
                    " FROM ccp_user WHERE user_name = ?";
    //End User

    //Location
    private static final String newLocation =
            "INSERT INTO ccp_location" +
                    "(location_latitude," +
                    "location_longitude," +
                    "user_id)" +
                    "VALUES(?,?,?)";

    private static final String overlapLocation =
            "UPDATE ccp_location " +
                    "SET location_latitude = ?," +
                    "location_longitude = ? " +
                    "WHERE user_id = ?";

    private static final String bringsLocations =
            "SELECT location_latitude AS latitude," +
                    "location_longitude AS longitude," +
                    "user_id AS user_id " +
                    "FROM ccp_location";

    private static final String bringsCoordinates =
            "SELECT location_latitude AS latitude," +
                    "location_longitude AS longitude " +
                    "FROM ccp_location " +
                    "WHERE user_id = ?";
    //End Location

    //User
    public static String getNewUser(){ return QueryRepository.newUser; }

    public static String getAuthenticateUser(){ return QueryRepository.authenticateUser; }

    public static String getCheckNameUser(){ return QueryRepository.checkNameUser; }
    //End User

    //Location
    public static String getNewLocation(){ return QueryRepository.newLocation; }

    public static String getOverlapLocation(){ return QueryRepository.overlapLocation; }

    public static String getBringsLocations(){ return QueryRepository.bringsLocations; }

    public static String getBringsCoordinates(){ return bringsCoordinates; }
    //End Location
}
