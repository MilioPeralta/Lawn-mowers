package com.blablacar.business;

import com.blablacar.utils.ReaderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a lawn :
 * <p>
 * The lawn is divided in grid to simplify navigation,
 * We have the lower left corner as the point (0,0)
 * and the upperRightCornerCoordinates
 * The lawn has a {@link List<Mower>} inside
 * <p>
 * Created by Milio PERALTA on 12/02/2017.
 */
public class Lawn {
    private Coordinates upperRightCornerCoordinates;
    private List<Mower> mowers;

    /**
     * Construct and initialize a {@link Lawn}
     * with a given upperRightCornerCoordinates and with a list of mowers
     *
     * @param upperRightCornerCoordinates
     * @param mowers
     */
    public Lawn(Coordinates upperRightCornerCoordinates, List<Mower> mowers) {
        this.upperRightCornerCoordinates = upperRightCornerCoordinates;
        this.mowers = mowers;
    }

    /**
     * Construct and initialize a {@link Lawn}
     * according to the lines from the input file
     *
     * @param filePath
     */
    public Lawn(String filePath) {
        ReaderUtils readerUtils = new ReaderUtils(filePath);
        List<String> lines = readerUtils.read();

        if (areLinesValid(lines)) {
            // The first line correspond to the coordinate of the upper right corner of the lawn
            this.upperRightCornerCoordinates = new Coordinates(lines.get(0));

            // Each mower has 2 next lines :
            // The first line give mower's starting position and orientation as "X Y O".
            // X and Y being the position and O the orientation.
            // The second line give instructions to the mower to go throughout the lawn.
            // Instructions are characters without spaces.
            // So we go two by two and start at i = 1, as the first line as already been taken care of
            List<Mower> mowers = new ArrayList<>();
            for (int i = 1; i < lines.size(); i += 2) {
                mowers.add(new Mower(lines.get(i), lines.get(i + 1), this.upperRightCornerCoordinates));
            }
            this.mowers = mowers;
            return;
        }

        throw new IllegalArgumentException("Invalid lines if input file");
    }

    /**
     * The file's lines are valid if there are lines
     * and the number of lines is odd
     *
     * @param lines
     * @return
     */
    private boolean areLinesValid(List<String> lines) {
        return !lines.isEmpty() && lines.size() % 2 == 1;
    }

    public void start() {
        if (mowers != null && !mowers.isEmpty()) {
            mowers.forEach(mower -> mower.start(this));
        }
    }

    public Coordinates getUpperRightCornerCoordinates() {
        return upperRightCornerCoordinates;
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
