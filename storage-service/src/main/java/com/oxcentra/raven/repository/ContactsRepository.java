package com.oxcentra.raven.repository;

import com.oxcentra.raven.entity.Contacts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactsRepository extends CrudRepository<Contacts, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM contacts a ORDER BY a.lastupdateddate ASC")
    List<Contacts> O();

    @Query(nativeQuery = true, value = "select * from contacts a where a.tags like %:selectedtags% " )
    List<Contacts> findByTagsLike(@Param("selectedtags") String tags);
}
