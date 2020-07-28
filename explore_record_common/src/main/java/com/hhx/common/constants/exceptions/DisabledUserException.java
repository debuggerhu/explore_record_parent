package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DisabledUserException extends AbstractException {
    public DisabledUserException() {
        super(Error.DISABLED_USER);
    }
}
