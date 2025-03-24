package com.aps.projectmanage.payload;

import jakarta.validation.Valid;
import lombok.*;

@Valid
@Data
public class UpdateTaskPayload {
    private String status;
}
