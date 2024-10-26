package Revision;

public class _5Rotate90degree {
    public static void main(String[] args) {
        // char[][] arr = { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'h', 'h' }, { 'i', 'j',
        // 'k', 'l' },
        // { 'm', 'n', 'o', 'p' } };

        char[][] arr = { { 'a', 'b', 'c', 'd', 'e' }, { 'f', 'g', 'h', 'i', 'j' }, { 'k', 'l',
                'm', 'n', 'o' }, { 'p', 'q', 'r', 's', 't' }, { 'u', 'v', 'w', 'x', 'y' } };

        display2DArray(arr);

        System.out.println("<--------------------After Transformation---------------------->");
        rotateArray90DegreeRight(arr);

        display2DArray(arr);

    }

    public static void rotateArray90DegreeRight(char[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                char temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                int cols = arr[0].length - 1;

                char temp = arr[i][j];
                arr[i][j] = arr[i][cols - j];
                arr[i][cols - j] = temp;
            }
        }
    }

    public static void display2DArray(char[][] arr) {
        for (char[] row : arr) {
            StringBuilder sb = new StringBuilder();
            for (char ch : row) {
                sb.append(ch);
                sb.append("\t");
            }
            System.out.println(sb.toString());
        }
    }

}
