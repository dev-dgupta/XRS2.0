package com.iontrading.practice.persistBean.configurator;

import com.iontrading.isf.committer.spi.MapperException;
import com.iontrading.isf.committer.spi.PersistableFromDomainMapper;
import com.iontrading.isf.committer.spi.PersistableToDomainMapper;

/**
 * Created by divya.gupta on 03-08-2018.
 */
public class PersistableTradeMapper implements PersistableFromDomainMapper<PersistableTrade, DomainTrade>,
        PersistableToDomainMapper<PersistableTrade, DomainTrade> {

    @Override
    public PersistableTrade write(DomainTrade trade) throws MapperException {
        PersistableTrade persistable = new PersistableTrade();
        persistable.setInstrumentId(trade.getInstrumentId());
        persistable.setQty(trade.getQty());
        persistable.setValue(trade.getValue());
        persistable.setVerb(trade.getVerb());
        return persistable;
    }

    @Override
    public Class<? extends DomainTrade> getDomainEntityClass() {
        return DomainTrade.class;
    }

    @Override
    public DomainTrade read(PersistableTrade persistable) throws MapperException {
        DomainTrade trade = new DomainTrade();
        trade.setInstrumentId(persistable.getInstrumentId());
        trade.setQty(persistable.getQty());
        trade.setValue(persistable.getValue());
        trade.setVerb(persistable.getVerb());
        return trade;
    }

    @Override
    public Class<? extends PersistableTrade> getPersistableEntityClass() {
        return PersistableTrade.class;
    }
}