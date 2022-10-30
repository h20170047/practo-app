package com.svj.util;

import java.util.Arrays;
import java.util.List;

public class PromoCodeValidator {
    public static void validatePromoCode(String promoCode){
        List<String> promoCodes= Arrays.asList("code1", "code2", "code3");
        if(!promoCodes.contains(promoCode)){
            throw new RuntimeException("Invalid promocode!!!");
        }
    }
}
