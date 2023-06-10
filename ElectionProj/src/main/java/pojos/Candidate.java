package pojos;

public class Candidate {
	private int candidateid;
	private String name;
	private String partyname;
	private int votes;
	
	

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(int candidateid, String name, String partyname, int votes) {
		super();
		this.candidateid = candidateid;
		this.name = name;
		this.partyname = partyname;
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Candidate [candidateid=" + candidateid + ", name=" + name + ", partyname=" + partyname + ", votes="
				+ votes + "]";
	}
	public int getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	
	
	

}
