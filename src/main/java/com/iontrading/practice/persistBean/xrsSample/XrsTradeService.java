package com.iontrading.practice.persistBean.xrsSample;

import com.iontrading.isf.committer.spi.*;
import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.isf.commons.async.AsyncResultPromise;
import com.iontrading.isf.commons.async.AsyncResults;
import com.iontrading.practice.persistBean.xrsSample.common.Trade;
import com.iontrading.talk.api.annotation.TalkFunction;
import com.iontrading.talk.api.annotation.TalkParam;
import com.iontrading.talk.api.exception.TalkFunctionException;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by divya.gupta on 03-08-2018.
 */
public class XrsTradeService {

    private final CommitterTransactionFactory committer;
    private final Fetcher fetcher;

    @Inject
    public XrsTradeService(CommitterTransactionFactory committer, Fetcher fetcher) {
        this.committer = committer;
        this.fetcher = fetcher;
    }

    /**
     * Provides the trade amendment functionality. When the bus function is
     * invoked:
     * <ul>
     * <li>it creates a new DomainTrade</li>
     * <li>it adds the new created trade to the CommitterTransaction</li>
     * <li>it commits the transaction</li>
     * <li>it replies to the function with the identifier assigned by the
     * persistence_notification engine</li>
     * </ul>
     */
    @TalkFunction
    public AsyncResult<String> processTrade(@TalkParam(name = "InstrumentId") Integer securityType, @TalkParam(name = "Qty") Double qtyNominal,
                                            @TalkParam(name = "Value") BigDecimal price) {

        final AsyncResultPromise<String> asyncResult = AsyncResults.create();

        final Trade domainTrade = new Trade();
        domainTrade.setSecurityType(securityType);
        domainTrade.setQtyNominal(qtyNominal);
        domainTrade.setPrice(price);

        // Create a transaction
        CommitterTransaction transaction = committer.create();
        try {
            // adds the new trade to the CommitterTransaction
            transaction.addOrUpdate(domainTrade, TransactionOperationStrategy.CREATE_NEW_REVISION);
        } catch (Exception e) {
            // A problem in managing the transaction: report it to the caller
            throw new TalkFunctionException(e);
        }

        // We are now ready to commit the transaction
        transaction.commit(new CommitterListener() {

            @Override
            public void onPending(Collection<? extends DomainEntity> entities) {
                System.out.println("Still pending.......");
            }

            @Override
            public void onCommit(Collection<? extends DomainEntity> entities) {
                // Reply to the function with the id assigned by the
                // persistence_notification engine
                System.out.println("Success.......");
                asyncResult.success(domainTrade.getIdentifier().getId());
            }

            @Override
            public void onRollback(Collection<? extends DomainEntity> entities, Throwable t) {
                // A problem in committing the transaction: report it to the
                // caller.
                System.out.println("Failure.......");
                asyncResult.failure(t);
            }

        });

        return asyncResult;
    }

    /**
     * Provides the trade amendment functionality. When the bus function is
     * invoked:
     * <ul>
     * <li>it fetches the previous image of the trade through the
     * <code>Fetcher</code>, using the P&N identifier as the key
     * <li>it creates a new <code>DomainTrade</code> by providing the previous
     * trade image
     * <li>it adds the new created trade to the CommitterTransaction with the
     * strategy CREATE_NEW_REVISION
     * <li>it commits the change
     * <li>it replies to the function with the new revision assigned by the
     * persistence_notification engine
     * </ul>
     */
    @TalkFunction
    public AsyncResult<String> amendTrade(@TalkParam(name = "InstrumentId") Integer securityType, @TalkParam(name = "Qty") Double qtyNominal,
                                          @TalkParam(name = "Value") BigDecimal price) {

        final AsyncResultPromise<String> asyncResult = AsyncResults.create();

        // fetch the previous image of the trade
        final Trade previous = fetcher.findById(Trade.class, securityType);
        if (previous == null) {
            throw new TalkFunctionException("Trade not found");
        } else {

            // creates a new DomainTrade by providing the previous trade image
            final Trade domainTrade = new Trade(previous);
            domainTrade.setSecurityType(securityType);
            domainTrade.setQtyNominal(qtyNominal);
            domainTrade.setPrice(price);
            // Create a transaction
            CommitterTransaction transaction = committer.create();
            try {
                // adds the new trade to the CommitterTransaction
                transaction.addOrUpdate(domainTrade, TransactionOperationStrategy.UPDATE_EXISTING_REVISION);
            } catch (Exception e) {
                // A problem in managing the transaction: report it to the
                // caller
                throw new TalkFunctionException(e);
            }

            // We are now ready to commit the transaction
            transaction.commit(new CommitterListener() {

                @Override
                public void onPending(Collection<? extends DomainEntity> entities) {
                    System.out.println("Still pending.......");
                }

                @Override
                public void onCommit(Collection<? extends DomainEntity> entities) {
                    // Reply to the function with the id assigned by the
                    // persistence_notification engine
                    asyncResult.success(domainTrade.getIdentifier().getId());
                    System.out.println("Success.......");
                }

                @Override
                public void onRollback(Collection<? extends DomainEntity> entities, Throwable t) {
                    // A problem in committing the transaction: report it to the
                    // caller.
                    asyncResult.failure(t);
                    System.out.println("Failure.......");
                }

            });

            return asyncResult;
        }
    }

}
