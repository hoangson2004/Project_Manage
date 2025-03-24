package com.aps.projectmanage.payload;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Valid
@Data
public class CommentPayload {
    @NotBlank
    private String content;
}
