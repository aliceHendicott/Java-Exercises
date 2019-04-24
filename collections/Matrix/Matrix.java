package coll.Matrix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * A generic 2D-matrix.
 * @param <E> the cell type.
 */
public class Matrix<E> implements Iterable {

    private ArrayList<ArrayList<E>> matrix;
    private int numRows;
    private int numCols;

    /**
     * Constructs a Matrix.
     *
     * @param rows - the number of rows.
     * @param columns - the number of columns.
     */
    public Matrix (int rows, int columns) {
        matrix = new ArrayList<ArrayList<E>>(rows);
        for (int i = 0; i<rows; i++) {
            matrix.add(new ArrayList<E>(columns));
            for(int j = 0; j<columns; j++) {
                matrix.get(i).add(null);
            }
        }
        this.numCols = columns;
        this.numRows = rows;
    }

    /**
     * Assigns a value to a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @param value - the value to be assigned to the given cell.
     */
    public void insert(int row, int column, E value) {
        matrix.get(row).set(column, value);
    }

    /**
     * Gets the value at a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @return the value located at the given cell.
     */
    public E get(int row, int column) {
        System.out.println("running get function for row " + row + " and column " + column);
        return matrix.get(row).get(column);
    }

    /**
     * Gets the total number of cells in the matrix.
     *
     * @return an int equal to the total number of cells in the matrix.
     */
    public int size() {
        System.out.println("running size function");
        int totalCells = numCols * numRows;
        return totalCells;
    }

    /**
     * Converts the matrix to String format.
     *
     * @return a String representation of the matrix.
     */
    public String toString() {
        String str = "";
        for(int j = 0; j < numRows; j++){
            for (int i = 0; i < numCols; i++){
                if (i == numCols-1){
                    str = str.concat(matrix.get(j).get(i).toString());
                } else{
                    str = str.concat(matrix.get(j).get(i).toString() + "\t");
                }
            }
            if (j != numRows-1){
                str = str.concat("\n");
            }
        }
        return str;
    }

    /**
     * Gets an iterator for the matrix. The iterator follows column-major order.
     *
     * @return an iterator for the matrix.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentRow = -1;
            private int currentCol = 0;

            @Override
            public boolean hasNext() {
                if ((currentRow == numRows - 1) && (currentCol == numCols - 1)){
                    return false;
                } else{
                    return true;
                }
            }

            @Override
            public E next() {
                if (currentRow != numRows-1){
                    currentRow++;
                    return matrix.get(currentRow).get(currentCol);
                } else{
                    currentRow = 0;
                    currentCol++;
                    return matrix.get(currentRow).get(currentCol);
                }

            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}