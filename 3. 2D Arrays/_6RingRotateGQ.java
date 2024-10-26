

// Handle scenarios when rows or columns are not even and need to rotate inner most shell
public class _6RingRotateGQ {
    public static void main(String[] args) {
        Character[][] arr = {
                { 'a', 'b', 'c', 'd', 'e' },
                { 'f', 'g', 'h', 'i', 'j' },
                { 'k', 'l', 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's', 't' },
                { 'u', 'v', 'w', 'x', 'y' }
        };

        int shellNo = 2, k = 2;

        // Call the generic method and collect the result
        Object[] shell = getShellArr(arr, shellNo);

        // Rotate the shell array1
        rotateArray(shell, k);

        // Insert the rotated shell back into the array
        insertShell(arr, shell, shellNo);

        // Display the modified 2D array
        display2DArray(arr);
    }

    public static <T> T[] getShellArr(T[][] arr, int shellNo) {
        int up = shellNo - 1, left = shellNo - 1, down = arr.length - shellNo, right = arr[0].length - shellNo;

        int size = (down - up + right - left ) * 2;

        // Create a new Object array
        @SuppressWarnings("unchecked")
        T[] shell = (T[]) new Object[size]; // Using Object[] and casting later
        int index = 0;

        for (int i = up; i <= down; i++) {
            shell[index++] = arr[i][left];
        }

        for (int j = left + 1; j <= right - 1; j++) {
            shell[index++] = arr[down][j];
        }

        for (int i = down; i >= up; i--) {
            shell[index++] = arr[i][right];
        }

        for (int j = right - 1; j >= left + 1; j--) {
            shell[index++] = arr[up][j];
        }

        return shell;
    }

    public static <T> void rotateArray(T[] arr, int k) {
        while (k < 0) {
            k += arr.length;
        }
        k = k % arr.length;

        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static <T> void reverse(T[] arr, int start, int end) {
        while (start < end) {
            T temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static <T> void insertShell(T[][] arr, T[] shell, int shellNo) {
        int up = shellNo - 1, left = shellNo - 1, down = arr.length - shellNo, right = arr[0].length - shellNo;
        int index = 0;
        for (int i = up; i <= down; i++) {
            arr[i][left] = shell[index++];
        }

        for (int j = left + 1; j <= right - 1; j++) {
            arr[down][j] = shell[index++];
        }

        for (int i = down; i >= up; i--) {
            arr[i][right] = shell[index++];
        }

        for (int j = right - 1; j >= left + 1; j--) {
            arr[up][j] = shell[index++];
        }
    }

    public static <T> void display2DArray(T[][] arr) {
        for (T[] row : arr) {
            StringBuilder sb = new StringBuilder();
            for (T ch : row) {
                sb.append(ch);
                sb.append("\t");
            }
            System.out.println(sb.toString());
        }
    }
}
