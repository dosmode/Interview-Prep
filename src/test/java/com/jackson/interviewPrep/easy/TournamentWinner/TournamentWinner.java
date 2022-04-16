package com.jackson.interviewPrep.easy.TournamentWinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TournamentWinner {
    @Test
    public void TestCase1() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "Java"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("Java", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 1, 1));
        String expected = "Python";
        var actual = new Program().tournamentWinner(competitions, results);
        assertTrue(expected == actual);
    }
}


class Program {
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        int index = 0;
        HashMap<String, Integer> finalResult = new HashMap<>();

        while (results.size() > index) {
            if (results.get(index) == 1) {
                finalResult.put(competitions.get(index).get(0), finalResult.getOrDefault(competitions.get(index).get(0), 0) + 3);
            } else {
                finalResult.put(competitions.get(index).get(1), finalResult.getOrDefault(competitions.get(index).get(1), 0) + 3);
            }
            index++;
        }
        ArrayList<String> finalString = new ArrayList<>();
        String tempString = "";
        int tempInteger = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : finalResult.entrySet()) {
            if (tempInteger < entry.getValue()) {
                tempString = entry.getKey();
                tempInteger = entry.getValue();
            }
        }


        return tempString;
    }
}

