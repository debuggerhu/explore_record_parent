package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class SynchroRegisterParamException extends AbstractException {

    public SynchroRegisterParamException() {
        super(Error.PARAM_ERROR);
    }
}
