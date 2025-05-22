package com.ennsko.tuning;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * This caluclator finds the fewest terms 
 * BFS, terms from TuningSet can be added
 * or subtracted
 */
public class FewestTermsCalculator extends TuningCalculator{

    public FewestTermsCalculator(TuningSet tuningSet) {
        super(tuningSet);
    }

    @Override
    public TuningPath path(int target) {
        if (target > 16) {
            target = target % 12;
        }

        Queue<TuningPath> queue = new LinkedList<>();
        Set<Integer> visitedSums = new HashSet<>();

        queue.add(new TuningPath());

        while (!queue.isEmpty()) {
            TuningPath current = queue.poll();
            int currSum = current.sum();

            if (currSum % 12 == target) {
                return current;
            }

            if (visitedSums.contains(currSum)) {
                continue;
            }
            visitedSums.add(currSum);

            for (Interval interval : this.tuningSet) {
                // make new path for adding this interval
                int addSum = currSum + interval.getSemitones();
                TuningPath addPath = new TuningPath(current);
                addPath.add(new Interval(interval));
                queue.add(addPath);

                // make new path for subtracting this interval
                // if result remains positive
                int subSum = currSum - interval.getSemitones();
                if (subSum > 0) {
                    TuningPath subPath = new TuningPath(current);
                    subPath.add(new Interval(interval.flip()));
                    queue.add(subPath);
                }
            }
        }
        
        return null;
    }
  
}
