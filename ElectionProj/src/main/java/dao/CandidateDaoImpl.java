package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;
import pojos.Candidate;

public class CandidateDaoImpl implements Candidatedao{
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4;
	
	
	
	public CandidateDaoImpl() throws SQLException{
		cn=openConnection();
		pst1=cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3=cn.prepareStatement("select party,sum(votes) from candidates group by party limit 2");
		pst4=cn.prepareStatement("select name,votes from candidates order by votes desc limit 1");
	}

	@Override
	public List<Candidate> getAllCandidate() throws SQLException {
		List<Candidate> candidateList=new ArrayList<>();
		
		try(ResultSet rst=pst1.executeQuery();){
			while(rst.next()) {
				candidateList.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
			}
			
		}
		
		return candidateList;
	}

	@Override
	public String incrementCandidateVotes(int candidateid) throws SQLException {
		pst2.setInt(1, candidateid);
		int updateCount=pst2.executeUpdate();
		if(updateCount==1) {
			return "updated vote";
		}
		return "vote udpation failed";
	}
	
	

	public void cleanUp() throws SQLException {
	if(pst1!=null && pst2!=null) {
			pst1.close();
			pst2.close();
			closeConnection();
			
		}
		
	}
	public String[] getToptwoParties() throws SQLException {
		String[] parties=new String[3];
		int i=0;
		try(ResultSet rst=pst3.executeQuery();
				ResultSet rst2=pst4.executeQuery();){
//			System.out.println(rst2.getString(1));
			while(rst.next()) {
				parties[i]=rst.getString(1)+" Votes: "+rst.getInt(2);
				System.out.println(parties[i]);
				i++;
			
			}
			while(rst2.next()) {
				parties[i]=rst2.getString(1)+rst2.getInt(2);
				System.out.println(parties[i]);
				i++;
			}
			
			
		}
		
		return parties;
	}
	

	

	
	
	

}
