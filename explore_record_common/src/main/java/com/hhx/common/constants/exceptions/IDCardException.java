package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class IDCardException extends AbstractException {
    public IDCardException() {
        super(Error.IDCARD_FORMAT_ERROR);
    }
}
