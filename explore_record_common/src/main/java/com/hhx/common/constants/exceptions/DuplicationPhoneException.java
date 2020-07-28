package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationPhoneException extends AbstractException {
    public DuplicationPhoneException() {
        super(Error.DUPLICATION_PHONE);
    }
}
