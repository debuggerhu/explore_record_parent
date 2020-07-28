package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class InvalidKeyException extends AbstractException {

    public InvalidKeyException() {
        super(Error.INVALID_KEY);
    }
}
