package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationNameException extends AbstractException {
    public DuplicationNameException() {
        super(Error.DUPLICATION_NAME);
    }
}
