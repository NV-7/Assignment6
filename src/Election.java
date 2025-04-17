import java.util.*;

public class Election {

    private PriorityQueue<Candidate> maxHeap;
    private HashMap<String, Candidate> nameToCandidate;
    private LinkedList<String> candidates;

    public void initializeCandidates(LinkedList<String> candidates){
        maxHeap = new PriorityQueue<>();
        nameToCandidate = new HashMap<>();
        this.candidates = new LinkedList<>(candidates);

        for(String candidateName: candidates){
            Candidate candidate = new Candidate(candidateName);
            nameToCandidate.put(candidateName, candidate);
            maxHeap.add(candidate);
        }
    }

    public void castVote(String candidate){

        if(nameToCandidate.get(candidate) == null ){
            System.out.println("Candidate " + candidate + " Does not Exist");

        }else {
            Candidate can = nameToCandidate.get(candidate);
            can.addVote();
            maxHeap.remove(nameToCandidate.get(candidate));
            maxHeap.offer(can);
        }

    }


    public void castRandomVote(){
        Random ranGen = new Random();
        String ranCandidate = candidates.get(ranGen.nextInt(candidates.size()));
        castVote(ranCandidate);
    }

    public void rigElection(String candidate, int numOfVotes){

        if(nameToCandidate.get(candidate) == null ){
            System.out.println("Candidate " + candidate + " Does not Exist");

        }else {
            int riggedVotes = numOfVotes/2 + 1;
            int diff = numOfVotes - riggedVotes;
            while(riggedVotes != 0){
                castVote(candidate);
                riggedVotes--;
            }
            while(diff != 0){
                castRandomVote();
                diff--;
            }
        }
    }

    public String[] getTopKCandidates(int k) {

        PriorityQueue<Candidate> temp = new PriorityQueue<>(maxHeap);
        String[] res = new String[k];
        int i = 0;

        while (k > 0) {
            res[i] = temp.poll().getCandidateName();
            i++;
            k--;
        }
        return res;
    }

    public void auditElection(){
        PriorityQueue<Candidate> temp = new PriorityQueue<>(maxHeap);
        int size = candidates.size();
        int votes;
        Candidate currCandidate;
        String name;
        int i = 0;
        while(i < size){
            currCandidate = temp.poll();
            name = currCandidate.getCandidateName();
            votes = currCandidate.getVotes();
            System.out.println(name + " - " + votes);
            i++;
        }


    }
}
