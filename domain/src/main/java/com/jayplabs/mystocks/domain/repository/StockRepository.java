package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.StockDto;
import io.reactivex.Observable;
import java.util.List;

public interface StockRepository extends Repository {

    Observable<String> createTrade(StockDto stockDto);

    Observable<Boolean> updateTrade(StockDto stockDto);

    Observable<List<StockDto>> getAllTrades();

    Observable<StockDto> retrieveTrade(String stockId);

    Observable<Boolean> deleteTrade(String stockId);
}
