package com.ihappy.company.common.utils;

public class SequenceBase {

    protected static String getOrderNoMask(Long accountId) {

        if(accountId <= 9999) {
            return String.format("%06d", accountId);
        }

        String idStr = accountId.toString();
        return idStr.substring(idStr.length() - 6, idStr.length());
    }

    public static void main(String[] args) {
        System.out.println(getOrderNoMask(123456L));
        System.out.println(getOrderNoMask(123L));
    }
}
