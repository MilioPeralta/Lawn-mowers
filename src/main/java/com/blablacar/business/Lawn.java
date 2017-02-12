package main.java.com.blablacar.business;

import main.java.com.blablacar.utils.ReaderUtils;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

/**
 * Representation of a lawn :
 * <p>
 * The lawn is divided in grid to simplify navigation, represented as a 2D array
 * The lawn has a {@link List<Mower>} inside
 * <p>
 * Created by Milio PERALTA on 12/02/2017.
 */
public class Lawn {
    private int[][] grid;
    private List<Mower> mowers;

    public Lawn() {
    }

    /**
     * Construct and initialize a {@link Lawn}
     * with a given grid and with a list of mowers
     *
     * @param grid
     * @param mowers
     */
    public Lawn(int[][] grid, List<Mower> mowers) {
        this.grid = grid;
        this.mowers = mowers;
    }

    public Lawn(String filePath) {
        ReaderUtils readerUtils = new ReaderUtils(filePath);
        List<String> lines = readerUtils.read();

        if (!lines.isEmpty()) {
            // The first line correspond to the coordinate of the upper right corner of the lawn
            Coordinates upperRightCornerCoordinates = new Coordinates(lines.get(0));
            this.grid = new int[upperRightCornerCoordinates.getX()][upperRightCornerCoordinates.getY()];

            // Each mower has 2 next lines :
            // The first line give mower's starting position and orientation as "X Y O".
            // X and Y being the position and O the orientation.
            // The second line give instructions to the mower to go throughout the lawn.
            // Instructions are characters without spaces.
            // So we go two by two and start at i = 1, as the first line as already been taken care of
            List<Mower> mowers = new ArrayList<>();
            for (int i = 1; i < lines.size(); i += 2) {
                mowers.add(new Mower(lines.get(i), lines.get(i + 1)));
            }
            this.mowers = mowers;
        }
    }

    public void start() {
        if (mowers != null && !mowers.isEmpty()) {
            mowers.forEach(mower -> mower.start(this));
        }
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    public int[][] getGrid() {
        return grid;
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
