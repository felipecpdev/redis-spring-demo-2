package org.felipecpdev.redisspringdemo2.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("User")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String uuid;
    @TimeToLive
    private Long ttl;
}
