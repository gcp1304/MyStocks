package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.Stock;
import io.reactivex.Observable;
import java.util.List;

public interface StockRepository {

    Observable<List<Stock>> stocks();

    Observable<Stock> stock(final String symbol);
}
