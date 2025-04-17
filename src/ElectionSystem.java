import java.util.LinkedList;

public class ElectionSystem {

    public static void electionSim(int p){

        Election election = new Election();
        LinkedList<String> candidates = new LinkedList<>();
        candidates.add("Marcus Fenix");
        candidates.add("Dominic Santiago");
        candidates.add("Damon Baird");
        candidates.add("Cole Train");
        candidates.add("Anya Stroud");

        election.initializeCandidates(candidates);
        election.rigElection("Marcus Fenix", 5);
        election.auditElection();

    }


    public static void main(String[] args) {
        electionSim(5);
    }
}

