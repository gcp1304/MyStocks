package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.ProfileDto;
import io.reactivex.Observable;

public interface ProfileRepository {

    Observable<ProfileDto> profile();
}
