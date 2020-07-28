package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationDeviceNoException extends AbstractException {
    public DuplicationDeviceNoException() {
        super(Error.DUPLICATION_DEVICE_NO);
    }
}
