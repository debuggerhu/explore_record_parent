package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

/**
 * @Author su Lichen
 * @Date 2019/11/22 11:14
 */
public class NotFoundHospitalCodeException extends AbstractException {

		public NotFoundHospitalCodeException() {
				super(Error.HOSPITAL_CODE_NOT_FOUND);
		}
}
