package com.ensark.evdexam;

public class TwoDimensionBubble {

    public static void main(String[] args) {

        int[][] array = {
            {1, 99, 91, 11, 44},
            {0, 10, 9, 9, 11},
            {3, 23, 21, 5, 20},
            {13, 4, 45, 66, 33},
            {11, 0, 1, 20, 56}
        };
        
        for(int[] item : array){
			for(int i = 0; i < item.length-1; i++){
				for(int j =0; j < item.length - i - 1; j++){
					if (item[j] > item[j + 1]) {
                        int temp = item[j];
                        item[j] = item[j + 1];
                        item[j + 1] = temp;
                    }
				}
			}

        }
		System.out.println(Arrays.deepToString(array));
		
    }

}
