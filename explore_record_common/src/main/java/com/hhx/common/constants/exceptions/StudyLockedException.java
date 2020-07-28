package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

public class StudyLockedException extends AbstractException {

    public StudyLockedException() {
        super(Error.STUDY_LOCKED);
    }
}
