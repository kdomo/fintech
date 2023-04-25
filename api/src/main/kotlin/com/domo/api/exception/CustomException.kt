package com.domo.api.exception

/**
 * @author domo
 * Created on 2023/04/25
 */
class CustomException(val customErrorCode: CustomErrorCode) : RuntimeException() {
}