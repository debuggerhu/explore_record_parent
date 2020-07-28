package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationPassException extends AbstractException {
    public DuplicationPassException() {
        super(Error.DUPLICATION_PASSWORD);
    }
}
