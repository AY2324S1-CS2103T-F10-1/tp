package seedu.address.model.booking.exceptions;

/**
 * Signals that the operation is unable to find the specified room.
 */
public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException() {
        super("No room was found");
    }
}
