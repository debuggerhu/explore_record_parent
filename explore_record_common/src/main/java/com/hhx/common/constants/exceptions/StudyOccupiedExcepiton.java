package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;
import lombok.Getter;

/**
 * @Author su Lichen
 * @Date 2020/4/3 17:09
 */
@Getter
public class StudyOccupiedExcepiton extends AbstractException {
    private final String occupyRoom;

    private final String occupyUser;

    public StudyOccupiedExcepiton(String occupyRoom, String occupyUser) {
        super(Error.STUDY_OCCUPIED_ERROR);
        this.occupyRoom = occupyRoom;
        this.occupyUser = occupyUser;
    }
}
