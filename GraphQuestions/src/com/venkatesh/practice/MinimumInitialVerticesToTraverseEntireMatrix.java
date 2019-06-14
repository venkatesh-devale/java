package com.venkatesh.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumInitialVerticesToTraverseEntireMatrix {
    
    class MatrixNode {
    	private int i;
    	private int j;
    	private int cellValue;

    	public MatrixNode(int i, int j, int cellValue) {
    		this.i = i;
    		this.j = j;
    		this.cellValue = cellValue;
    	}

    	public int getI() {
    		return this.i;
    	}

    	public int getJ() {
    		return this.j;
    	}

    	public int getCellValue() {
    		return this.cellValue;
    	}

    	@Override
    	public String toString() {
    		return "Cell Value: "+ this.cellValue + ", i: "+ this.i + ", j: "+ this.j+" \n";
    	}
    }


    public void printMinimumInitialVertices(int[][] matrix) {
    	int rows = matrix.length;
    	int cols = matrix[0].length;

    	//sort the list to traverse in increasing order of matrix cell value
    	List<MatrixNode> list = new ArrayList<>();
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			list.add(new MatrixNode(i,j,matrix[i][j]));
    		}	
    	}

    	list.sort(Comparator.comparing(MatrixNode::getCellValue));
		boolean[][] visited = new boolean[matrix.length][matrix.length];
    	for(int i=list.size()-1;i>=0;i--) {
    		MatrixNode temp = list.get(i);
    		int _i = temp.getI();
    		int _j = temp.getJ();

    		if(!visited[_i][_j]) {
				System.out.println("["+_i+", "+_j+"]");
    			helperDFS(matrix, _i, _j, visited);
			}
		}
    }

    private void printMatrix(int[][] matrix) {
    	for(int i=0;i<matrix.length;i++) {
    		for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void helperDFS(int[][] matrix, int i, int j, boolean[][] visited) {

		visited[i][j] = true;

//		System.out.println("--------------------------------");
//		printMatrix(matrix);
    	//check left
		if(j-1 >= 0 && !visited[i][j-1] && matrix[i][j-1] <= matrix[i][j])
			helperDFS(matrix, i, j-1, visited);

		//check right
		if(j+1 < matrix[0].length && !visited[i][j+1] && matrix[i][j+1] <= matrix[i][j])
			helperDFS(matrix, i, j+1, visited);

		//check above
		if(i-1 >= 0 && !visited[i-1][j] && matrix[i-1][j] <= matrix[i][j])
			helperDFS(matrix, i-1, j, visited);

		//check below
		if(i+1 < matrix.length && !visited[i+1][j] && matrix[i+1][j] <= matrix[i][j])
			helperDFS(matrix, i+1, j, visited);


	}
}
