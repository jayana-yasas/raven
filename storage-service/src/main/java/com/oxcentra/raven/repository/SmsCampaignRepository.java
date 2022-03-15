package com.oxcentra.raven.repository;

import com.oxcentra.raven.entity.SmsCampaign;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmsCampaignRepository extends CrudRepository<SmsCampaign, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM sms_campaign a ORDER BY a.lastupdateddate ASC")
    List<SmsCampaign> O();

    @Query(nativeQuery = true, value = "SELECT * FROM sms_campaign  where  status=:status")
    List<SmsCampaign> findByStatus(@Param("status") String status);

    @Query(nativeQuery = true, value = "SELECT * FROM sms_campaign  where  status=:status limit 1")
    SmsCampaign findFirstByStatus(@Param("status") String status);

}
