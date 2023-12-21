package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int j = evenElements.size();
        for (int i = 0; i < j; i++) {
            if (i % 2 == 0) {
                str.append(evenElements.poll().charValue());
            } else {
                evenElements.poll();
            }
        }
        return str.toString();
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        int j = descendingElements.size();
        for (int i = 0; i < j; i++) {
            str.append(descendingElements.pollLast().charValue());
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}