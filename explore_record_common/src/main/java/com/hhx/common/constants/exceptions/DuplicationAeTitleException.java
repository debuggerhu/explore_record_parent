package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationAeTitleException extends AbstractException {
    public DuplicationAeTitleException() {
        super(Error.DUPLICATION_AETITLE);
    }
}
