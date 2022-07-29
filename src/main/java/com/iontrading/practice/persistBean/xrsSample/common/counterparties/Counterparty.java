/*
 * Copyright (c) 2014 ION Trading ltd.
 * All Rights reserved.
 *
 * This software is proprietary and confidential to ION Trading ltd.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.practice.persistBean.xrsSample.common.counterparties;

/**
 */
public class Counterparty {
    private final String id;

    Counterparty(String id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

}
