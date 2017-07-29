package com.jayplabs.mystocks.domain.repository;

import com.jayplabs.mystocks.domain.objects.CashDto;
import io.reactivex.Observable;
import java.util.List;

public interface CashRepository extends Repository {

    Observable<String> createTransaction(CashDto cashDto);

    Observable<Boolean> updateTransaction(CashDto cashDto);

    Observable<List<CashDto>> getAllTransactions();

    Observable<CashDto> retrieveTransaction(String transactionId);

    Observable<Boolean> deleteTransaction(String transactionId);
}
