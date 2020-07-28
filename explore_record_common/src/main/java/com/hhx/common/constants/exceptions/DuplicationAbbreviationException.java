package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationAbbreviationException extends AbstractException {
    public DuplicationAbbreviationException() {
        super(Error.DUPLICATION_ABBREVIATION);
    }
}
