package com.aps.projectmanage.service;

import com.aps.projectmanage.domain.dto.UserCacheData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String, UserCacheData> redisTemplate;

    private static final String USER_CACHE_PREFIX = "USER_CACHE:";

    public void saveUserData(String userId, Map<Integer, List<String>> projectPermissions, List<String> roles) {
        String key = USER_CACHE_PREFIX + userId;

        UserCacheData userCacheData = new UserCacheData(projectPermissions, roles);

        redisTemplate.opsForValue().set(key, userCacheData, Duration.ofHours(24));
    }

    public UserCacheData getUserData(String userId) {
        String key = USER_CACHE_PREFIX + userId;
        return (UserCacheData) redisTemplate.opsForValue().get(key);
    }

    public void evictUserCache(String userId) {
        String key = USER_CACHE_PREFIX + userId;
        redisTemplate.delete(key);
    }

    public void clearAllCache() {
        Set<String> keys = redisTemplate.keys("*");
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }
}

