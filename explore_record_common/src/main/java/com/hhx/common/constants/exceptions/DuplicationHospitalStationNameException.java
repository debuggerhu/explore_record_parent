package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class DuplicationHospitalStationNameException extends AbstractException {

    public DuplicationHospitalStationNameException() {
        super(Error.DUPLICATION_HOSPITAL_STATION_NAME);
    }
}
