package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.OptionDto;
import io.reactivex.Observable;
import java.util.List;

public interface OptionRepository {

    Observable<List<OptionDto>> options();

    Observable<OptionDto> option(final String symbol);
}
