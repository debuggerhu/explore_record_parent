package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationHospitalNameException extends AbstractException {
    public DuplicationHospitalNameException() {
        super(Error.DUPLICATION_HOSPITAL_NAME);
    }
}
