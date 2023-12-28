package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        double subjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                score += subj.score();
                subjects++;
            }
        }
        return score / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        double score = 0;

        for (Pupil pupil : pupils) {
            score = AnalyzeByMap.averageScore(List.of(pupil));
            label.add(new Label(pupil.name(), score));
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        HashMap<String, Double> distinctSubjects = new HashMap<>();
        double score = 0;
        int piple = 0;

        for (Pupil pupil : pupils) {
            piple++;
           for (Subject subj : pupil.subjects()) {
               if (distinctSubjects.containsKey(subj.name())) {
                   score = distinctSubjects.get(subj.name());
                   distinctSubjects.remove(subj.name());
               }
               distinctSubjects.putIfAbsent(subj.name(), score + subj.score());
               score = 0;
            }
        }
        for (String key: distinctSubjects.keySet()) {
            double sc = distinctSubjects.get(key) / piple;
            labels.add(new Label(key, sc));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                score += subj.score();
            }
            labels.add(new Label(pupil.name(), score));
            score = 0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        HashMap<String, Double> distinctSubjects = new HashMap<>();
        double score = 0;

        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                if (distinctSubjects.containsKey(subj.name())) {
                    score = distinctSubjects.get(subj.name());
                    distinctSubjects.remove(subj.name());
                }
                distinctSubjects.putIfAbsent(subj.name(), score + subj.score());
                score = 0;
            }
        }
        for (String key : distinctSubjects.keySet()) {
            double sc = distinctSubjects.get(key);
            labels.add(new Label(key, sc));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}