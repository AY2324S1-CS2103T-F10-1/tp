package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.FlagCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new FlagCommand object
 */
public class FlagCommandParser implements Parser<FlagCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FlagCommand
     * and returns a FlagCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format
     */
    public FlagCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new FlagCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, FlagCommand.MESSAGE_USAGE), pe);
        }
    }
}