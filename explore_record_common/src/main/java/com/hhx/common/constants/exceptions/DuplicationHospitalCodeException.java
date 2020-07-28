package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationHospitalCodeException extends AbstractException {
    public DuplicationHospitalCodeException() {
        super(Error.DUPLICATION_HOSPITAL_CODE);
    }
}
