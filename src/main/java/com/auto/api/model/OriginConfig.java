package com.auto.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.auto.api.common.AbstractOriginConfig;

@Document(collection="OriginConfig")
public class OriginConfig extends AbstractOriginConfig{
}
