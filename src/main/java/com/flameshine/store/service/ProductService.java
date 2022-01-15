package com.flameshine.store.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.store.entity.Product;

/**
 * Service for the basic interactions with {@link com.flameshine.store.entity.Product} entity.
 */

public interface ProductService {

    Page<Product> findAllPageable(Pageable pageable);

    Optional<Product> findById(Long id);
}