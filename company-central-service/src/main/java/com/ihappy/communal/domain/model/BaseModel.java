package com.ihappy.communal.domain.model;

import com.ihappy.company.exception.CompanyException;

/**
 * Created by sunjd on 2018/3/31.
 */
public class BaseModel<T> {
    private T doObject;

    public BaseModel() {
    }

    public BaseModel(T doObject) {
        if (doObject == null) {
            throw new CompanyException(" DO IS NULL");
        }
        this.doObject = doObject;
    }

    public T getDO() {
        return doObject;
    }

    public void setDO(T doObject) {
        this.doObject = doObject;
    }

    public boolean isValid() {
        return this.getDO() != null;
    }
}
