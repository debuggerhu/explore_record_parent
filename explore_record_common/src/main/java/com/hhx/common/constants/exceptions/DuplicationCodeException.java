package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationCodeException extends AbstractException {
    public DuplicationCodeException() {
        super(Error.DUPLICATION_CODE);
    }
}
