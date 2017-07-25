package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.Option;
import io.reactivex.Observable;
import java.util.List;

public interface OptionRepository {

    Observable<List<Option>> options();

    Observable<Option> option(final String symbol);
}
