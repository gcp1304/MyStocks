package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.interactor.UseCase;

public interface Repository {
    void register(UseCase useCase);

    void unregister(UseCase useCase);
}
