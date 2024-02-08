package ru.job4j.hashmap;

import java.util.*;
import java.util.function.BiFunction;

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
        BiFunction<Double, Double, Double> function = (oldValue, newValue) -> oldValue + newValue;

        for (Pupil pupil : pupils) {
           pupil.subjects().forEach((key)  -> distinctSubjects.merge(key.name(), (double) key.score(), function));
        }
        for (String key: distinctSubjects.keySet()) {
            labels.add(new Label(key, distinctSubjects.get(key) / pupils.size()));
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
        BiFunction<Double, Double, Double> function = (oldValue, newValue) -> oldValue + newValue;
        HashMap<String, Double> distinctSubjects = new HashMap<>();

        for (Pupil pupil : pupils) {
            pupil.subjects().forEach((key)  -> distinctSubjects.merge(key.name(), (double) key.score(), function));
        }
        for (String key : distinctSubjects.keySet()) {
            labels.add(new Label(key, distinctSubjects.get(key)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}