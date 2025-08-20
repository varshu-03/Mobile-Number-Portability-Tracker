package com.example.mnp.service;
import com.example.mnp.model.Provider;
import com.example.mnp.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderLookupService {

    @Autowired
    private ProviderRepository providerRepository;

    public Provider getProviderById(Integer id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
    }
}
