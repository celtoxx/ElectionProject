package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface Candidatedao {
	
	List<Candidate> getAllCandidate() throws SQLException;
	
	String incrementCandidateVotes(int candidateid) throws SQLException ;
	
	

}
