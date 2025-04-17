import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        LinkedList<String> candidates = new LinkedList<>();
        char character;
        for(int i = 0; i < 26; i++){
            character = 'Z';
            character -= i;
            maxHeap.add(character);
        }
        Election election = new Election();
        LinkedList<String> candidates1 = new LinkedList<>();

       // char character;
        for (int i = 0; i < 26; i++) {
            character = 'Z';
            character -= i;
            candidates.add(Character.toString(character));
        }

        election.initializeCandidates(candidates);
        election.rigElection("Z", 9);
        election.auditElection();

//        election.initializeCandidates(candidates);
//        election.castVote("A");
//        election.castVote("A");
//        election.castVote("A");
//        election.castVote("V");
//        election.castVote("V");
//        election.castVote("N");
//        election.castVote("N");
//        election.castVote("N");
//        election.castVote("N");
//        election.castVote("N");
//        election.castVote("N");
//        election.castVote("I");
//        election.castVote("p");
//        election.castRandomVote();
//        election.castRandomVote();
//        election.castRandomVote();
//        election.castRandomVote();
//        election.castRandomVote();
//        election.castRandomVote();
//
//
//
//        String[] c = election.getTopKCandidates(4);
//        for(String x: c){
//            System.out.println(x);
//        }
//        election.auditElection();


        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
    }


}