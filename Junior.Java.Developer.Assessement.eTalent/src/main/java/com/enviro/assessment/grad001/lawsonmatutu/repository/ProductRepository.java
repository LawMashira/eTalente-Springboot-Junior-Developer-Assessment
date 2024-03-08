package com.enviro.assessment.grad001.lawsonmatutu.repository;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>
{
}
