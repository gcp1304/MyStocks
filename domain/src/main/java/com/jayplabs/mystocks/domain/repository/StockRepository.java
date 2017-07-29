package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.StockDto;
import io.reactivex.Observable;
import java.util.List;

public interface StockRepository extends Repository {

    Observable<String> createNewStockTrade(StockDto stockDto);

    Observable<Boolean> updateStockTrade(StockDto stockDto);

    Observable<List<StockDto>> getAllStockTrades();

    Observable<StockDto> getStockTrade(String stockId);

    Observable<Boolean> deleteStockTrade(String stockId);
}
