package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.Dividend;
import io.reactivex.Observable;
import java.util.List;

public interface DividendRepository {

    Observable<List<Dividend>> dividends();

    Observable<Dividend> dividend(final String symbol);
}
