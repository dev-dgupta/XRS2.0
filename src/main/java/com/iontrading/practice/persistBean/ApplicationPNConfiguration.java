package com.iontrading.practice.persistBean;

import com.iontrading.isf.committer.spi.AbstractPNConfiguration;
import com.iontrading.isf.committer.spi.PNConfigurator;
import com.iontrading.practice.persistBean.configurator.*;

/**
 * Created by divya.gupta on 02-08-2018.
 */
public class ApplicationPNConfiguration extends AbstractPNConfiguration {
    @Override
    public void onConfigure(PNConfigurator config) {
//        config.registerPersistable(PersistableTrade.class).register();
//
//        config.registerDomain(DomainTrade.class)
//                .withPublishable(PublishableTrade.class, new PublishableTradeMapper())
//                .withPersistable(PersistableTrade.class).toDomain(PersistableTradeMapper.class).fromDomain(PersistableTradeMapper.class)
//                .register();

        config.registerPersistable(PersistableTrade.class).register();
        config.registerDomain(DomainTrade.class)
                .withPersistable(PersistableTrade.class).toDomain(PersistableTradeMapper.class).fromDomain(PersistableTradeMapper.class)
                .register();
    }
}
