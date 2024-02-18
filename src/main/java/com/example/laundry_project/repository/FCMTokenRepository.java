package com.example.laundry_project.repository;

import com.example.laundry_project.domain.FcmToken.FcmToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface FCMTokenRepository extends JpaRepository<FcmToken,Integer> {

    @Query (nativeQuery = true, value = "SELECT client_token FROM `fcm_token` WHERE client_code = ?1")
    public String getClientTokenByClientCode (int clientCode);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE fcm_token SET client_token = ?1 WHERE client_code = ?2")
    public void updateClientCodeByClientCode (String clientToken, int clientCode);

    @Transactional
    public void deleteByClientCode(int clientCode);

}
