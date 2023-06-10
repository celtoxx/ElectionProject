package dao;

import java.sql.*;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {
	// fields
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	public UserDaoImpl() throws SQLException {
		// open conn
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		
		
		pst2=cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("user dao created!");
		
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
	
		// set IN params
		pst1.setString(1, email);		
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()) {
			if(rst.next()) //=> success
				/*
				 * int id, String firstName, String lastName, String email, String password, Date dob,
			boolean votingStatus, String role
				 */
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, 
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}
	
	
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up!");
	}

	@Override
	public String Insertuser(String email, String pass, String fname, String lname, Date dob1) throws SQLException {
		System.out.println("in insertuser");
		pst2.setString(1, fname);
		pst2.setString(2, lname);
		pst2.setString(3, email);
		pst2.setString(4, pass);
		pst2.setDate(5, dob1);
		pst2.setInt(6,0);
		pst2.setString(7, "voter");
		
		
		int r=pst2.executeUpdate();
		System.out.println(r);
		if(r>0) {
			return "done";
		}
		else {
			return "insertion failed";
		}
		
	}

}
