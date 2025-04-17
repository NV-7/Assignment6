public class Candidate implements Comparable<Candidate>{

    private String candidateName;
    private int votes;

    public Candidate(String candidateName){
        this.candidateName = candidateName;
        this.votes = 0;
    }

    public void addVote(){
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    public String getCandidateName() {
        return candidateName;
    }

    @Override
    public int compareTo(Candidate o) {

        if(o.getVotes() >= getVotes()){
            return 1;
        }
        else if(o.getVotes() == getVotes()){
            return 0;
        }
       else if(o.getVotes() < getVotes()) {
           return -1;
        }
       return 0;
    }
}
