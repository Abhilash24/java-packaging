package in.gov.uidai.model;

import java.sql.SQLException;

public interface EIDValidation {

    boolean IsFirstHalfValid(String EID_FirstHalf) throws SQLException, ClassNotFoundException;
    boolean IsSecondHalfValid(String EID_SecondHalf);

}
