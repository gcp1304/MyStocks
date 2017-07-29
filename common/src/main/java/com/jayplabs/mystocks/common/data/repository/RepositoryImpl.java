package com.jayplabs.mystocks.common.data.repository;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.common.data.store.EntityStore;
import com.jayplabs.mystocks.domain.interactor.UseCase;
import com.jayplabs.mystocks.domain.repository.Repository;
import java.util.HashMap;
import java.util.Map;

public abstract class RepositoryImpl
    <ENTITY_STORE extends EntityStore,
        ENTITY_DTO_MAPPER extends BaseMapper> implements Repository {

    protected ENTITY_STORE mDataStore;


    protected ENTITY_DTO_MAPPER mEntityDtoMapper;

    protected  final Map<String, UseCase> mUseCaseMap = new HashMap<>();

    public RepositoryImpl(ENTITY_STORE dataStore, ENTITY_DTO_MAPPER entityDtoMapper) {
        mDataStore = dataStore;
        mEntityDtoMapper = entityDtoMapper;
    }

    @Override
    public void register(UseCase useCase) {
        if (useCase != null) {
            mUseCaseMap.put(useCase.toString(), useCase);
        }
    }

    @Override
    public void unregister(UseCase useCase) {
        if (useCase != null) {
            mUseCaseMap.remove(useCase.toString());
        }
    }
}
