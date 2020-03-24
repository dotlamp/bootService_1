package com.dotlamp.boot.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //어노테이션 생성될 수 있는 위치 지정(파라미터로 지정 -> 메소드의 파라미터로 선언된 객체만 사용)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { //@interface 파일을 어노테이션으로 지정 (LoginUser 라는 이름을 가진 어노테시연이 생성됨 의미)

    //사용이유: 컨트롤러에서 @LoginUser만 사용하면 세션 정보를 가져오기 위함
}
