package Worksheet.TwoPointerExercises;

public class readWrite {
    //example one
    public static int efficentDeduplication(int[]data){
        int write = 1;

        for (int read = 1; read < data.length; read++) {
            if(data[read] != data[write -1]) {
                data[write] = data[read];
                write++;
            }
        }
        for (int i = write; i < data.length; i++) {
            data[i] = 0;
        }
        return write;
    }

}
