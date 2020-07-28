package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DoNotModifyAdminException extends AbstractException {
    public DoNotModifyAdminException() {
        super(Error.ADMIN_USER);
    }
}
