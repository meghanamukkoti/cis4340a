public class Validator {
    public static int getAbsAdd(int x, int y) {
        // Validate that neither argument is Integer.MIN_VALUE
        if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Input values must not be Integer.MIN_VALUE");
        }

        int absX = Math.abs(x);
        int absY = Math.abs(y);

        // Check for overflow condition before adding
        if (absX > Integer.MAX_VALUE - absY) {
            throw new IllegalArgumentException("The sum of the absolute values causes an overflow");
        }

        return absX + absY;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Result: " + getAbsAdd(Integer.MIN_VALUE, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
