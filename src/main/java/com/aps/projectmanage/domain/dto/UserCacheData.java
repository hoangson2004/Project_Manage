package com.aps.projectmanage.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCacheData implements Serializable {
    private Map<Integer, List<String>> projectPermissions;
    private List<String> roles;
}