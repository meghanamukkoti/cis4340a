package main;

import java.io.DataInputStream;
import java.io.IOException;

public class UnsignedIntegerReader {
    public static void main(String[] args) {
        // Initialize DataInputStream for user input and handle potential exceptions
        try (DataInputStream userInputStream = new DataInputStream(System.in)) {
            long unsignedIntValue = readUnsignedInteger(userInputStream);
            System.out.println("Unsigned Integer: " + unsignedIntValue);
        } catch (IOException exception) {
            System.err.println("Error reading from input stream.");
            exception.printStackTrace();
        }
    }

    /**
     * Reads an unsigned 32-bit integer from the provided data input stream and returns it as a long.
     *
     * @param inputStream The data input stream to read the integer from.
     * @return The unsigned 32-bit integer, represented as a long to accommodate the full range.
     * @throws IOException If there is an error reading from the input stream.
     */
    public static long readUnsignedInteger(DataInputStream inputStream) throws IOException {
        // Read an integer from the stream and apply a bitmask to handle it as unsigned
        return inputStream.readInt() & 0xFFFFFFFFL;
    }
}
