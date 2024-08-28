package com.example.capstion3.Repository;


import com.example.capstion3.Model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    Subscription findSubscriptionById(Integer id);
    List<Subscription> findSubscriptionBySubscriptionType(String Subscription_type);
}
