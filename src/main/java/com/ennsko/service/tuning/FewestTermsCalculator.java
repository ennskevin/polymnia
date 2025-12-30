package com.ennsko.service.tuning;

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

        Queue<TuningPath> queue = new LinkedList<>();
        Set<Integer> visitedSums = new HashSet<>();

        queue.add(new TuningPath());

        while (!queue.isEmpty()) {
            TuningPath current = queue.poll();
            int currSum = current.sum();

            if (currSum % 12 == target % 12) {
                return current;
            }

            if (visitedSums.contains(currSum)) {
                continue;
            }
            visitedSums.add(currSum);

            for (Interval interval : this.tuningSet) {
                // make new path for adding this interval
                TuningPath addPath = new TuningPath(current);
                addPath.add(new Interval(interval));
                queue.add(addPath);

                // make new path for subtracting this interval
                // if result remains positive
                int subSum = currSum - interval.getSemitones();
                if (subSum > 0) {
                    TuningPath subPath = new TuningPath(current);
                    subPath.add(new Interval(interval.flip())); // interval flipped so ratio is <
                    queue.add(subPath);
                }
            }
        }
        
        return null;
    }
  
}
