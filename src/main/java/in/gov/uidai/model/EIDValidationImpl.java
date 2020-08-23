package in.gov.uidai.model;

import java.sql.*;

public abstract class EIDValidationImpl implements EIDValidation {

    public boolean IsFirstHalfValid(String EID_FirstHalf) throws SQLException, ClassNotFoundException {
        String URL = System.getProperty("JDBC_URL");
        String Username = System.getProperty("SQL_username");
        String Password = System.getProperty("SQL_password");

        String EA_code = EID_FirstHalf.substring(0,4);
        String Station_code = EID_FirstHalf.substring(4,9);

        final String queryCheck = "SELECT count(*) from first_validation WHERE ea_code = ? and station_code = ?";

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(URL,Username,Password);

        final PreparedStatement ps = conn.prepareStatement(queryCheck);
        ps.setString(1, EA_code);
        ps.setString(2, Station_code);


        final ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()) {
            final int count = resultSet.getInt(1);
            if(count>=1) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }

}
