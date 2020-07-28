package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class NoTokenFoundException extends AbstractException {

    public NoTokenFoundException() {
        super(Error.UNAUTHORIZED_USER);
    }
}
