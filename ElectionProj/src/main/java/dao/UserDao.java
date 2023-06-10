package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method for user authentication(login)
	String Insertuser(String email,String pass,String fname,String lname,Date dob1) throws SQLException;
	User authenticateUser(String email, String password) throws SQLException;
	public String updateVotingStatus(int voterId) throws SQLException;
}