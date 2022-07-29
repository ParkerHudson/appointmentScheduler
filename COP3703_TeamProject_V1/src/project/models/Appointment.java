package project.models;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Appointment {

  public String apptNum, roomNum, patientSSN, doctorID, apptTime; //confirmedPSSN is the foreign key
  public String apptDate;

  public Appointment() {}

  public Appointment(
    String apptNum,
    String roomNum,
    String apptDate,
    String doctorID,
    String patientSSN,       
    String apptTime
  ) {
    this.apptNum = apptNum;
    this.roomNum = roomNum;
    this.patientSSN = patientSSN;
    this.doctorID = doctorID;
    this.apptDate = apptDate;
    this.apptTime = apptTime;
  }
}
