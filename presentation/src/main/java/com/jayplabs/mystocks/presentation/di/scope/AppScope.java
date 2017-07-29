package com.jayplabs.mystocks.presentation.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import javax.inject.Singleton;

@Scope
@Retention(RetentionPolicy.RUNTIME)
@Singleton
public @interface AppScope {

}
