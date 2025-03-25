package com.aps.projectmanage.service.impl;

import com.aps.projectmanage.domain.dto.CommentDTO;
import com.aps.projectmanage.domain.entity.Comment;
import com.aps.projectmanage.domain.repository.CommentRepository;
import com.aps.projectmanage.domain.repository.TaskRepository;
import com.aps.projectmanage.domain.repository.UserRepository;
import com.aps.projectmanage.payload.CommentPayload;
import com.aps.projectmanage.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public CommentDTO createComment(int userId, int taskId, CommentPayload payload) {
        Comment comment = modelMapper.map(payload, Comment.class);
        comment.setTask(taskRepository.getById(taskId));
        comment.setUser(userRepository.getById(userId));
        commentRepository.save(comment);
        return modelMapper.map(comment, CommentDTO.class);
    }

    @Override
    public List<CommentDTO> getCommentsByTaskId(int taskId) {
        List<CommentDTO> commentDTO = commentRepository.findByTaskIdOrderByCreatedAtDesc(taskId)
                .stream().map(comment->modelMapper.map(comment,CommentDTO.class))
                .collect(Collectors.toList());
        return commentDTO;
    }

    @Override
    public int deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
