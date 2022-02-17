package com.oxcentra.raven.repository;

import com.oxcentra.raven.entity.SmsSent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmsSentRepository extends CrudRepository<SmsSent, Integer> {

    @Query(nativeQuery = true, value = "select * from sms_sent " )
    List<SmsSent> findByTagsLike(@Param("selectedtags") String tags);
}
