package com.unab.catvirtual.catvirtualg31.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genders")
@Data
@Builder
public class Category {
    private String id;
    private String name;
}
