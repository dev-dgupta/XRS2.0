/*
 * Copyright (c) 2014 ION Trading ltd.
 * All Rights reserved.
 *
 * This software is proprietary and confidential to ION Trading ltd.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.practice.persistBean.xrsSample.common.counterparties;

import java.util.*;

/**
 * Should be done via Repository.
 */
public class CounterpartyUtils {

    /*
     * We handle a hardwired set of counterparties
     */
    private static final List<String> banks;
    private static final Map<String, Integer> idByName;
    private static final Map<String, Counterparty> cptyByName;
    static {
        banks = Arrays.asList(new String[] { "HSBC", "BNP", "JPMorgan", "Barclays", "DB", "BAML", "Citi", "SocGen",
                "Mizuho", "RBS" });
        idByName = new HashMap<String, Integer>();
        cptyByName = new HashMap<String, Counterparty>();
        int i = 0;
        for (String bank : banks) {
            idByName.put(bank, i++);
            cptyByName.put(bank, new Counterparty(bank));
        }
    }

    public static Collection<String> getBanks() {
        return banks;
    }

    public static Integer idToIdx(String cpty) {
        Integer idx = CounterpartyUtils.idByName.get(cpty);
        if (idx != null) {
            return idx;
        } else {
            throw new IllegalArgumentException("Unknown counterparty " + cpty);
        }
    }

    public static Counterparty counterpartyFromIdx(int idx) {
        if (idx >= banks.size())
            throw new IllegalArgumentException("Bad counterparty index" + idx);
        return CounterpartyUtils.cptyByName.get(banks.get(idx));
    }

}
