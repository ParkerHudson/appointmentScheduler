package COP3703_TeamProject_V1.src.project.models;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class appointment {

  public String apptNum, roomNum, patientSSN, doctorID, confirmedPSSN; //confirmedPSSN is the foreign key
  public Date apptDate;

  public appointment() {}

  public appointment(
    String apptNum,
    String roomNum,
    String patientSSN,
    String doctorID,
    String confirmedPSSN,
    Date apptDate
  ) {
    this.apptNum = apptNum;
    this.roomNum = roomNum;
    this.patientSSN = patientSSN;
    this.doctorID = doctorID;
    this.confirmedPSSN = confirmedPSSN;
    this.apptDate = apptDate;
  }
}
