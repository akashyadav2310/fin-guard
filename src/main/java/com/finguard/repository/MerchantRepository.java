package com.finguard.repository;

import com.finguard.entity.Merchant;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MerchantRepository {

    private final Map<String, Merchant> merchants = new ConcurrentHashMap<>();

    public Merchant save(Merchant merchant) {
        merchants.put(merchant.getMerchantId(), merchant);
        return merchant;
    }

    public Optional<Merchant> findById(String merchantId) {
        return Optional.ofNullable(merchants.get(merchantId));
    }
}