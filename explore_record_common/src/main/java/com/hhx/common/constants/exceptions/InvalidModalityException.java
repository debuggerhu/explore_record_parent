package com.hhx.common.constants.exceptions;

import com.hhx.common.constants.Error;

/**
 * @Author su Lichen
 * @Date 2019/11/22 11:14
 */
public class InvalidModalityException extends AbstractException {

		public InvalidModalityException() {
				super(Error.INVALID_MODALITY);
		}
}
