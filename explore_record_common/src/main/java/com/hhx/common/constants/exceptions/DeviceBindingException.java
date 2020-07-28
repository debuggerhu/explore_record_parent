package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DeviceBindingException extends AbstractException {

    public DeviceBindingException() {
        super(Error.DEVICE_BINDING);
    }
}
