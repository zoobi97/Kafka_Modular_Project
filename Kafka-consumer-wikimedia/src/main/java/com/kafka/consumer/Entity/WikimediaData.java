package com.kafka.consumer.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wikimedia_recentchange_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String wikiEventData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWikiEventData() {
        return wikiEventData;
    }

    public void setWikiEventData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }
}
