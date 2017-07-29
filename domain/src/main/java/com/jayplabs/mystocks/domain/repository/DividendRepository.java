package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.DividendDto;
import io.reactivex.Observable;
import java.util.List;

public interface DividendRepository {

    Observable<List<DividendDto>> dividends();

    Observable<DividendDto> dividend(final String symbol);
}
