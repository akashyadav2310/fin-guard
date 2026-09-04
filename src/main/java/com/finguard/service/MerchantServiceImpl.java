package com.finguard.service;

import com.finguard.dto.MerchantRequest;
import com.finguard.dto.MerchantResponse;
import com.finguard.entity.Merchant;
import com.finguard.exception.MerchantNotFoundException;
import com.finguard.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public MerchantResponse createMerchant(MerchantRequest request) {

        String merchantId = "MERCHANT-" + UUID.randomUUID();

        Merchant merchant = new Merchant(
                merchantId,
                request.getMerchantName(),
                request.getMerchantType(),
                "ACTIVE",
                LocalDateTime.now()
        );

        Merchant savedMerchant = merchantRepository.save(merchant);

        return mapToResponse(savedMerchant);
    }

    @Override
    public MerchantResponse getMerchant(String merchantId) {

        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() ->
                        new MerchantNotFoundException(
                                "Merchant not found: " + merchantId));

        return mapToResponse(merchant);
    }

    private MerchantResponse mapToResponse(Merchant merchant) {

        return new MerchantResponse(
                merchant.getMerchantId(),
                merchant.getMerchantName(),
                merchant.getMerchantType(),
                merchant.getStatus(),
                merchant.getCreatedAt()
        );
    }
}