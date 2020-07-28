package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class StudyIsDeletedException extends AbstractException {

    public StudyIsDeletedException() {
        super(Error.STUDY_IS_DELETED_ERROR);
    }
}
