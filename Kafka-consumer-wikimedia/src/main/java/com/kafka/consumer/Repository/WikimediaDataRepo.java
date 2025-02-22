package com.kafka.consumer.Repository;


import com.kafka.consumer.Entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepo extends JpaRepository<WikimediaData,Long> {

}
