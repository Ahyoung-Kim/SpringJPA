package com.dev.demojpa.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 함수에 붙기 위한 어노테이션
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // 실제로 어느 시점까지 프로그램 상에 존재할 것인가
public @interface LogExecutionTime {
}
